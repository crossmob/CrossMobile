// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.uikit.UIAlertView;
import crossmobile.ios.uikit.UIAlertViewDelegate;
import org.crossmobile.backend.android.AndroidPermissions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public interface SystemBridge {
    SimpleDateFormat GMT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    String LOGTAG = "CrossMob";
    int CANCEL_ID = -1;
    int DESTROY_ID = -2;

    /**
     * Use this method to run some code to the event thread as fast as possible.
     * If this is already the event thread, directly run this code and then
     * return.
     * <p>
     * MAKE SURE that this method will run & return IMMEDIATELY when run from
     * the dispatch thread; else, the UIRunner will block.
     *
     * @param r
     */
    void runOnEventThread(Runnable r);

    /**
     * Run this code to run come code to the event thread as fast as possible,
     * and wait for this process to finish.
     *
     * @param r The code to run
     */
    void runAndWaitOnEventThread(Runnable r);

    /**
     * Use this method to run some code in later time, in the event thread. Even
     * if this is the event thread, do not run directly but run after the
     * current event cycle.
     *
     * @param r
     */
    void postOnEventThread(Runnable r);

    /**
     * Run without throwing any exceptions
     *
     * @param r the runnable to run
     */
    default void safeRun(Runnable r) {
        try {
            r.run();
        } catch (Throwable th) {
            error("Unable to safely run routine", th);
        }
    }

    boolean isEventThread();

    void error(String message, Throwable th);

    default void log(String message) {
        System.out.println(GMT.format(new Date()) + ": " + message);
    }

    void debug(String message, Throwable th);

    String version();

    String model();

    String bundleID();

    void setKeyboardVisibility(boolean status);

    void showAlert(UIAlertView view, String title, String message, List<String> buttons, UIAlertViewDelegate delegate);

    /**
     * @param callback CANCEL_ID the cancel button, DESTROY_ID the destructive button, >=0 the other titles buttons
     */
    void showActionSheet(String title, String cancelTitle, String destructiveTitle, List<String> otherTitles, NSSelector<Integer> callback);

    boolean launchPhoneCall(String phone);

    boolean isRTL();
}
