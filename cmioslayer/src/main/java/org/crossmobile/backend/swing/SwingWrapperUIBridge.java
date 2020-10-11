/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.uikit.UITextField;
import crossmobile.ios.uikit.UITextView;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.uikit.UIWebView;
import org.crossmobile.bind.wrapper.NativeDispatcher;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.WrapperUIBridge;
import org.crossmobile.bridge.system.BaseUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Objects;

public class SwingWrapperUIBridge implements WrapperUIBridge<JComponent> {

    private int webViewConstructorPriority = -1;
    private Constructor<? extends WebWrapper<?, SwingGraphicsContext>> webViewConstructor;

    {
        registerWebView(SwingWebWrapper.class, 0);
    }

    /**
     * Register a WebWrapper class to use for future implementations of UIWebView
     *
     * @param webViewClass the Class to use as a constructor
     * @param priority     The priority to use this class. If this class has higher priority than the current one, then
     *                     this class will be used. Otherwise the call to this registration will be ignored. The higher this
     *                     number the bigger the priority. Priority of default  {@link JEditorPane}-based implementation
     *                     is 0.
     */
    public void registerWebView(Class<? extends WebWrapper<?, SwingGraphicsContext>> webViewClass, int priority) {
        Objects.requireNonNull(webViewClass);
        if (priority > webViewConstructorPriority) {
            try {
                webViewConstructor = webViewClass.getConstructor(UIWebView.class);
                webViewConstructorPriority = priority;
            } catch (NoSuchMethodException e) {
                Native.system().error("Unable to register " + webViewClass.getName(), e);
            }
        }
    }

    @Override
    public WebWrapper<?, SwingGraphicsContext> webView(UIView parent) {
        try {
            return webViewConstructor.newInstance(parent);
        } catch (Exception e) {
            return BaseUtils.throwExceptionAndReturn(e);
        }
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
