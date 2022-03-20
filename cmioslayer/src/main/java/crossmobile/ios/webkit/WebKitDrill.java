/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSHTTPURLResponse;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.foundation.NSURLRequest;
import crossmobile.ios.foundation.NSURLResponse;
import org.crossmobile.bind.wrapper.HistoryItem;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

import java.util.Map;

@CMLib(target = CMLibTarget.RUNTIME)
public class WebKitDrill {

    public static WKNavigation navigation() {
        return new WKNavigation();
    }

    public static WKNavigationAction navigationAction(NSURLRequest request, WKFrameInfo sourceFrame, WKFrameInfo targetFrame) {
        return new WKNavigationAction(request, sourceFrame, targetFrame);
    }

    public static WKNavigationResponse navigationResponse(boolean canShowMIMEType, boolean forMainFrame, NSURLResponse response) {
        return new WKNavigationResponse(canShowMIMEType, forMainFrame, response);
    }

    public static WKBackForwardList backForwardList(Iterable<HistoryItem> listProducer, int current) {
        return new WKBackForwardList(listProducer, current);
    }
}
