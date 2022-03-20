/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.*;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.wrapper.NativeTouch;
import org.crossmobile.bind.wrapper.TextWrapper;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

import static crossmobile.ios.coregraphics.GraphicsDrill.convertBaseContextToCGContext;
import static crossmobile.ios.uikit.UITouchPhase.*;

@CMLib(target = CMLibTarget.RUNTIME)
public class UserInterfaceDrill {

    public static CGFont cgfont(UIFont f) {
        return f.cgfont;
    }

    public static CGColor cgcolor(UIColor c) {
        return c.cgcolor;
    }

    public static UIColor uicolor(int color) {
        return new UIColor(color);
    }

    public static void drawWindow(GraphicsContext<?> cxt) {
        UIGraphics.pushContext(convertBaseContextToCGContext(cxt));
        UIWindow window = UIApplication.splashWindow;
        if (window == null)
            window = UIApplication.sharedApplication() == null ? null : UIApplication.sharedApplication().keyWindow();
        if (window != null)
            window.drawWindow();
        UIGraphics.popContext();
    }

    public static UIWindow splashWindow() {
        return UIApplication.splashWindow;
    }

    public static UITouch newUITouch(double hardwareX, double hardwareY, int pointerID, UIWindow window, int phase) {
        return new UITouch(Native.graphics().metrics().getHardwareToVirtual(hardwareX, hardwareY), pointerID, window, phase);
    }

    public static void fireUIEvent(Object originalEvent, double[] x, double[] y, int activePointer, int phase) {
        UIApplication app = UIApplication.sharedApplication();
        if (app == null)
            return;
        UIWindow window = app.keyWindow();
        if (window == null)
            return;
        UITouch[] touches = new UITouch[x.length];
        for (int i = 0; i < touches.length; i++)
            touches[i] = newUITouch(x[0], y[0], i, window, activePointer == i ? phase : Stationary);
        if (phase == Began || phase == Moved) {
            CGPoint[] points = new CGPoint[touches.length];
            for (int i = 0; i < touches.length; i++)
                points[i] = touches[i].locationInView(null);
            Native.graphics().metrics().setActiveTouchLocations(points);
        } else
            Native.graphics().metrics().setActiveTouchLocations(null);
        window.sendEvent(new UIEvent(touches, originalEvent, phase));
    }

    public static UIViewController getViewControllerFromView(UIView view) {
        return view.controller;
    }

    public static void mouseDidScroll(float hardwareX, float hardwareY, int scrollAmount) {
        UIView topView = UIApplication.sharedApplication() == null ? null : UIApplication.sharedApplication().keyWindow();
        if (topView == null)
            return;
        UIView hitTest = topView.hitTest(Native.graphics().metrics().getHardwareToVirtual(hardwareX, hardwareY), new cmPrivateEvent() {
            @Override
            public boolean isHitAllowed(UIView targetView) {
                return targetView instanceof UIScrollView;
            }
        });
        if (hitTest != null && (hitTest instanceof UIScrollView)) {
            UIScrollView scrollView = (UIScrollView) hitTest;
            CGPoint offset = scrollView.contentOffset();
            offset.setY(offset.getY() + scrollAmount * 10);
            if (offset.getY() < 0)
                offset.setY(0);
            if (offset.getY() > (scrollView.contentSize.getHeight() + scrollView.contentInset.getTop() + scrollView.contentInset.getBottom()) - scrollView.cframe().getSize().getHeight())
                offset.setY((scrollView.contentSize.getHeight() + scrollView.contentInset.getTop() + scrollView.contentInset.getBottom()) - scrollView.cframe().getSize().getHeight());
            scrollView.setContentOffset(offset, false);
            scrollView.flashScrollIndicators();
        }
    }

    public static TextWrapper<?, ?, ?> getTextFieldWrapper(UITextField tf) {
        return (TextWrapper<?, ?, ?>) tf.getWidget();
    }

    public static void drawSelf(UIView view, CGContext cx) {
        view.drawingSelf(cx);
    }

    public static void setStoryboard(UIViewController controller, UIStoryboard storyboard) {
        controller.setStoryboard(storyboard);
    }

    public static void addSegue(UIViewController controller, String id, UIStoryboardSegue segue) {
        controller.addSegue(id, segue);
    }

    public static void addSegue(UITableViewCell cell, String trigger, UIStoryboardSegue segue) {
        cell.addSegue(trigger, segue);
    }

    public static void addSection(UITableViewController tableViewController, String headerTitle, String footerTitle, UITableViewCell[] cells) {
        tableViewController.addSection(headerTitle, footerTitle, cells);
    }

    public static void setCellRowHeight(UITableViewCell cell, float rowHeight) {
        cell.setRowHeight(rowHeight);
    }

    public static Object getOriginalEvent(UIEvent event) {
        return event.originalEvent;
    }

    public static NativeTouch[] getTouches(UIEvent event, UIView referenceView) {
        return event.getTouches(referenceView);
    }

    /* The following methods are for optimization reasons; by default the getter methods
     * return a copy of the original object, to be data safe since the original data can't
     * be immutable.
     *
     * These methods have access to the original object with the promise not to alter them.
     */

    // BEGIN OPTIMIZED STRUCT METHODS
    public static CGRect frame(UIView view) {
        return view.cframe();
    }

    public static UIEdgeInsets scrollIndicatorInsets(UIScrollView view) {
        return view.scrollIndicatorInsets;
    }

    public static CGPoint contentOffset(UIScrollView view) {
        return view.contentOffset;
    }

    public static CGSize contentSize(UIScrollView view) {
        return view.contentSize;
    }

    public static UIEdgeInsets contentInset(UIScrollView view) {
        return view.contentInset;
    }
    // END OPTIMIZED STRUCT METHODS
}
