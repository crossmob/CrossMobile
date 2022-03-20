/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSString;
import crossmobile.ios.uikit.UITextField;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;

import javax.swing.FocusManager;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextLayout;

public class SwingTextFieldWrapper extends SwingTextWrapper<UITextField, SwingTextFieldWrapper.NativeW> {

    private String placeholder;
    private CGSize placeholderMetrics;
    private Border emptyBorder;
    private Border nativeborder;

    public SwingTextFieldWrapper(UITextField parent) {
        super(parent);
    }

    @Override
    public SwingTextFieldWrapper.NativeW newNativeWidget() {
        return new NativeW();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setPlaceholder(String placeholder) {
        if (placeholder == null) {
            if (this.placeholder != null)
                this.placeholder = null;
        } else if (!placeholder.equals(this.placeholder)) {
            this.placeholder = placeholder;
            this.placeholderMetrics = NSString.sizeWithFont(placeholder, getIOSWidget().font());
        }
    }

    @Override
    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    public boolean isSecure() {
        return getNativeWidget().getEchoChar() != '\0';
    }

    @Override
    public void setSecure(boolean secureTextEntry) {
        getNativeWidget().setEchoChar(secureTextEntry ? '*' : '\0');
    }

    @Override
    public void setTextColor(int color) {
        getNativeWidget().setForeground(new Color(color, true));
    }

    @Override
    public int getTextColor() {
        return getNativeWidget().getForeground().getRGB();
    }

    @Override
    public void setBackgroundColor(int color) {
        getNativeWidget().setBackground(new Color(color));
    }

    @Override
    public void setFont(NativeFont font) {
        getNativeWidget().setFont(((SwingFont) font).font);
    }

    @Override
    public NativeFont getFont() {
        return new SwingFont(getNativeWidget().getFont());
    }

    @Override
    public int getAlignment() {
        switch (getNativeWidget().getHorizontalAlignment()) {
            case JTextField.LEFT:
                return crossmobile.ios.uikit.UITextAlignment.Left;
            case JTextField.RIGHT:
                return crossmobile.ios.uikit.UITextAlignment.Right;
            default:
                return crossmobile.ios.uikit.UITextAlignment.Center;
        }
    }

    @Override
    public void setAlignment(int UITextAlignment) {
        int alignment;
        switch (UITextAlignment) {
            case crossmobile.ios.uikit.UITextAlignment.Left:
                alignment = JTextField.LEFT;
                break;
            case crossmobile.ios.uikit.UITextAlignment.Right:
                alignment = JTextField.RIGHT;
                break;
            default:
                alignment = JTextField.CENTER;
        }
        getNativeWidget().setHorizontalAlignment(alignment);
    }

    @Override
    public void setText(String text) {
        getNativeWidget().setText(text);
    }

    @SuppressWarnings("deprecation")
    @Override
    public String getText() {
        return getNativeWidget().getText();
    }

    @Override
    public void drawNativeBorder(boolean drawNative) {
        getNativeWidget().setBorder(drawNative ? nativeborder : emptyBorder);
        getNativeWidget().setOpaque(drawNative);
    }

    @Override
    public boolean isEditable() {
        return getNativeWidget().isEditable();
    }

    @Override
    public void setEditable(boolean editable) {
        getNativeWidget().setEditable(editable);
    }

    public class NativeW extends JPasswordField implements SwingNativeDispatcher.DesktopNativeWidget {

        @SuppressWarnings("OverridableMethodCallInConstructor")
        public NativeW() {
            nativeborder = getBorder();
            emptyBorder = new EmptyBorder(nativeborder.getBorderInsets(this));
            setListeners(this);
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                        e.consume();
                        if (shouldEndEditing())
                            Native.widget().resignFocus();
                    }
                }
            });
            getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    didChange();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    didChange();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                }
            });
            setEchoChar('\0');
        }

        @SuppressWarnings("deprecation")
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (placeholder != null && !placeholder.isEmpty() && getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(0x80000000, true));
                int deltaY = (int) ((getIOSWidget().frame().getSize().getHeight() - placeholderMetrics.getHeight()) / 2f);
                TextLayout layout = new TextLayout(placeholder, g2.getFont(), g2.getFontRenderContext());
                g2.drawString(placeholder, 5, deltaY + layout.getAscent());
                g2.dispose();
            }
        }

        @Override
        public void repaint(long tm, int x, int y, int width, int height) {
            super.repaint(tm, x, y, width, height);
            getIOSWidget().setNeedsDisplay();
        }

        @Override
        public void paint(Graphics g) {
            if (useNativeDrawPipeline)
                try {
                    super.paint(g);
                } catch (Throwable th) {
                    Native.system().error("Unable to paint component", th);
                }
        }

        @Override
        public void superDraw(SwingGraphicsContext cxt) {
            if (!useNativeDrawPipeline)
                try {
                    super.paint(cxt.g2);
                } catch (Throwable th) {
                    Native.system().error("Unable to paint native component", th);
                }
        }

        @Override
        public void setUserInteraction(boolean status) {
            setEnabled(status);
        }

        @Override
        public WidgetWrapper getWrapper() {
            return SwingTextFieldWrapper.this;
        }
    }
}
