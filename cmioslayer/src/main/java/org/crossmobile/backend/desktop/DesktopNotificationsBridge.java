/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
        Native.lifecycle().postOnEventThread(() -> completionHandler.invoke(false, NSError.errorWithDomain("UNNOTIFICATION ERROR", UNErrorCode.NotificationsNotAllowed, null)));
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
