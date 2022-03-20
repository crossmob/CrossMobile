/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURLResponse;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class WKNavigationResponse extends NSObject {
    private final boolean canShowMIMEType;
    private final boolean forMainFrame;
    private final NSURLResponse response;

    WKNavigationResponse(boolean canShowMIMEType, boolean forMainFrame, NSURLResponse response) {
        this.canShowMIMEType = canShowMIMEType;
        this.forMainFrame = forMainFrame;
        this.response = response;
    }

    @CMGetter("@property(nonatomic, readonly) BOOL canShowMIMEType;")
    public boolean canShowMIMEType() {
        return canShowMIMEType;
    }

    @CMGetter("@property(nonatomic, readonly, getter=isForMainFrame) BOOL forMainFrame;")
    public boolean isForMainFrame() {
        return forMainFrame;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSURLResponse *response;")
    public NSURLResponse response() {
        return response;
    }
}
