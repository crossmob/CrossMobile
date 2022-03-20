/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.res.Configuration;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.ANDROID)
public interface ApplicationStateListener {
    /*
      On create is not relevant, since it is called too early in the run process.
      Use plugin and early initialization instead
     */
//    default void onCreate() {
//    }

    default void onConfigurationChanged(Configuration newConfig) {
    }

    default void onTerminate() {
    }

    default void onLowMemory() {
    }

    default void onTrimMemory(int level) {
    }
}
