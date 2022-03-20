/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class WKBackForwardListItem extends NSObject {
    private final NSURL URL;
    private final NSURL initialURL;
    private final String title;

    WKBackForwardListItem(NSURL URL, NSURL initialURL, String title) {
        this.URL = URL;
        this.initialURL = initialURL;
        this.title = title;
    }

    @CMGetter("@property(readonly, copy) NSURL *URL;")
    public NSURL URL() {
        return URL;
    }

    @CMGetter("@property(readonly, copy) NSURL *initialURL;")
    public NSURL initialURL() {
        return initialURL;
    }

    @CMGetter("@property(nullable, readonly, copy) NSString *title;")
    public String title() {
        return title;
    }
}
