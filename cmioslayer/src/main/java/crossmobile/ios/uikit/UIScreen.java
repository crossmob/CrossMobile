/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UIScreen class contains all the information related to device's screen.
 */
@CMClass
public class UIScreen extends NSObject {

    private final static UIScreen mainScreen = new UIScreen();

    /**
     * Return a UIScreen object that represents the screen of the device.
     *
     * @return A UIScreen object.
     */
    @CMSelector("+ (UIScreen *)mainScreen;")
    public static UIScreen mainScreen() {
        return mainScreen;
    }

    /**
     * Returns the rectangle that encloses the screen.
     *
     * @return The rectangle that encloses the screen.
     */
    @CMGetter("@property(nonatomic, readonly) CGRect bounds;")
    public CGRect bounds() {
        return new CGRect(0, 0, Native.graphics().metrics().getVirtualWidth(), Native.graphics().metrics().getVirtualHeight());
    }

    /**
     * Returns the rectangle for the frame of the application window.
     *
     * @return The rectangle for the frame of the application window.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, readonly) CGRect applicationFrame;")
    public CGRect applicationFrame() {
        int width = Native.graphics().metrics().getVirtualWidth();
        int height = Native.graphics().metrics().getVirtualHeight();
        int orientation = UIDevice.currentDevice().orientation();
        switch (orientation) {
            case UIInterfaceOrientation.LandscapeRight:
            case UIInterfaceOrientation.LandscapeLeft:
                return new CGRect(0, 0, width, height);
            case UIInterfaceOrientation.PortraitUpsideDown:
            case UIInterfaceOrientation.Portrait:
            default:
                return new CGRect(0, 0, width, height);
        }
    }

    /**
     * Return the natural scale factor for this screen.
     *
     * @return The natural scale factor for this screen.
     */
    @CMGetter("@property(nonatomic, readonly) CGFloat scale;")
    public double scale() {
        return Math.ceil(Native.graphics().metrics().getVirtualScale());
    }
}
