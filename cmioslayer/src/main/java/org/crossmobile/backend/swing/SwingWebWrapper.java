/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSMutableURLRequest;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.uikit.UIWebView;
import crossmobile.ios.uikit.UIWebViewDelegate;
import crossmobile.ios.uikit.UIWebViewNavigationType;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.io.IOException;

public class SwingWebWrapper extends WebWrapper<SwingWebWrapper.NativeW, SwingGraphicsContext> implements HyperlinkListener {

    private boolean isLoading = false;

    public SwingWebWrapper(UIWebView wv) {
        super(wv);
    }

    @Override
    public SwingWebWrapper.NativeW newNativeWidget() {
        return new NativeW();
    }

    @Override
    public void loadRequest(NSURLRequest req) {
        new Thread(() -> {
            try {
                isLoading = true;
                UIWebView wv = getIOSWidget();
                if (wv == null)
                    return;
                UIWebViewDelegate del = wv.delegate();
                if (del != null)
                    del.didStartLoad(wv);
                if ((req instanceof NSMutableURLRequest) && ((NSMutableURLRequest) req).HTTPBody() != null && ((NSMutableURLRequest) req).HTTPBody().length() > 0)
                    getNativeWidget().getDocument().putProperty("javax.desktop.JEditorPane.postdata", SystemUtilities.bytesToString(((NSMutableURLRequest) req).HTTPBody().bytes()));
                getNativeWidget().setPage(req.URL().absoluteString());
            } catch (IOException ex) {
                isLoading = false;
                UIWebView wv = getIOSWidget();
                if (wv == null)
                    return;
                UIWebViewDelegate del = wv.delegate();
                if (del != null)
                    del.didFailLoadWithError(wv, new NSError(NSError.Domain.NSURL, NSError.ErrorCode.Unknown, null));
            }
        }).start();
    }

    @Override
    public void loadHTMLString(String data, String baseURL) {
        JEditorPane ntv = getNativeWidget();
        ntv.setDocument(ntv.getEditorKit().createDefaultDocument());
        ntv.setContentType("text/html");
        ntv.setText(data);
    }

    @Override
    public void reload() {
        Native.lifecycle().notImplemented();
    }

    @Override
    public void goBack() {
        Native.lifecycle().notImplemented();
    }

    @Override
    public void goForward() {
        Native.lifecycle().notImplemented();
    }

    @Override
    public boolean canGoBack() {
        Native.lifecycle().notImplemented();
        return false;
    }

    @Override
    public boolean canGoForward() {
        Native.lifecycle().notImplemented();
        return false;
    }

    @Override
    public String stringByEvaluatingJavaScriptFromString(String script) {
        Native.lifecycle().notImplemented();
        return null;
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        UIWebView wv = getIOSWidget();
        if (wv == null)
            return;

        UIWebViewDelegate del = wv.delegate();
        if (del != null && e.getURL() != null && del.shouldStartLoadWithRequest(wv, NSURLRequest.requestWithURL(NSURL.URLWithString(e.getURL().toString())), UIWebViewNavigationType.LinkClicked))
            Native.system().debug("Will move to URL " + e.getURL(), null);
    }

    @Override
    public boolean isLoading() {
        return isLoading;
    }

    public class NativeW extends JEditorPane implements SwingNativeDispatcher.DesktopNativeWidget {

        @SuppressWarnings({"OverridableMethodCallInConstructor"})
        public NativeW() {
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    //    TextFieldEventPropagate.consumeKeyEvent(pwidget.get(), widget.getCaretPosition(), e.getKeyChar(), true);    // Always click event
                }
            });
            addPropertyChangeListener("page", (PropertyChangeEvent evt) -> {
                isLoading = false;
                // Take care of event that the page  has loaded
                UIWebView wv = getIOSWidget();
                if (wv == null)
                    return;
                getIOSWidget().setNeedsDisplay();

                UIWebViewDelegate del = wv.delegate();
                if (del != null)
                    del.didFinishLoad(wv);
            });
            setEditable(false);
            addHyperlinkListener(SwingWebWrapper.this);
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
                    Native.system().error("Unable to paint component: " + th.toString(), null);
                }
        }

        @Override
        public void superDraw(SwingGraphicsContext cxt) {
            if (!useNativeDrawPipeline)
                try {
                    super.paint(cxt.g2);
                } catch (Throwable th) {
                    Native.system().error("Unable to paint native component: " + th.toString(), null);
                }
        }

        @Override
        public void setUserInteraction(boolean status) {
            setEnabled(status);
        }

        @Override
        public WidgetWrapper getWrapper() {
            return SwingWebWrapper.this;
        }
    }
}
