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
package org.crossmobile.backend.desktop;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.usernotifications.*;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.NotificationBridge;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.objc.block.VoidBlock2;

import java.util.List;
import java.util.Set;

public class DesktopNotificationsBridge implements NotificationBridge {
    @Override
    public void requestAuthorizationWithOptions(VoidBlock2<Boolean, NSError> completionHandler) {
        Native.system().postOnEventThread(() -> completionHandler.invoke(false, NSError.errorWithDomain("UNNOTIFICATION ERROR", UNErrorCode.NotificationsNotAllowed, null)));
    }

    @Override
    public void getNotificationSettingsWithCompletionHandler(VoidBlock1<UNNotificationSettings> completionHandler) {
    }

    @Override
    public boolean supportsContentExtensions() {
        return false;
    }

    @Override
    public void setNotificationCategories(Set<UNNotificationCategory> categories) {

    }

    @Override
    public void getNotificationCategoriesWithCompletionHandler(VoidBlock1<Set<UNNotificationCategory>> completionHandler) {

    }

    @Override
    public void addNotificationRequest(UNNotificationRequest request, VoidBlock1<NSError> completionHandler) {

    }

    @Override
    public void getPendingNotificationRequestsWithCompletionHandler(VoidBlock1<List<UNNotificationRequest>> completionHandler) {

    }

    @Override
    public void removePendingNotificationRequestsWithIdentifiers(List<String> identifiers) {

    }

    @Override
    public void removeAllPendingNotificationRequests() {

    }

    @Override
    public void getDeliveredNotificationsWithCompletionHandler(VoidBlock1<List<UNNotification>> completionHandler) {

    }

    @Override
    public void removeDeliveredNotificationsWithIdentifiers(List<String> identifiers) {

    }

    @Override
    public void removeAllDeliveredNotifications() {

    }

    @Override
    public void registerForRemoteNotifications() {

    }
}
