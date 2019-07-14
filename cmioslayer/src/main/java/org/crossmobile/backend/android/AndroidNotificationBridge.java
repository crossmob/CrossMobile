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
package org.crossmobile.backend.android;

import android.app.NotificationManager;
import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.uikit.UIApplication;
import crossmobile.ios.usernotifications.*;
import org.crossmobile.bridge.NotificationBridge;
import org.crossmobile.bridge.ann.CMAndroidInjections;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.objc.block.VoidBlock2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID, name = "cmnotifications", depends = {@CMLibDepends(groupId = "com.google.firebase",
        pluginName = "firebase-messaging",
        version = "17.1.0", isCMPlugin = false),
        @CMLibDepends(groupId = "com.google.firebase",
                pluginName = "firebase-iid",
                version = "16.2.0", isCMPlugin = false)}, androidInjections = @CMAndroidInjections(appSection = "<service\n" +
        "            android:name=\"org.crossmobile.backend.android.notifications.FirebaseMessagingService\">\n" +
        "            <intent-filter>\n" +
        "                <action android:name=\"com.google.firebase.MESSAGING_EVENT\"/>\n" +
        "            </intent-filter>\n" +
        "</service>", gradleExt = "apply plugin: 'com.google.gms.google-services'", gradleBuildDep = "classpath 'com.google.gms:google-services:4.0.1'"))
public class AndroidNotificationBridge implements NotificationBridge {

    private static final String tag = "Crossmobile Notifications";
    private Map<UNNotificationRequest, VoidBlock1<NSError>> pendingRequests = new ConcurrentHashMap<>();

    @Override
    public void requestAuthorizationWithOptions(VoidBlock2<Boolean, NSError> completionHandler) {
        //allways true
        completionHandler.invoke(true, null);
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
        UNNotificationTrigger trigger = request.trigger();
        if (trigger instanceof UNCalendarNotificationTrigger)
            return;
        else if (trigger instanceof UNLocationNotificationTrigger)
            return;
        else if (trigger instanceof UNTimeIntervalNotificationTrigger)
            return;
    }

    @Override
    public void getPendingNotificationRequestsWithCompletionHandler(VoidBlock1<List<UNNotificationRequest>> completionHandler) {
        completionHandler.invoke(new ArrayList<>(pendingRequests.keySet()));
    }

    @Override
    public void removePendingNotificationRequestsWithIdentifiers(List<String> identifiers) {
        for (UNNotificationRequest request : pendingRequests.keySet())
            if (identifiers.contains(request.identifier()))
                pendingRequests.remove(request);
    }

    @Override
    public void removeAllPendingNotificationRequests() {
        pendingRequests.clear();
    }

    @Override
    public void getDeliveredNotificationsWithCompletionHandler(VoidBlock1<List<UNNotification>> completionHandler) {
        completionHandler.invoke(new ArrayList<>());
    }

    @Override
    public void removeDeliveredNotificationsWithIdentifiers(List<String> identifiers) {
        NotificationManager manager = (NotificationManager) MainActivity.current().getSystemService("NotificationManager");
        for (String id : identifiers)
            try {
                manager.cancel(Integer.parseInt(id));
            } catch (NumberFormatException ex) {
                System.out.println(tag + " :Identifier for Android must be an Integer's String representation");
            }
    }

    @Override
    public void removeAllDeliveredNotifications() {
        System.out.println(MainActivity.current());
        NotificationManager manager = (NotificationManager) MainActivity.current().getSystemService(MainActivity.current().NOTIFICATION_SERVICE);
        System.out.println(manager);
        manager.cancelAll();
    }

    @Override
    public void registerForRemoteNotifications() {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (task.isSuccessful())
                    UIApplication
                            .sharedApplication()
                            .delegate()
                            .didRegisterForRemoteNotificationsWithDeviceToken(UIApplication.sharedApplication(),
                                    NSData.dataWithBytes(task.getResult().getToken().getBytes()));
                else UIApplication
                        .sharedApplication()
                        .delegate()
                        .didFailToRegisterForRemoteNotificationsWithError(UIApplication.sharedApplication(),
                                NSError.errorWithDomain("UNNOTIFICATION ERROR",
                                        (int) UNErrorCode.NotificationsNotAllowed, null));
            }
        });
    }
}
