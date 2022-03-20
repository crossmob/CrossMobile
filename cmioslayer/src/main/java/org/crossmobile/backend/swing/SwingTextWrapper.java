/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.uikit.UIView;
import org.crossmobile.bind.wrapper.NativeWrapper;
import org.crossmobile.bind.wrapper.TextWrapper;

import javax.swing.text.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public abstract class SwingTextWrapper<T extends UIView, S extends NativeWrapper<SwingGraphicsContext>> extends TextWrapper<T, S, SwingGraphicsContext> {
    public SwingTextWrapper(T tf) {
        super(tf);
    }

    protected void setListeners(JTextComponent component) {
        ((AbstractDocument) component.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
                if (shouldReplace(offset, length, ""))
                    super.remove(fb, offset, length);
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (shouldReplace(offset, 0, string))
                    super.insertString(fb, offset, string, attr);
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (shouldReplace(offset, length, text))
                    super.replace(fb, offset, length, text, attrs);
            }
        });

        component.addFocusListener(new FocusListener() {
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
}
