/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bind.graphics.Geometry;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.SystemBridge;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Date;

/**
 * UITouch class defines an object that handles all the information related to
 * the touch interaction of the user with the application.
 */
@CMClass
public class UITouch extends NSObject {

    static final double DOUBLETAP = 0.25; // in milliseconds
    private static final int SUPPORTED_TOUCHES = 10; // maximum number of allowed multi-touches
    private static final UIView[] olderView = new UIView[SUPPORTED_TOUCHES];
    private static final double[] olderTime = new double[SUPPORTED_TOUCHES];
    private static final int[] olderTap = new int[SUPPORTED_TOUCHES];

    final UIWindow window;
    final CGPoint locationInWindow;
    final int phase;
    final double timestamp;
    final UIView view;
    final int tapcount;
    final int pointerID;

    static final String NAMES[] = {"Began", "Moved", "Stationary", "Ended", "Cancelled"};

    static {
        for (int i = 0; i < SUPPORTED_TOUCHES; i++)
            olderTap[1] = 1;
    }

    /**
     * @param location  A point specifying the location of the receiver in view.
     * @param pointerID Pointer ID
     * @param window    The window in which the touch initially occurred.
     * @param phase     The type of touch.(UITouchPhase)
     */
    @SuppressWarnings("LeakingThisInConstructor")
    UITouch(CGPoint location, int pointerID, UIWindow window, int phase) {
        if (pointerID >= SUPPORTED_TOUCHES || pointerID < 0) {
            Native.system().error("UITouch: Unsupported touch pointer with id " + pointerID, null);
            throw new ArrayIndexOutOfBoundsException("Unsupported touch pointer with id" + pointerID);
        }
        if (window == null)
            window = UIApplication.sharedApplication().keyWindow();

        this.window = window;
        this.locationInWindow = this.window.transform == null
                ? new CGPoint(location.getX(), location.getY())
                : Geometry.apply(this.window.inverseTransform(), new CGPoint(location.getX(), location.getY()));   // Window transformations should be performed in advance
        this.phase = phase;
        this.pointerID = pointerID;
        this.timestamp = System.currentTimeMillis() / 1000d;

        if (phase == UITouchPhase.Began) {
            this.view = window.hitTest(locationInWindow, null);
            this.tapcount = (this.timestamp - olderTime[pointerID]) < DOUBLETAP && this.view == olderView[pointerID] ? olderTap[pointerID] + 1 : 1;
        } else {
            this.view = findOlderView(pointerID);
            this.tapcount = olderTap[pointerID];
        }
        olderView[pointerID] = this.view;
        olderTime[pointerID] = this.timestamp;
        olderTap[pointerID] = this.tapcount;
    }

    private UIView findOlderView(int pointer) {
        for (int i = pointer; i >= 0; i--)
            if (olderView[i] != null)
                return olderView[i];
        for (int i = pointer + 1; i < SUPPORTED_TOUCHES; i++)
            if (olderView[i] != null)
                return olderView[i];
        return UIApplication.sharedApplication().keyWindow();
    }

    /**
     * Returns the position of the receiver expressed in current view's
     * coordinate system.
     *
     * @param request The current view . If NULL, then it uses the logical
     *                coordinate system of the screen to define the current position of the
     *                receiver.
     * @return The position of the receiver expressed in current view's
     * coordinate system.
     */
    @CMSelector("- (CGPoint)locationInView:(UIView *)view;")
    public CGPoint locationInView(UIView request) {
        if (request == null)
            request = window;
        return request.convertPointFromView(locationInWindow, null);
    }

    /**
     * Returns the initial view in which the touch originally occurred.
     *
     * @return The initial view in which the touch originally occurred.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIView *view;")
    public UIView view() {
        return view;
    }

    /**
     * Returns the initial window in which the touch originally occurred.
     *
     * @return The initial window in which the touch originally occurred.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIWindow *window;")
    public UIWindow window() {
        return window;
    }

    /**
     * Returns a number that counts how many times the user tapped the screen
     * for this specific touch.
     *
     * @return The number of taps.
     */
    @CMGetter("@property(nonatomic, readonly) NSUInteger tapCount;")
    public int tapCount() {
        return tapcount;
    }

    /**
     * Returns the timestamp that shows when the touch occurred or when was the
     * last modification of the touch.
     *
     * @return The timestamp that shows when the touch occurred or when was the
     * last modification of the touch.
     */
    @CMGetter("@property(nonatomic, readonly) NSTimeInterval timestamp;")
    public double timestamp() {
        return timestamp;
    }

    /**
     * Returns the type of touch.
     *
     * @return The type of touch.
     */
    @CMGetter("@property(nonatomic, readonly) UITouchPhase phase;")
    public int phase() {
        return phase;
    }

    @Override
    public String toString() {
        return "UITouch " + NAMES[phase] + " tap=" + tapcount + " loc=" + locationInWindow.toString() + " at=" + SystemBridge.GMT.format(new Date())
                + " in [" + view.toString() + " " + view.parentList() + "]";
    }
}
