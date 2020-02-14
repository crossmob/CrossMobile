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

import crossmobile.ios.uikit.UITextField;
import crossmobile.ios.uikit.UITextView;
import crossmobile.ios.uikit.UIWebView;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.WrapperBridge;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SwingWrapperBridge implements WrapperBridge<JComponent> {

    private Boolean hasJFX;

    @Override
    public WebWrapper webView(UIWebView parent) {
        if (hasJFX == null) {
            try {
                Class.forName("javafx.scene.web.WebView");
                hasJFX = true;
            } catch (Throwable e) {
                hasJFX = false;
            }
        }
//        return hasJFX ? new JFXWebWrapper(parent) : new SwingWebWrapper(parent);
        return new SwingWebWrapper(parent);
    }

    @Override
    public SwingTextFieldWrapper textField(UITextField parent) {
        return new SwingTextFieldWrapper(parent);
    }

    @Override
    public SwingTextViewWrapper textView(UITextView parent) {
        return new SwingTextViewWrapper(parent);
    }


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
        SwingGraphicsBridge.frame.getContentPane().removeAll();
        SwingGraphicsBridge.frame.getContentPane().setLayout(new FlowLayout());
        selected.setSelected(true);
        selected.setText(" ");
        SwingGraphicsBridge.frame.getContentPane().add(selected);
        normal.setText(" ");
        SwingGraphicsBridge.frame.getContentPane().add(normal);
        SwingGraphicsBridge.frame.pack();
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
