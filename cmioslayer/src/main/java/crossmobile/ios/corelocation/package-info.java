/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmlocation", libs = "CoreLocation.framework", includes = "<CoreLocation/CoreLocation.h>",
        displayName = "CoreLocation Framework", description = "CrossMobile© Compatibility library for MapKit and CoreLocation Frameworks",
        params = @CMLibParam(property = "key", description = "Google Maps API key", meta = "com.google.android.geo.API_KEY", context = Android),
        permissions = {"ACCESS_FINE_LOCATION", "ACCESS_NETWORK_STATE", "ACCESS_WIFI_STATE", "INTERNET"},
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.corelocation;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibParam;

import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.Android;
