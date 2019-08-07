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

import android.app.Activity;
import android.location.LocationListener;
import android.widget.Toast;
import org.crossmobile.bind.system.AbstractLifecycleBridge;
import org.crossmobile.bridge.Native;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class AndroidLifecycleBridge extends AbstractLifecycleBridge {

    private final ArrayList<WeakReference<Activity>> activitylist = new ArrayList<>();
    private final ArrayList<WeakReference<LocationListener>> locationlist = new ArrayList<>();

    private boolean isQuitting = false;
    boolean errorFound;

    @Override
    public void quit(final String error, final Throwable throwable) {
        if (isQuitting)
            return;
        isQuitting = true;
        super.quit(error, throwable);

        for (WeakReference<Activity> item : activitylist)
            try {
                if (item.get() != null)
                    item.get().finish();
            } catch (Exception e) {
            }
        activitylist.clear();

        MainActivity c = MainActivity.current;
        if (c != null) {
            if (error != null)
                Native.system().postOnEventThread(() -> Toast.makeText(c, error, Toast.LENGTH_LONG).show());
            c.finish();
        }
    }

    @Override
    public void uncaughtException(Thread thread, Throwable thrwbl) {
        errorFound = true;
        super.uncaughtException(thread, thrwbl);
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public long currentAgeInMillis() {
        try {
            return MainActivity.current.getPackageManager().getPackageInfo(MainActivity.current.getApplicationContext().getPackageName(), 0).lastUpdateTime;
        } catch (Exception ignored) {
        }
        return 0;
    }

    @Override
    public Map<String, Object> consumeLaunchOptions() {
        return MainActivity.current().consumeLaunchOptions();
    }

    void register(Activity mapactivity) {
        activitylist.add(new WeakReference<>(mapactivity));
    }

    @Override
    public void splashTerminated() {
    }
}
