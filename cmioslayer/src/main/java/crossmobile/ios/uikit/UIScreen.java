/*
 * (c) 2019 by Panayotis Katsaloulis
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
        return Native.graphics().metrics().getScaleAverage();
    }
}
