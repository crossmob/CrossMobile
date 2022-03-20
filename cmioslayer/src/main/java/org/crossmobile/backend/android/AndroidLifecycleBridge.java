/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.app.Activity;
import android.location.LocationListener;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.View;
import android.widget.Toast;
import crossmobile.ios.foundation.NSTimer;
import org.crossmobile.bind.graphics.anim.Animator;
import org.crossmobile.bind.system.AbstractLifecycleBridge;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import static crossmobile.ios.foundation.FoundationDrill.fireMillis;

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
                Activity activity = item.get();
                if (activity != null)
                    activity.finish();
            } catch (Exception ignored) {
            }
        activitylist.clear();

        MainActivity c = MainActivity.current;
        if (c != null) {
            if (error != null)
                postOnEventThread(() -> Toast.makeText(c, error, Toast.LENGTH_LONG).show());
            c.finish();
        }
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        errorFound = true;
        super.uncaughtException(thread, throwable);
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

    void register(Activity mapActivity) {
        activitylist.add(new WeakReference<>(mapActivity));
    }

    @Override
    public void parseArguments(String[] args) {
        // No argument parsing in Android
    }

    @Override
    public void splashTerminated() {
    }

    @Override
    public void runOnEventThread(Runnable r) {
        Activity activity = MainActivity.current;
        if (activity != null) // Run only if still active
            activity.runOnUiThread(r);
    }

    @Override
    public void postOnEventThread(Runnable r) {
        View view = MainView.current;
        if (view != null)
            view.post(r);
    }

    @Override
    public boolean isEventThread() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    @Override
    public SystemTimerHandler createSystemTimer() {
        return new SystemTimerHandler() {
            private final Collection<NSTimer> timers = new HashSet<>();
            private final Handler handler = new Handler(Looper.getMainLooper());
            boolean active = true;

            @Override
            public synchronized void addTimer(NSTimer timer) {
                if (!active || timer == null || timers.contains(timer))
                    return;
                timers.add(timer);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (!active)
                            return;

                        timer.fire();
                        if (!timer.isValid())
                            timers.remove(timer);
                        else
                            handler.postDelayed(this, Math.round(timer.timeInterval() * 1000));
                    }
                }, (int) Math.max(fireMillis(timer) - System.currentTimeMillis(), 0));
            }

            @Override
            public synchronized void quitTimers() {
                active = false;
                timers.clear();
            }
        };
    }

    @Override
    public void hasAnimationFrames(boolean enabled) {
        if (enabled)
            Choreographer.getInstance().postFrameCallback(frameNanos -> Animator.animate(frameNanos / 1_000_000));
    }
}
