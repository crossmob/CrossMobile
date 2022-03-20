/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import crossmobile.ios.uikit.UITextAlignment;
import crossmobile.ios.uikit.UITextField;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bridge.Native;

public class AndroidTextWrapper extends TextWrapper<UIView, AndroidTextWidget, AndroidGraphicsContext> implements TextWatcher {

    private TransformationMethod defaultTransfMode = null;
    private TransformationMethod passwordTransfMode = null;

    private boolean selfChangingText = false;
    private OldState old = null;

    private boolean editable = true;
    private Drawable nativeborder;
    private NativeFont font;

    public AndroidTextWrapper(UIView parent) {
        super(parent);
    }

    @Override
    public AndroidTextWidget newNativeWidget() {
        return new AndroidTextWidget(this, getIOSWidget() instanceof UITextField);
    }

    @Override
    public void setText(String text) {
        Native.lifecycle().runAndWaitOnEventThread(() -> {
            selfChangingText = true;
            getNativeWidget().setText(text);
        });
    }

    @Override
    public String getText() {
        return old != null ? old.oldText : getNativeWidget().getText().toString();
    }

    @Override
    public void setPlaceholder(String placeholder) {
        getNativeWidget().setHint(placeholder);
    }

    @Override
    public String getPlaceholder() {
        return getNativeWidget().getHint() == null ? null : getNativeWidget().getHint().toString();
    }

    @Override
    public boolean isSecure() {
        return getNativeWidget().getTransformationMethod() instanceof PasswordTransformationMethod;
    }

    @Override
    public void setSecure(boolean secureTextEntry) {
        getNativeWidget().setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        if (isSecure() == secureTextEntry)
            return;
        if (defaultTransfMode == null)
            defaultTransfMode = getNativeWidget().getTransformationMethod();

        selfChangingText = true;
        if (secureTextEntry) {
            if (passwordTransfMode == null)
                passwordTransfMode = new PasswordTransformationMethod();
            getNativeWidget().setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
            getNativeWidget().setTransformationMethod(passwordTransfMode);
        } else {
            getNativeWidget().setTransformationMethod(defaultTransfMode);
            getNativeWidget().setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
        }
        selfChangingText = false;
    }

    @Override
    public void setTextColor(int color) {
        getNativeWidget().setTextColor(color);
    }

    @Override
    public int getTextColor() {
        return getNativeWidget().getTextColors().getDefaultColor();
    }

    @Override
    public void setBackgroundColor(int color) {
        getNativeWidget().setBackgroundColor(color);
    }

    @Override
    public void setFont(final NativeFont font) {
        this.font = font;
        Native.lifecycle().runAndWaitOnEventThread(() -> {
            AndroidFont afont = (AndroidFont) font;
            getNativeWidget().setTypeface(afont.typeface);
            switch (System.getProperty("cm.screen.scale")) {
                case "DPI":
                    getNativeWidget().setTextSize(TypedValue.COMPLEX_UNIT_DIP, afont.size);
                    break;
                case "NATIVE":
                    getNativeWidget().setTextSize(TypedValue.COMPLEX_UNIT_PX, afont.size);
                    break;
                default:
                    getNativeWidget().setTextSize(afont.size);
//                getNativeWidget().setTextSize(Native.graphics().metrics().getScaleAverage() * afont.size);
                    break;
            }
        });
    }

    @Override
    public NativeFont getFont() {
        return font;
    }

    @Override
    public int getAlignment() {
        return gravity2alignment(getNativeWidget().getGravity());
    }

    @Override
    public void setAlignment(int alignment) {
        getNativeWidget().setGravity(alignment2gravity(alignment));
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        old = selfChangingText ? null
                : new OldState(start, count, s.toString());
        selfChangingText = false;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (old != null)
            old.setChangeTo(s.subSequence(start, start + count).toString());
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (old != null) {
            if (old.isInvalid())
                old = null;
            else if (!shouldReplace(old.from, old.size, old.toChange)) {
                selfChangingText = true;
                s.replace(old.from, old.from + old.toChange.length(), old.oldText, old.from, old.from + old.size);
                old = null;
            } else {
                old = null;
                didChange();
            }
        }
    }

    private static int alignment2gravity(int alignment) {
        switch (alignment) {
            case UITextAlignment.Center:
                return 0x11;
            case UITextAlignment.Right:
                return 0x05;
            case UITextAlignment.Left:
                return 0x03;
            default:
                return 0x03;
        }
    }

    private static int gravity2alignment(int gravity) {
        switch (gravity) {
            case 0x11:
                return UITextAlignment.Center;
            case 0x05:
                return UITextAlignment.Right;
            case 0x03:
                return UITextAlignment.Left;
            default:
                return 0;
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void drawNativeBorder(boolean status) {
        if (nativeborder == null)
            nativeborder = getNativeWidget().getBackground();
        if (status)
            getNativeWidget().setBackgroundDrawable(nativeborder);
        else
            getNativeWidget().setBackgroundDrawable(null);
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    @Override
    public void setEditable(boolean editable) {
        if (this.editable == editable)
            return;
        this.editable = editable;

        getNativeWidget().setFocusable(editable);
        getNativeWidget().setFocusableInTouchMode(editable);
    }

    private static class OldState {
        private int from;
        private int size;
        private final String oldText;
        private String toChange;

        public OldState(int from, int size, String oldText) {
            this.from = from;
            this.size = size;
            this.oldText = oldText;
        }

        boolean isInvalid() {
            return size == 0 && toChange != null && toChange.length() == 0;
        }

        private void setChangeTo(String toChange) {
            int shift = 0;
            int max = Math.min(size, toChange.length());
            for (int i = 0; i < max; i++)
                if (oldText.charAt(from + i) == toChange.charAt(i))
                    shift++;
                else
                    break;
            from += shift;
            size -= shift;
            this.toChange = toChange.substring(shift);
        }
    }
}
