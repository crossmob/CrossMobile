/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class WKUserScript extends NSObject {
    private final String source;
    private final int injectionTime;
    private final boolean forMainFrameOnly;

    @CMConstructor("- (instancetype)initWithSource:(NSString *)source \n" +
            "                 injectionTime:(WKUserScriptInjectionTime)injectionTime \n" +
            "              forMainFrameOnly:(BOOL)forMainFrameOnly;")
    public WKUserScript(String source, int injectionTime, boolean WKUserScriptInjectionTime) {
        this.source = source;
        this.injectionTime = injectionTime;
        this.forMainFrameOnly = WKUserScriptInjectionTime;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSString *source;")
    public String source() {
        return source;
    }

    @CMGetter("@property(nonatomic, readonly) WKUserScriptInjectionTime injectionTime;")
    public int injectionTime() {
        return injectionTime;
    }

    @CMGetter("@property(nonatomic, readonly, getter=isForMainFrameOnly) BOOL forMainFrameOnly;")
    public boolean isForMainFrameOnly() {
        return forMainFrameOnly;
    }
}
