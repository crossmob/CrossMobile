/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.uikit.UITextField;
import crossmobile.ios.uikit.UITextView;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.WrapperUIBridge;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingWrapperUIBridge implements WrapperUIBridge<JComponent> {

    @Override
    public SwingTextFieldWrapper textField(UITextField parent) {
        return new SwingTextFieldWrapper(parent);
    }

    @Override
    public SwingTextViewWrapper textView(UITextView parent) {
        return new SwingTextViewWrapper(parent);
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public NativeDispatcher newNativeDispatcher(WidgetWrapper nw) {
        return new SwingNativeDispatcher(nw);
    }

    @Override
    public void resignFocus() {
        SwingGraphicsBridge.component.requestFocus();
        SwingGraphicsBridge.component.registerKeyboardNativeTarget(null);
    }

    @Override
    public void requestFocus(JComponent nativeWidget) {
        nativeWidget.requestFocusInWindow();
        SwingGraphicsBridge.component.registerKeyboardNativeTarget(nativeWidget);
    }

    @Override
    @SuppressWarnings({"null", "ConstantConditions"})
    public void setAttached(JComponent nativeWidget, boolean isAttached) {
        Container parent = nativeWidget.getParent();
        boolean isAttachedNow = parent != null;
        if (isAttached == isAttachedNow)
            return;
        if (isAttachedNow) {
            parent.remove(nativeWidget);
            parent.validate();
        } else {
            SwingGraphicsBridge.component.add(nativeWidget);
            SwingGraphicsBridge.component.validate();
        }
    }

    @Override
    public void updateNativeGraphics(String button_up, String button_down) {
        JToggleButton selected = new JToggleButton();
        JToggleButton normal = new JToggleButton();
        JFrame frame = new JFrame();
        frame.getContentPane().removeAll();
        frame.getContentPane().setLayout(new FlowLayout());
        selected.setSelected(true);
        selected.setText(" ");
        frame.getContentPane().add(selected);
        normal.setText(" ");
        frame.getContentPane().add(normal);
        frame.pack();
        grabButtons(normal, button_up);
        grabButtons(selected, button_down);
    }

    private void grabButtons(JToggleButton button, String fname) {
        BufferedImage img = new BufferedImage(button.getWidth(), button.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D gfx = img.createGraphics();
        button.paint(gfx);
        try {
            ImageIO.write(img, "png", new File(fname));
        } catch (IOException ex) {
            Native.system().error("Unable to save local button", ex);
        }
    }
}
