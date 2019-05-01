/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
