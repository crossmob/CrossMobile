/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.ANDROID)
public interface ActivityLifecycleListener {

    default void onStart() {
    }

    default void onPause() {
    }

    default void onStop() {
    }

    default void onResume() {
    }

    default void onDestroy() {
    }

    default void onLowMemory() {
    }

    default void onCreate(Bundle savedInstanceState) {
    }

    default void onSaveInstanceState(Bundle outState) {
    }

    default void onConfigurationChanged(Configuration newConfig) {
    }

    default void onOrientationChanged(int newOrientation) {
    }

    default void onNewIntent(Intent intent) {
    }

}
