/*
 * (c) 2020 by Panayotis Katsaloulis
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

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.ANDROID_PLUGIN)
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
