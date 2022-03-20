/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.uikit.UIApplication;
import crossmobile.ios.uikit.UIDeviceOrientation;
import crossmobile.ios.uikit.UIInterfaceOrientationMask;
import crossmobile.ios.uikit.UIViewController;

public final class GraphicsBridgeConstants {

    public static final double DefaultAnimationDuration = 0.3;

    private static final int DefaultOrientationMask = Integer.parseInt(System.getProperty("cm.orientations.masked.supported", "-1"));
    public static final int DefaultInitialOrientation = Integer.parseInt(System.getProperty("cm.orientation.initial", "0"));

    public static boolean shouldAcceptOrientation(int deviceOrientation) {
        UIViewController root = UIApplication.sharedApplication() == null ? null
                : (UIApplication.sharedApplication().keyWindow() == null ? null
                : UIApplication.sharedApplication().keyWindow().rootViewController());
        int orientationMask = deviceOrientation == UIDeviceOrientation.LandscapeRight ? UIInterfaceOrientationMask.LandscapeRight
                : (deviceOrientation == UIDeviceOrientation.PortraitUpsideDown ? UIInterfaceOrientationMask.PortraitUpsideDown
                : (deviceOrientation == UIDeviceOrientation.LandscapeLeft ? UIInterfaceOrientationMask.LandscapeLeft
                : UIInterfaceOrientationMask.Portrait));
        return root != null && (root.supportedInterfaceOrientations() & GraphicsBridgeConstants.DefaultOrientationMask & orientationMask) != 0;
    }

    private GraphicsBridgeConstants() {
    }

}
