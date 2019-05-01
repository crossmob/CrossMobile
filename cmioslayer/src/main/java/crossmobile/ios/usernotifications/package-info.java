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
@CMLib(name = "cmnotifications", libs = "UserNotifications.framework", includes = "<UserNotifications/UserNotifications.h>",
        displayName = "Notifications Framework", description = "CrossMobile© Compatibility library for UserNotifications Framework",
        url = "https://crossmobile.tech/usernotifications/",
        androidapp = ""
                + "        <service android:name=\"org.crossmobile.backend.android.notifications.CrossMobileFirebaseMessagingService\">\n"
                + "            <intent-filter>\n"
                + "                <action android:name=\"com.google.firebase.MESSAGING_EVENT\" />\n"
                + "            </intent-filter>\n"
                + "        </service>\n"
                + "        <service android:name=\"org.crossmobile.backend.android.notifications.CrossMobileFirebaseInstanceIdService\">\n"
                + "            <intent-filter>\n"
                + "                <action android:name=\"com.google.firebase.INSTANCE_ID_EVENT\" />\n"
                + "            </intent-filter>\n"
                + "        </service>",
        depends = @CMLibDepends(pluginName = "cmlocation"), target = API_NOUWP,
        params = @CMLibParam(property = "target", description = "Client target", context = XcodeTarget, meta = "com.apple.usernotifications.service")
)
package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibParam;

import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.XcodeTarget;
import static org.crossmobile.bridge.ann.CMLibTarget.API_NOUWP;
