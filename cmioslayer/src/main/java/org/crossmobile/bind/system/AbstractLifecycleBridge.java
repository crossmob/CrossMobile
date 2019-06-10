/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import static crossmobile.ios.coregraphics.$coregraphics.newCGContext;
import static crossmobile.ios.foundation.$foundation.quitTimers;
import static crossmobile.ios.uikit.$uikit.getViewControllerFromView;
import static org.crossmobile.bridge.CustomNotifications.AndroidBackButtonNotification;

public abstract class AbstractLifecycleBridge implements LifecycleBridge {

    private final Set<String> NOT_IMPLEMENTED_ELEMENTS = new HashSet<>();

    private boolean applicationIsInitialized = false;
    private Thread.UncaughtExceptionHandler systemhandler;
    private boolean isQuitting = false;

    @Override
    public void init(String[] args) {
        if (applicationIsInitialized)
            return;
        applicationIsInitialized = true;    // Enter only once

        systemhandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);

        try {
            System.getProperties().load(new InputStreamReader(Native.file().getFileStream(Native.file().getApplicationPrefix() + "/" + CROSSMOBILE_PROPERTIES), "UTF-8"));
        } catch (IOException ex) {
            Native.lifecycle().quit("Corrupted CrossMobile application", ex);
            return;
        }
        try {
            System.getProperties().load(new InputStreamReader(Native.file().getFileStream(Native.file().getApplicationPrefix() + "/" + THEME_PROPERTIES), "UTF-8"));
        } catch (Exception ex) {
        }

        cleanTemporaryLocation();
        Native.graphics().metrics().initIdiom();
        UIGraphics.pushContext(newCGContext(Native.graphics().newGraphicsContext(null, true)));

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
        UIApplication app = UIApplication.sharedApplication();
        if (app != null && app.delegate() != null)
            app.delegate().willEnterForeground(app);
    }

    @Override
    public void deactivate() {
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
    public void uncaughtException(Thread thread, Throwable thrwbl) {
        quit(thrwbl.getMessage() == null || thrwbl.getMessage().trim().isEmpty() ? thrwbl.toString() : thrwbl.getMessage(), thrwbl);
        if (systemhandler != null)
            systemhandler.uncaughtException(thread, thrwbl);
    }

    @Override
    public void notImplemented(String moreInfo) {
        boolean foundSelfTrace = false;
        for (StackTraceElement el : Thread.currentThread().getStackTrace()) {
            String methodName = el.getMethodName();
            if (methodName.contains("notImplemented"))
                foundSelfTrace = true;
            else if (foundSelfTrace) {
                String elTxt = el.getClassName() + "." + methodName + "(" + el.getFileName() + ":" + el.getLineNumber() + ")";
                if (NOT_IMPLEMENTED_ELEMENTS.add(elTxt))
                    Native.system().error("Not implemented" + (moreInfo != null && !moreInfo.trim().isEmpty() ? " (" + moreInfo.trim() + ")" : "") +
                            ": at " + elTxt, null);
                return;
            }
        }
    }

    private void cleanTemporaryLocation() {
        Native.file().deleteRecursive(new File(Native.file().getTemporaryLocation()));
    }

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
}
