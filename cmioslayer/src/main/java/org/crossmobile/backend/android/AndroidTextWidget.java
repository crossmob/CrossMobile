/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.backend.android;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.view.Gravity;
import android.widget.EditText;
import org.crossmobile.backend.android.AndroidNativeDispatcher.AndroidNativeWidget;
import org.crossmobile.bridge.Native;

import static org.crossmobile.bind.wrapper.WidgetWrapper.useNativeDrawPipeline;

public class AndroidTextWidget extends EditText implements AndroidNativeWidget {

    private AndroidTextWrapper textWrapper;

    public AndroidTextWidget(AndroidTextWrapper textWrapper, boolean asTextField) {
        super(MainActivity.current);
        this.textWrapper = textWrapper;
        addTextChangedListener(textWrapper);
        setInputType(getInputType() | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        if (asTextField) {
            setSingleLine(true);
        } else {
            setGravity(Gravity.TOP | Gravity.LEFT);
            setBackgroundDrawable(null);
        }
    }


    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        if (focused)
            textWrapper.didBeginEditing();
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
    }

    @Override
    public void onEditorAction(int actionCode) {
        if (!textWrapper.shouldEndEditing())
            return;
        textWrapper.didEndEditing();
        super.onEditorAction(actionCode);
    }


    @Override
    public void invalidate() {
        super.invalidate();
        Native.graphics().refreshDisplay();
    }

    @Override
    public void invalidate(Rect dirty) {
        super.invalidate(dirty);
        Native.graphics().refreshDisplay();
    }

    @Override
    public void invalidate(int l, int t, int r, int b) {
        super.invalidate(l, t, r, b);
        Native.graphics().refreshDisplay();
    }

    @Override
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        Native.graphics().refreshDisplay();
    }

    @Override
    public void draw(Canvas canvas) {
        if (useNativeDrawPipeline)
            try {
                super.draw(canvas);
            } catch (Throwable th) {
                Native.system().error("Unable to paint native component", th);
            }
    }

    @Override
    public void superDraw(AndroidGraphicsContext cxt) {
        if (!useNativeDrawPipeline)
            try {
                super.draw(cxt.cv);
            } catch (Throwable th) {
                Native.system().error("Unable to paint native component", th);
            }
    }

    @Override
    public void setUserInteraction(boolean status) {
        setEnabled(status);
    }
}
