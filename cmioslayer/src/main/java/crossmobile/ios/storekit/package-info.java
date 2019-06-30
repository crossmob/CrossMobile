/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
