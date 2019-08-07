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
package org.crossmobile.backend.android.notifications;

import android.content.Intent;
import crossmobile.ios.uikit.UIApplication;
import crossmobile.ios.uikit.UIApplicationLaunchOptionsKey;
import org.crossmobile.bridge.CrossMobilePlugin;
import org.crossmobile.bridge.Native;
import org.robovm.objc.block.VoidBlock1;

import java.util.HashMap;
import java.util.Map;

public class FirebaseInitializer implements CrossMobilePlugin {

    @Override
    public void earlyInitialize(Object context) {
        if (Native.isAndroid())
            com.google.firebase.FirebaseApp.initializeApp((android.content.Context) context);
    }

    @Override
    public void initialize() {
        if (Native.isAndroid()) {
            org.crossmobile.backend.android.MainActivity activity = org.crossmobile.backend.android.MainActivity.current();
            activity.getStateListener().register(new org.crossmobile.backend.android.ActivityLifecycleListener() {
                @Override
                public void onCreate(android.os.Bundle savedInstanceState) {
                    initLaunchOptions(activity.getIntent(), o -> activity.addLaunchOption(UIApplicationLaunchOptionsKey.RemoteNotification, o));
                }

                @Override
                public void onNewIntent(Intent intent) {
                    initLaunchOptions(intent, o -> UIApplication.sharedApplication().delegate().didReceiveRemoteNotification(UIApplication.sharedApplication(), o));
                }
            });
        }
    }

    private void initLaunchOptions(android.content.Intent activity, VoidBlock1<Map<String, Object>> callback) {
        android.os.Bundle extras = activity.getExtras();
        if (extras != null && extras.getString("google.message_id") != null) {
            HashMap<String, Object> remoteNotifications = new HashMap<>();
            for (String key : extras.keySet())
                remoteNotifications.put(key, extras.get(key));
            callback.invoke(remoteNotifications);
        }
    }
}
