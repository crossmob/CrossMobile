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
package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.usernotifications.UNNotification;
import crossmobile.ios.usernotifications.UNNotificationCategory;
import crossmobile.ios.usernotifications.UNNotificationRequest;
import crossmobile.ios.usernotifications.UNNotificationSettings;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.objc.block.VoidBlock2;

import java.util.List;
import java.util.Set;

public interface NotificationBridge {

    void requestAuthorizationWithOptions(VoidBlock2<Boolean, NSError> completionHandler);

    void getNotificationSettingsWithCompletionHandler(VoidBlock1<UNNotificationSettings> completionHandler);

    boolean supportsContentExtensions();

    void setNotificationCategories(Set<UNNotificationCategory> categories);

    void getNotificationCategoriesWithCompletionHandler(VoidBlock1<Set<UNNotificationCategory>> completionHandler);

    void addNotificationRequest(UNNotificationRequest request, VoidBlock1<NSError> completionHandler);

    void getPendingNotificationRequestsWithCompletionHandler(VoidBlock1<List<UNNotificationRequest>> completionHandler);

    void removePendingNotificationRequestsWithIdentifiers(List<String> identifiers);

    void removeAllPendingNotificationRequests();

    void getDeliveredNotificationsWithCompletionHandler(VoidBlock1<List<UNNotification>> completionHandler);

    void removeDeliveredNotificationsWithIdentifiers(List<String> identifiers);

    void removeAllDeliveredNotifications();

    void registerForRemoteNotifications();
}
