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

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@CMLib(target = CMLibTarget.ANDROID_PLUGIN)
public class ActivityStateListener {

    private static int activityId = 1;
    private final Map<ActivityResultListener, Integer> result = new HashMap<>();
    private final Map<ActivityPermissionListener, Integer> perms = new HashMap<>();
    private final Collection<ActivityLifecycleListener> lifecycle = new HashSet<>();

    private int getNextId() {
        synchronized (this) {
            int newId = activityId++;
            if (activityId == Integer.MAX_VALUE)
                activityId = 1;
            return newId;
        }
    }

    public int register(ActivityResultListener listener) {
        int newId = 0;
        if (listener != null)
            result.put(listener, newId = getNextId());
        return newId;
    }

    public void unregister(ActivityResultListener listener) {
        if (listener != null)
            result.remove(listener);
    }

    public int register(ActivityPermissionListener listener) {
        int newId = 0;
        if (listener != null)
            perms.put(listener, newId = getNextId());
        return newId;
    }

    public void unregister(ActivityPermissionListener listener) {
        if (listener != null)
            perms.remove(listener);
    }

    public void register(ActivityLifecycleListener listener) {
        if (listener != null)
            lifecycle.add(listener);
    }


    public void unregister(ActivityLifecycleListener listener) {
        if (listener != null)
            lifecycle.remove(listener);
    }

    void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (ActivityResultListener key : result.keySet())
            if (requestCode == result.get(key))
                Native.system().safeRun(() -> key.result(resultCode, data));
    }


    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        for (ActivityPermissionListener key : perms.keySet())
            if (requestCode == perms.get(key))
                Native.system().safeRun(() -> key.result(permissions, grantResults));
    }

    void onStart() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(listener::onStart);
    }

    void onPause() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(listener::onPause);
    }

    void onStop() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(listener::onStop);
    }

    void onResume() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(listener::onResume);
    }

    void onDestroy() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(listener::onDestroy);
    }

    void onLowMemory() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(listener::onLowMemory);
    }

    void onCreate(Bundle savedInstanceState) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(() -> listener.onCreate(savedInstanceState));
    }

    void onSaveInstanceState(Bundle outState) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(() -> listener.onSaveInstanceState(outState));
    }

    void onConfigurationChanged(Configuration newConfig) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(() -> listener.onConfigurationChanged(newConfig));
    }

    void onOrientationChanged(int newOrientation) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(() -> listener.onOrientationChanged(newOrientation));
    }

    void onNewIntent(Intent intent) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.system().safeRun(() -> listener.onNewIntent(intent));
    }
}
