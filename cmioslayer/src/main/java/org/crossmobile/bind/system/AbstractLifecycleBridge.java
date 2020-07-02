/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSNotification;
import crossmobile.ios.foundation.NSNotificationCenter;
import crossmobile.ios.uikit.*;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.LifecycleBridge;
import org.crossmobile.bridge.Native;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static crossmobile.ios.coregraphics.GraphicsDrill.convertBaseContextToCGContext;
import static crossmobile.ios.foundation.FoundationDrill.quitTimers;
import static crossmobile.ios.uikit.UserInterfaceDrill.getViewControllerFromView;
import static org.crossmobile.bridge.RuntimeKeys.AndroidBackButtonNotification;

public abstract class AbstractLifecycleBridge implements LifecycleBridge {

    private boolean applicationIsInitialized = false;
    private Thread.UncaughtExceptionHandler systemHandler;
    private boolean isQuitting = false;
    private boolean inBackground;
    private boolean shouldWait;
    private Set<Runnable> runningTasks = new LinkedHashSet<>();
    private Set<Runnable> waitingTasks = new LinkedHashSet<>();

    @Override
    public void init(String[] args) {
        if (applicationIsInitialized)
            return;
        applicationIsInitialized = true;    // Enter only once

        systemHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);

        cleanTemporaryLocation();
        parseArguments(args);
        Native.graphics().metrics().initIdiom();
        //noinspection unchecked
        UIGraphics.pushContext(convertBaseContextToCGContext(Native.graphics().newGraphicsContext(null, true)));

        String cache = Native.file().getSystemCacheLocation();
        String button_up = cache + File.separator + Theme.Images.ROUNDRECT_RELEASED + ".png";
        String button_down = cache + File.separator + Theme.Images.ROUNDRECT_PRESSED + ".png";
        if (!Native.file().fileExists(cache + File.separator + Theme.Images.ROUNDRECT_PRESSED + ".png"))
            Native.widget().updateNativeGraphics(button_up, button_down);
        initPlugins();
        Debug.init();
    }

    @SuppressWarnings({"UseSpecificCatch"})
    private void initPlugins() {
        try {
            Class.forName("org.crossmobile.sys.PluginsLauncherList").getMethod("initialize").invoke(null);
        } catch (Exception ex) {
            Native.system().error("Unable to initialize plugins", ex);
        }
    }

    @Override
    public void activate() {
        inBackground = false;
        UIApplication app = UIApplication.sharedApplication();
        if (app != null && app.delegate() != null)
            app.delegate().willEnterForeground(app);
    }

    @Override
    public void deactivate() {
        inBackground = true;
        UIApplication app = UIApplication.sharedApplication();
        if (app != null && app.delegate() != null)
            app.delegate().didEnterBackground(app);
    }

    @Override
    public void quit(String error, Throwable throwable) {
        if (isQuitting)
            return;
        isQuitting = true;
        quitTimers();
        UIApplication app = UIApplication.sharedApplication();
        if (app != null && app.delegate() != null) {
            app.delegate().didEnterBackground(app);
            app.delegate().willTerminate(app);
        }
        cleanTemporaryLocation();
        if (error != null || throwable != null)
            Native.system().error(error, throwable);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        quit(throwable.toString(), throwable);
        if (systemHandler != null)
            systemHandler.uncaughtException(thread, throwable);
    }


    private void cleanTemporaryLocation() {
        Native.file().deleteRecursive(new File(Native.file().getTemporaryLocation()));
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean backHandled() {
        UIApplication app = UIApplication.sharedApplication();
        if (app != null &&
                app.delegate() != null &&
                app.keyWindow() != null &&
                app.keyWindow().rootViewController() != null &&
                popIfAvailable(app.keyWindow().rootViewController()))
            return true;
        AtomicBoolean result = new AtomicBoolean(false);
        NSNotification notification = new NSNotification(AndroidBackButtonNotification, result, null);
        NSNotificationCenter.defaultCenter().postNotification(notification);
        return result.get();
    }

    private boolean popIfAvailable(UIViewController root) {
        if (root instanceof UINavigationController && ((UINavigationController) root).popViewControllerAnimated(true) != null)
            return true;
        for (UIView v : root.view().subviews()) {
            UIViewController child = getViewControllerFromView(v);
            if (child != null && popIfAvailable(child))
                return true;
        }
        return false;
    }

    public static void memoryWarning() {
        Native.system().error("Memory warning", null);
        Native.image().recycle();
        UIApplication.sharedApplication().delegate().didReceiveMemoryWarning(UIApplication.sharedApplication());
        UIViewController vc = UIApplication.sharedApplication().keyWindow().rootViewController();
        if (vc != null)
            vc.didReceiveMemoryWarning();
    }

    public static Map<String, Object> errorFromThrowable(Throwable th) {
        Map<String, Object> info = new HashMap<>();
        info.put(NSError.Key.NSUnderlyingError, th.getClass().getName());
        info.put(NSError.Key.NSLocalizedDescription, th.getLocalizedMessage());
        info.put(NSError.Key.NSLocalizedFailureReason, th.getCause() != null ? th.getCause().getLocalizedMessage() : th.getLocalizedMessage());
        return info;
    }

    public static Map<String, Object> errorFromInfo(String error) {
        Map<String, Object> info = new HashMap<>();
        info.put(NSError.Key.NSUnderlyingError, error);
        info.put(NSError.Key.NSLocalizedDescription, error);
        return info;
    }

    @Override
    public int getApplicationState() {
        return inBackground ? UIApplicationState.Background : UIApplicationState.Active;
    }

    @Override
    public void runAndWaitOnEventThread(Runnable runnable) {
        if (runnable == null)
            return;

        SyncRunnable runner = new SyncRunnable(runnable);
        //noinspection SynchronizationOnLocalVariableOrMethodParameter
        synchronized (runner) {
            try {
                Native.lifecycle().runOnEventThread(runner); // MAKE SURE that this method will run & return IMMEDIATELY when run from the dispatch thread
                if (!runner.didRun())
                    runner.wait();
            } catch (InterruptedException ignored) {
            }
        }
    }

    private static final class SyncRunnable implements Runnable {

        private boolean didRun = false; // by default set this thread not to be the same with the caller. If it indeed is, since the runOnUiThread calls directly the "run()" method, this variable is set immediately to "true"
        private final Runnable runnable;

        private SyncRunnable(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public synchronized final void run() {
            runnable.run();
            didRun = true;
            notifyAll();
        }

        boolean didRun() {
            return didRun;
        }
    }

    @Override
    public void runOnceLaterOnEventThread(Runnable task) {
        synchronized (this) {
            if (task != null)
                waitingTasks.add(task);
        }
        if (!shouldWait)
            runOnEventThread(this::drainWaitingTasks);
    }

    @Override
    public void runInContext(Runnable commands) {
        runOnEventThread(() -> {
            shouldWait = true;
            commands.run();
            if (!waitingTasks.isEmpty())
                drainWaitingTasks();
            shouldWait = false;
        });
    }

    // This method is always run on event thread
    private void drainWaitingTasks() {
        // Swap instead of assign running tasks to waiting tasks and clear waiting tasks, since run tasks should be empty anyway
        synchronized (this) {
            Set<Runnable> empty = runningTasks;
            runningTasks = waitingTasks;
            waitingTasks = empty;
        }

        for (Runnable r : runningTasks)
            r.run();    // This method might produce more waiting tasks
        runningTasks.clear();

        if (!waitingTasks.isEmpty()) // more waiting tasks have been produced, do the same procedure again
            drainWaitingTasks();
    }
}
