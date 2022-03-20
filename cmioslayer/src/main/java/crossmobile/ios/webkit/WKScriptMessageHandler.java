/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public interface WKScriptMessageHandler {
    @CMSelector("- (void)userContentController:(WKUserContentController *)userContentController \n" +
            "      didReceiveScriptMessage:(WKScriptMessage *)message;\n")
    void didReceiveScriptMessage(WKUserContentController userContentController, WKScriptMessage message);
}
