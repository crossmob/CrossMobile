/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSMutableURLRequest;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.webkit.WKBackForwardList;
import crossmobile.ios.webkit.WKNavigation;
import crossmobile.ios.webkit.WKWebView;
import crossmobile.ios.webkit.WebKitDrill;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bind.wrapper.HistoryItem;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.robovm.objc.block.VoidBlock2;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.Iterator;

@CMLib(name = "cmwebkit")
public class SwingWebWrapper extends WebWrapper<SwingWebWrapper.NativeW, SwingGraphicsContext> implements HyperlinkListener {

    private boolean isLoading = false;

    public SwingWebWrapper(UIView wv) {
        super(wv);
    }

    @Override
    public SwingWebWrapper.NativeW newNativeWidget() {
        return new NativeW();
    }

    @Override
    public WKNavigation loadRequest(NSURLRequest req) {
        WKNavigation nav = getNavigation(req.URL().absoluteString());
        new Thread(() -> {
            try {
                isLoading = true;
                if (getDelegate() != null)
                    getDelegate().didCommitNavigation(getWebView(), nav);

                if ((req instanceof NSMutableURLRequest) && ((NSMutableURLRequest) req).HTTPBody() != null && ((NSMutableURLRequest) req).HTTPBody().length() > 0)
                    getNativeWidget().getDocument().putProperty("javax.desktop.JEditorPane.postdata", SystemUtilities.bytesToString(((NSMutableURLRequest) req).HTTPBody().bytes()));
                getNativeWidget().setPage(req.URL().absoluteString());
            } catch (IOException ex) {
                isLoading = false;
                if (getDelegate() != null)
                    getDelegate().didFailNavigation((WKWebView) getIOSWidget(), nav, new NSError(NSError.Domain.NSURL, NSError.ErrorCode.Unknown, null));
            }
        }).start();
        return nav;
    }

    @Override
    public WKNavigation loadData(String data, String MIMEType, String baseURL) {
        JEditorPane ntv = getNativeWidget();
        ntv.setDocument(ntv.getEditorKit().createDefaultDocument());
        ntv.setContentType(MIMEType);
        ntv.setText(data);
        return getNavigation(baseURL);
    }

    @Override
    public WKNavigation reload() {
        Native.system().notImplemented();
        return getNavigation(getUrl());
    }

    @Override
    public void stopLoading() {
        Native.system().notImplemented();
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String getUrl() {
        return getNativeWidget().getPage().toString();
    }

    @Override
    public double getProgress() {
        Native.system().notImplemented();
        return 0;
    }

    @Override
    public double getMagnification() {
        Native.system().notImplemented();
        return 0;
    }

    @Override
    public WKNavigation goBack() {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public WKNavigation goForward() {
        Native.system().notImplemented();
        return null;
    }

    @Override
    public void evaluateJavaScript(String script, VoidBlock2<Object, NSError> callback) {
        Native.system().notImplemented();
    }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent e) {
        Native.system().error("Should ask delegate to update page", null);
    }

    @Override
    public boolean isLoading() {
        return isLoading;
    }

    @Override
    public WKBackForwardList getBackForwardList() {
        return WebKitDrill.backForwardList(() -> new Iterator<HistoryItem>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public HistoryItem next() {
                return null;
            }
        }, 0);
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
                UIView widget = getIOSWidget();
                if (widget != null) {
                    widget.setNeedsDisplay();
                    if (getDelegate() != null)
                        getDelegate().didFinishNavigation(getWebView(), null);
                }
            });
            setEditable(false);
            addHyperlinkListener(SwingWebWrapper.this);
        }

        @Override
        public void repaint(long tm, int x, int y, int width, int height) {
            super.repaint(tm, x, y, width, height);
            UIView wv = getIOSWidget();
            if (wv != null)
                wv.setNeedsDisplay();
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
