/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */


package org.crossmobile.backend.android;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import androidx.multidex.MultiDex;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

import java.util.Collection;
import java.util.HashSet;

@CMLib(target = CMLibTarget.ANDROID)
public class MainApplication extends Application {

    private Collection<ApplicationStateListener> appstates;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP)
            MultiDex.install(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (appstates != null)
            for (ApplicationStateListener listener : appstates)
                listener.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Native.prepare(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (appstates != null)
            for (ApplicationStateListener listener : appstates)
                listener.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (appstates != null)
            for (ApplicationStateListener listener : appstates)
                listener.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (appstates != null)
            for (ApplicationStateListener listener : appstates)
                listener.onTrimMemory(level);
    }

    public void register(ApplicationStateListener listener) {
        if (listener != null) {
            if (appstates == null)
                appstates = new HashSet<>();
            appstates.add(listener);
        }
    }

    public void unregister(ApplicationStateListener listener) {
        if (listener != null && appstates != null)
            appstates.remove(listener);
    }
}
