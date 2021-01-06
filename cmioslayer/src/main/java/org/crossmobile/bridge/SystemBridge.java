/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.uikit.UIAlertView;
import crossmobile.ios.uikit.UIAlertViewDelegate;
import crossmobile.ios.uikit.UIView;
import org.crossmobile.backend.android.AndroidPermissions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

public interface SystemBridge {
    SimpleDateFormat GMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Set<String> NOT_IMPLEMENTED_ELEMENTS = new HashSet<>();

    boolean Debug = true;

    String LOGTAG = "CrossMob";
    int CANCEL_ID = -1;
    int DESTROY_ID = -2;

    void error(String message, Throwable th);

    default void log(String message) {
        System.out.println(GMT.format(new Date()) + ": " + message);
    }

    void debug(String message, Throwable th);

    String version();

    String model();

    default String bundleID() {
        return System.getProperty("cm.group.id") + "." + System.getProperty("cm.artifact.id");
    }

    void setKeyboardVisibility(boolean status);

    void showAlert(UIAlertView view, String title, String message, List<String> buttons, UIAlertViewDelegate delegate);

    /**
     * @param callback CANCEL_ID the cancel button, DESTROY_ID the destructive button, >=0 the other titles buttons
     */
    void showActionSheet(String title, String cancelTitle, String destructiveTitle, List<String> otherTitles, NSSelector<Integer> callback);

    boolean launchPhoneCall(String phone);

    boolean isRTL();

    void registerScrollable(Class<? extends UIView> scrollableClass);

    Iterable<Class<? extends UIView>> getScrollables();

    default void notImplemented() {
        notImplemented(null);
    }

    default void notImplemented(String moreInfo) {
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
}
