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
