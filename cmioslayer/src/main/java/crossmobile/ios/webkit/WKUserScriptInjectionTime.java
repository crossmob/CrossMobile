/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class WKUserScriptInjectionTime {
    public static final int AtDocumentStart = 0;
    public static final int AtDocumentEnd = 1;

    private WKUserScriptInjectionTime() {
    }
}
