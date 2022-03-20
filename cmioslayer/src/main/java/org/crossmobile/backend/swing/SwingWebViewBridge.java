/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.uikit.UIView;
import crossmobile.ios.webkit.WKWebView;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.WebViewBridge;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.system.BaseUtils;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.util.Objects;

@CMLib(name = "cmwebkit")
public class SwingWebViewBridge implements WebViewBridge {
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
                webViewConstructor = webViewClass.getConstructor(UIView.class);
                webViewConstructorPriority = priority;
            } catch (NoSuchMethodException e) {
                Native.system().error("Unable to register " + webViewClass.getName(), e);
            }
        }
    }

    @Override
    public WebWrapper<?, SwingGraphicsContext> webView(WKWebView parent) {
        try {
            return webViewConstructor.newInstance(parent);
        } catch (Exception e) {
            return BaseUtils.throwExceptionAndReturn(e);
        }
    }
}
