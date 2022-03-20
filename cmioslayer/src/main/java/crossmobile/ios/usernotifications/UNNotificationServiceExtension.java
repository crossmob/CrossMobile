/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
