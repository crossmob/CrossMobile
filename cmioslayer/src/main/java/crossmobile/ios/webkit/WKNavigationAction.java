/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURLRequest;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class WKNavigationAction extends NSObject {
    private final NSURLRequest request;
    private final WKFrameInfo sourceFrame;
    private final WKFrameInfo targetFrame;

    WKNavigationAction(NSURLRequest request, WKFrameInfo sourceFrame, WKFrameInfo targetFrame) {
        this.request = request;
        this.sourceFrame = sourceFrame;
        this.targetFrame = targetFrame;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSURLRequest *request;")
    public NSURLRequest request() {
        return request;
    }

    @CMGetter("@property(nonatomic, readonly, copy) WKFrameInfo *sourceFrame;")
    public WKFrameInfo sourceFrame() {
        return sourceFrame;
    }

    @CMGetter("@property(nullable, nonatomic, readonly, copy) WKFrameInfo *targetFrame;")
    public WKFrameInfo targetFrame() {
        return targetFrame;
    }
}
