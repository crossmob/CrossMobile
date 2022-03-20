/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.hardware.SensorManager;
import android.view.OrientationEventListener;
import crossmobile.ios.uikit.UIDeviceOrientation;
import org.crossmobile.bind.graphics.GraphicsBridgeConstants;
import org.crossmobile.bridge.Native;

import static android.provider.Settings.System.ACCELEROMETER_ROTATION;
import static android.provider.Settings.System.getInt;

public final class OrientationManager {

    private static final int DELTA = 30;

    private static OrientationEventListener current;

    public static void register(MainActivity activity) {
        current = new OrientationEventListener(activity, SensorManager.SENSOR_DELAY_NORMAL) {
            int oldOrientation = -1;

            @Override
            public void onOrientationChanged(int angle) {
                int iosOrientation = -1;

                if (getInt(activity.getContentResolver(), ACCELEROMETER_ROTATION, 0) == 0) {
                } else if (angle < 0) {
                } else if (angle < DELTA || angle > (360 - DELTA))
                    iosOrientation = UIDeviceOrientation.Portrait;
                else if (angle > (90 - DELTA) && angle < (90 + DELTA))
                    iosOrientation = UIDeviceOrientation.LandscapeLeft;
                else if (angle > (180 - DELTA) && angle < (180 + DELTA))
                    iosOrientation = UIDeviceOrientation.PortraitUpsideDown;
                else if (angle > (270 - DELTA) && angle < (270 + DELTA))
                    iosOrientation = UIDeviceOrientation.LandscapeRight;

                if (iosOrientation < 0 || !GraphicsBridgeConstants.shouldAcceptOrientation(iosOrientation)) {
                } else if (oldOrientation != iosOrientation) {
                    oldOrientation = iosOrientation;
                    Native.graphics().setOrientation(iosOrientation);
                    activity.onOrientationChanged(iosOrientation);
                }
            }
        };
        activity.getStateListener().register(new ActivityLifecycleListener() {
            @Override
            public void onPause() {
                current.disable();
            }

            @Override
            public void onResume() {
                if (current.canDetectOrientation())
                    current.enable();
            }
        });
    }

    private OrientationManager() {
    }
}
