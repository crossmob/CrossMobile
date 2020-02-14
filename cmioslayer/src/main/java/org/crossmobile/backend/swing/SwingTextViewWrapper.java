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
package org.crossmobile.backend.swing;

import crossmobile.ios.uikit.UITextView;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SwingTextViewWrapper extends TextWrapper<UITextView, SwingTextViewWrapper.NativeW, SwingGraphicsContext> {

    private int alignment;
    private static final Color clearColor = new Color(0, 0, 0, 0);

    public SwingTextViewWrapper(UITextView parent) {
        super(parent);
    }

    @Override
    public SwingTextViewWrapper.NativeW newNativeWidget() {
        return new NativeW();
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public void setSecure(boolean secureTextEntry) {
    }

    @Override
    public void setTextColor(int color) {
        getNativeWidget().txt.setForeground(new Color(color, true));
    }

    @Override
    public int getTextColor() {
        return getNativeWidget().txt.getForeground().getRGB();
    }

    @Override
    public void setBackgroundColor(int color) {
        getNativeWidget().txt.setBackground(new Color(color));
    }

    @Override
    public void setFont(NativeFont font) {
        getNativeWidget().txt.setFont(((SwingFont) font).font);
    }

    @Override
    public NativeFont getFont() {
        return new SwingFont(getNativeWidget().txt.getFont());
    }

    @Override
    public int getAlignment() {
        return alignment;
    }

    @Override
    public void setAlignment(int UITextAlignment) {
        if (alignment == UITextAlignment)
            return;
        alignment = UITextAlignment;

        StyledDocument doc = getNativeWidget().txt.getStyledDocument();
        SimpleAttributeSet attr = new SimpleAttributeSet();
        switch (UITextAlignment) {
            case crossmobile.ios.uikit.UITextAlignment.Left:
                StyleConstants.setAlignment(attr, StyleConstants.ALIGN_LEFT);
                break;
            case crossmobile.ios.uikit.UITextAlignment.Right:
                StyleConstants.setAlignment(attr, StyleConstants.ALIGN_RIGHT);
                break;
            default:
                StyleConstants.setAlignment(attr, StyleConstants.ALIGN_CENTER);
        }
        doc.setParagraphAttributes(0, doc.getLength(), attr, false);
    }

    @Override
    public void setText(String text) {
        getNativeWidget().txt.setText(text);
    }

    @Override
    public String getText() {
        return getNativeWidget().txt.getText();
    }

    @Override
    public boolean isEditable() {
        return getNativeWidget().txt.isEditable();
    }

    @Override
    public void setEditable(boolean editable) {
        getNativeWidget().txt.setEditable(editable);
    }

    @Override
    public String getPlaceholder() {
        return "";
    }

    @Override
    public void setPlaceholder(String placeholder) {
    }

    @Override
    public void drawNativeBorder(boolean status) {
    }

    public class NativeW extends JScrollPane implements SwingNativeDispatcher.DesktopNativeWidget {

        private final JTextPane txt;

        @SuppressWarnings("OverridableMethodCallInConstructor")
        public NativeW() {
            txt = new JTextPane() {
                {
                    setOpaque(false);
                    setBackground(clearColor);
                    setBorder(null);
                    addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            int caret = txt.getCaretPosition();
                            final String text = txt.getText();
                            switch (e.getKeyChar()) {
                                case KeyEvent.VK_DELETE:
                                    if (caret > 0 && !shouldReplace(caret - 1, 1, ""))
                                        e.consume();
                                    else
                                        didChange();
                                    break;
                                case KeyEvent.VK_BACK_SPACE:
                                    if (caret < (text.length() - 1) && !shouldReplace(caret - 1, 1, ""))
                                        e.consume();
                                    else
                                        didChange();
                                    break;
                                default:
                                    if (!shouldReplace(caret, 0, String.valueOf(e.getKeyChar())))
                                        e.consume();
                                    else
                                        didChange();
                            }
                        }
                    });
                    addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            didBeginEditing();
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            didEndEditing();
                        }
                    });
                }

                @Override
                public void repaint(long tm, int x, int y, int width, int height) {
                    super.repaint(tm, x, y, width, height);
                    Native.graphics().refreshDisplay();
                }
            };

            setViewportView(txt);
            setBorder(BorderFactory.createEmptyBorder());
            setOpaque(false);
            setBackground(clearColor);
            getViewport().setOpaque(false);
        }

        @Override
        public void repaint(long tm, int x, int y, int width, int height) {
            super.repaint(tm, x, y, width, height);
            Native.graphics().refreshDisplay();
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
                    Native.system().error("Unable to paint component", th);
                }
        }

        @Override
        public void setUserInteraction(boolean status) {
            setEnabled(status);
        }

        @Override
        public WidgetWrapper getWrapper() {
            return SwingTextViewWrapper.this;
        }
    }
}
