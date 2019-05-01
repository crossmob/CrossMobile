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
package org.crossmobile.bind.wrapper;

import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.uikit.UIWebView;
import crossmobile.ios.uikit.UIWebViewDelegate;
import org.crossmobile.bind.graphics.GraphicsContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class WebWrapper<NWIDG extends NativeWrapper<GCX>, GCX extends GraphicsContext> extends WidgetWrapper<UIWebView, NWIDG, GCX> {

    public WebWrapper(UIWebView wv) {
        super(wv);
    }

    public abstract void loadRequest(NSURLRequest req);

    public abstract void loadHTMLString(String data, String baseURL);

    public abstract void reload();

    public abstract boolean canGoBack();

    public abstract void goBack();

    public abstract void goForward();

    public abstract boolean canGoForward();

    public abstract String stringByEvaluatingJavaScriptFromString(String script);

    public abstract boolean isLoading();

    protected boolean acceptsURL(String url, int srcType) {
        UIWebView source = getIOSWidget();
        if (source == null)
            return false;
        UIWebViewDelegate delegate = source.delegate();
        if (delegate == null)
            return true;
        NSURLRequest req = NSURLRequest.requestWithURL(NSURL.URLWithString(url));
        return delegate.shouldStartLoadWithRequest(source, req, srcType);
    }

    protected static class HistorySanitizer {
        private List<String> urls = new ArrayList<>();
        private int current;

        public HistorySanitizer(int currentIdx, Iterator<String> urlProvider) {
            current = currentIdx;
            int offset = 0;
            int idx = 0;
            while (urlProvider.hasNext()) {
                String url = urlProvider.next();
                if (url.startsWith("data:")) {
                    if (idx <= current)
                        offset++;
                } else
                    urls.add(url);
                idx++;
            }
            if (offset <= current)
                current -= offset;
        }

        public boolean canGoBack() {
            return current > 0;
        }

        public boolean canGoForth() {
            return current < urls.size() - 1;
        }

        public String thisUrl() {
            return urls.get(current);
        }

        public String nextURL() {
            return canGoForth() ? urls.get(current + 1) : null;
        }

        public String previousURL() {
            return canGoBack() ? urls.get(current - 1) : null;
        }
    }

}
