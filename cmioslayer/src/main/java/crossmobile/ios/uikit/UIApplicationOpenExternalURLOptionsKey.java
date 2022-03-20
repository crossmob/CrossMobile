/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bridge.ann.CMEnum;
import org.robovm.objc.block.VoidBlock1;

import java.util.Map;

/**
 * Define different options when launching URLs through {@link UIApplication#openURL(NSURL, Map, VoidBlock1)}.
 */
@CMEnum
public final class UIApplicationOpenExternalURLOptionsKey {

    /**
     * Open URL only of known types
     */
    public static final String UniversalLinksOnly = "UIApplicationOpenURLOptionUniversalLinksOnly";

    private UIApplicationOpenExternalURLOptionsKey() {
    }
}
