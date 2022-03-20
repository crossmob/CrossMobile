/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmpayment", libs = "StoreKit.framework", includes = "<StoreKit/StoreKit.h>",
        displayName = "in App Payment Framework", description = "CrossMobile© Compatibility library for inAppPayment Framework",
        params = {
                @CMLibParam(property = "key", description = "Google Play inApp key"),
                @CMLibParam(property = "noncosumable", description = "Non consumable products"),
                @CMLibParam(property = "consumable", description = "Consumable products")},
        permissions = "BILLING",
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.storekit;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibParam;
