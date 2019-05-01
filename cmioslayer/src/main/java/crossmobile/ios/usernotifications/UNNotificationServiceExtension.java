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
package crossmobile.ios.usernotifications;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;
import org.robovm.objc.block.VoidBlock1;

@CMClass
public class UNNotificationServiceExtension extends NSObject {

    @CMSelector("- (void)didReceiveNotificationRequest:(UNNotificationRequest *)request \n"
            + "                   withContentHandler:(void (^)(UNNotificationContent *contentToDeliver))contentHandler;")
    public void didReceiveNotificationRequest(UNNotificationRequest request, VoidBlock1<UNNotificationContent> contentHandler) {

    }

    @CMSelector("- (void)serviceExtensionTimeWillExpire;")
    public void serviceExtensionTimeWillExpire() {

    }
}
