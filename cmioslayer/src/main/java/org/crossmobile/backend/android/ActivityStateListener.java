/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.robovm.objc.block.VoidBlock1;

import java.util.*;

@CMLib(target = CMLibTarget.ANDROID)
public class ActivityStateListener {

    private static int activityId = 1;

    private static final Collection<ActivityExtendedResultListener> ALWAYS_REMOVE = Collections.emptyList();
    private final Map<ActivityResultListener, Integer> launch = new LinkedHashMap<>();
    private final Map<ActivityExtendedResultListener, Integer> extlaunch = new LinkedHashMap<>();
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
        int newId = -1;
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
    public boolean launch(ActivityResultListener listener, Intent intent) {
        if (listener != null)
            autoResultListener.add(listener);
        if (intent != null)
            try {
                MainActivity.current.startActivityForResult(intent, registerGlobally(listener));
            } catch (ActivityNotFoundException exception) {
                Native.system().error("Unable to launch Intent", exception);
                Toast.makeText(MainActivity.current, exception.getMessage(), 3);
                return false;
            }
        return true;
    }

    /**
     * Bind directly an activity result listener to the onActivityResult method. This method is used for special cases
     * only, when someone else has triggered the launching of the new Activity.
     * <p>
     * It is strongly recommended not to use this method, but use the launch method instead.
     *
     * @param listener The callback listener
     */
    public void launch(ActivityExtendedResultListener listener, Runnable launcher) {
        if (listener != null) {
            MainActivity.current.startSpying();
            if (launcher != null)
                launcher.run();
            Collection<Integer> requests = MainActivity.current.stopSpying();
            if (requests.isEmpty())
                Toast.makeText(MainActivity.current, "Unable to register Activity callback", 2);
            else
                for (Integer request : requests)
                    extlaunch.put(listener, request);
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
        boolean handled = onAutoRemovable(launch, autoResultListener, requestCode,
                listener -> listener.result(resultCode, data));
        if (!handled)
            onAutoRemovable(extlaunch, ALWAYS_REMOVE, requestCode, listener -> listener.result(requestCode, resultCode, data));
    }

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        onAutoRemovable(perms, autoPermissionListener, requestCode,
                listener -> listener.result(permissions, grantResults));
    }

    private <K> boolean onAutoRemovable(Map<K, Integer> registry, Collection<K> autoRemove, int requestCode, VoidBlock1<K> consumer) {
        Collection<K> activeListeners = new ArrayList<>();
        for (K key : registry.keySet())
            if (requestCode == registry.get(key))
                activeListeners.add(key);
        for (K listener : activeListeners) {
            if (autoRemove == ALWAYS_REMOVE || autoRemove.remove(listener))
                registry.remove(listener);
            Native.lifecycle().safeRun(() -> consumer.invoke(listener));
        }
        return !activeListeners.isEmpty();
    }

    void onStart() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(listener::onStart);
    }

    void onPause() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(listener::onPause);
    }

    void onStop() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(listener::onStop);
    }

    void onResume() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(listener::onResume);
    }

    void onDestroy() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(listener::onDestroy);
    }

    void onLowMemory() {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(listener::onLowMemory);
    }

    void onCreate(Bundle savedInstanceState) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(() -> listener.onCreate(savedInstanceState));
    }

    void onSaveInstanceState(Bundle outState) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(() -> listener.onSaveInstanceState(outState));
    }

    void onConfigurationChanged(Configuration newConfig) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(() -> listener.onConfigurationChanged(newConfig));
    }

    void onOrientationChanged(int newOrientation) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(() -> listener.onOrientationChanged(newOrientation));
    }

    void onNewIntent(Intent intent) {
        for (ActivityLifecycleListener listener : lifecycle)
            Native.lifecycle().safeRun(() -> listener.onNewIntent(intent));
    }
}
