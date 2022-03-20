/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class WKSecurityOrigin extends NSObject {
    private final String host;
    private final int port;
    private final String protocol;

    WKSecurityOrigin(String host, int port, String protocol) {
        this.host = host;
        this.port = port;
        this.protocol = protocol;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSString *host;")
    public String host() {
        return host;
    }

    @CMGetter("@property(nonatomic, readonly) NSInteger port;")
    public int port() {
        return port;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSString *protocol;")
    public String protocol() {
        return protocol;
    }
}
