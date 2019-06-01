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
package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSSelector;
import crossmobile.ios.uikit.UIAlertView;
import crossmobile.ios.uikit.UIAlertViewDelegate;
import org.crossmobile.backend.android.AndroidPermissions;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public interface SystemBridge {

    int CANCEL_ID = -1;
    int DESTROY_ID = -2;
    AtomicLong lastExec = new AtomicLong(System.currentTimeMillis());

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

    void error(Object message, Throwable th);

    void debug(Object message, Throwable th);

    default void debugAndStamp(Object message) {
        debugAndStamp(message, null);
    }

    default void debugAndStamp(Object message, Throwable th) {
        long now = System.currentTimeMillis();
        String timeStamp = (now - lastExec.getAndSet(now)) / 1000.0 + "s";
        message = message == null ? timeStamp : timeStamp + " " + message;
        debug(message, th);
    }

    String version();

    String model();

    String bundleID();

    void setKeyboardVisibility(boolean status);

    void showAlert(UIAlertView view, String title, String message, List<String> buttons, UIAlertViewDelegate delegate);

    /**
     * @param callback CANCEL_ID the cancel button, DESTROY_ID the destructive button, >=0 the other titles buttons
     */
    void showActionSheet(String title, String cancelTitle, String destructiveTitle, List<String> otherTitles, NSSelector<Integer> callback);

    boolean launchPhonecall(String phone);

    int getNaturalTextAlignment();

    boolean isRTL();
}
