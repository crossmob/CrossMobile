/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;
import org.robovm.objc.block.VoidBlock1;

@CMClass
public interface UNUserNotificationCenterDelegate {

    @CMSelector("- (void)userNotificationCenter:(UNUserNotificationCenter *)center \n"
            + "       willPresentNotification:(UNNotification *)notification \n"
            + "         withCompletionHandler:(void (^)(UNNotificationPresentationOptions options))completionHandler;")
    default void willPresentNotification(UNUserNotificationCenter center, UNNotification notification, VoidBlock1<UNNotificationPresentationOptions> completionHandler) {
    }

    @CMSelector("- (void)userNotificationCenter:(UNUserNotificationCenter *)center \n"
            + "didReceiveNotificationResponse:(UNNotificationResponse *)response \n"
            + "         withCompletionHandler:(void (^)(void))completionHandler;")
    default void didReceiveNotificationResponse(UNUserNotificationCenter center, UNNotificationResponse response, Runnable completionHandler) {
    }
}
