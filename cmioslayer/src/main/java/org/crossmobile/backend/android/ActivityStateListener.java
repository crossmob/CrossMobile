/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.robovm.objc.block.VoidBlock1;

import java.util.*;
import java.util.function.Consumer;

@CMLib(target = CMLibTarget.ANDROID_PLUGIN)
public class ActivityStateListener {

    private static int activityId = 1;
    private final Map<ActivityResultListener, Integer> launch = new LinkedHashMap<>();
    private final Map<ActivityPermissionListener, Integer> perms = new LinkedHashMap<>();
    private final Collection<ActivityLifecycleListener> lifecycle = new LinkedHashSet<>();
    private final Collection<ActivityResultListener> autoResultListener = new HashSet<>();
    private final Collection<ActivityPermissionListener> autoPermissionListener = new HashSet<>();

    private int getNextId() {
        synchronized (this) {
            int newId = activityId++;
            if (activityId == Integer.MAX_VALUE)
                activityId = 1;
            return newId;
        }
    }

    /**
     * Register an activity result for the whole lifecycle of the application
     *
     * @param listener Callback
     * @return the automatically provided request code
     */
    public int registerGlobally(ActivityResultListener listener) {
        int newId = 0;
        if (listener != null)
            launch.put(listener, newId = getNextId());
        return newId;
    }

    /**
     * Launch an intent and get the result
     *
     * @param listener Callback
     * @param intent   The intent to launch
     */
    public void launch(ActivityResultListener listener, Intent intent) {
        if (listener != null) {
            autoResultListener.add(listener);
            MainActivity.current.startActivityForResult(intent, registerGlobally(listener));
        }
    }

    /**
     * Request permissions from the system
     *
     * @param listener    Callback
     * @param permissions list of permissions
     */
    public void request(ActivityPermissionListener listener, Collection<String> permissions) {
        if (listener != null) {
            autoPermissionListener.add(listener);
            int reqCode = getNextId();
            perms.put(listener, reqCode);
            ActivityCompat.requestPermissions(MainActivity.current(), permissions.toArray(new String[0]), reqCode);
        }
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
        onAutoRemovable(launch, autoResultListener, requestCode,
                listener -> listener.result(resultCode, data));
    }

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        onAutoRemovable(perms, autoPermissionListener, requestCode,
                listener -> listener.result(permissions, grantResults));
    }

    private <K> void onAutoRemovable(Map<K, Integer> registry, Collection<K> autoRemove, int requestCode, VoidBlock1<K> consumer) {
        Collection<K> activeListeners = new ArrayList<>();
        for (K key : registry.keySet())
            if (requestCode == registry.get(key))
                activeListeners.add(key);
        for (K listener : activeListeners) {
            if (autoRemove.remove(listener))
                registry.remove(listener);
            Native.system().safeRun(() -> consumer.invoke(listener));
        }
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
