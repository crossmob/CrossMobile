/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.backend.swing;

import crossmobile.ios.foundation.NSMutableURLRequest;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.uikit.UIWebView;
import crossmobile.ios.uikit.UIWebViewDelegate;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import org.crossmobile.bind.wrapper.WebWrapper;
import org.crossmobile.bind.wrapper.WidgetWrapper;
import org.crossmobile.bridge.Native;
import org.w3c.dom.Document;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;

public class JFXWebWrapper extends WebWrapper<JFXWebWrapper.NativeW, SwingGraphicsContext> {

    private boolean isLoading = false;

    JFXWebWrapper(UIWebView wv) {
        super(wv);
    }

    @Override
    public JFXWebWrapper.NativeW newNativeWidget() {
        return new NativeW();
    }

    @Override
    public void loadRequest(NSURLRequest req) {
        Platform.runLater(() -> {
            isLoading = true;
            UIWebView wv = getIOSWidget();
            if (wv == null)
                return;
            UIWebViewDelegate del = wv.delegate();
            if (del != null)
                del.didStartLoad(wv);

            WebView webview = getNativeWidget().webview;

            webview.getEngine().load(req.URL().absoluteString());
            if ((req instanceof NSMutableURLRequest) && ((NSMutableURLRequest) req).HTTPBody() != null) {
                // About post parameters
                // A good place to start is here:
                // https://community.oracle.com/thread/2510161
            }
        });
    }

    @Override
    public void loadHTMLString(String data, String baseURL) {
        Platform.runLater(() -> getNativeWidget().webview.getEngine().loadContent(data));
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

//    @Override
//    public void hyperlinkUpdate(HyperlinkEvent e) {
//        UIWebView wv = getIOSWidget();
//        if (wv == null)
//            return;
//
//        UIWebViewDelegate del = wv.delegate();
//        if (del != null && e.getURL() != null && del.shouldStartLoadWithRequest(wv, NSURLRequest.requestWithURL(NSURL.URLWithString(e.getURL().toString())), UIWebViewNavigationType.LinkClicked))
//            Native.system().debug("Will move to URL " + e.getURL(), null);
//    }

    @Override
    public boolean isLoading() {
        return isLoading;
    }

    public class NativeW extends JFXPanel implements SwingNativeDispatcher.DesktopNativeWidget {
        WebView webview;

        @SuppressWarnings({"OverridableMethodCallInConstructor"})
        public NativeW() {
            Platform.runLater(() -> {
                webview = new WebView();
                setScene(new Scene(webview));
                // It uses the listener paradigm on various parameters
                // Maybe this is not the correct one
                webview.getEngine().documentProperty().addListener(new ChangeListener<Document>() {
                    @Override
                    public void changed(ObservableValue<? extends Document> observableValue, Document document, Document t1) {
                        System.out.println("?? when do we come here");
                    }
                });
            });


            // MIGHT REWORK ON FOLLOWING METHODS
            addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    //    TextFieldEventPropagate.consumeKeyEvent(pwidget.get(), widget.getCaretPosition(), e.getKeyChar(), true);    // Always click event
                }
            });
            addPropertyChangeListener("page", (PropertyChangeEvent evt) -> {
                isLoading = false;
                // Take care of event that the page  has loaded
                UIWebView wv = (UIWebView) getIOSWidget();
                if (wv == null)
                    return;
                Native.graphics().refreshDisplay();

                UIWebViewDelegate del = wv.delegate();
                if (del != null)
                    del.didFinishLoad(wv);
            });
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
                    Native.system().error("Unable to paint native component", th);
                }
        }

        @Override
        public void setUserInteraction(boolean status) {
            setEnabled(status);
        }

        @Override
        public WidgetWrapper getWrapper() {
            return JFXWebWrapper.this;
        }
    }
}
