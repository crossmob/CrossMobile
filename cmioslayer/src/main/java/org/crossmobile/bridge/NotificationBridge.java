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
