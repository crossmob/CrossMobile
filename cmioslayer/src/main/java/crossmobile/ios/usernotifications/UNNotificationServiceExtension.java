/*
 * (c) 2020 by Panayotis Katsaloulis
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
