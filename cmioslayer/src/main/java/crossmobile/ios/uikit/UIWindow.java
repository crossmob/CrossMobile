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
package crossmobile.ios.uikit;

import com.panayotis.ce.CEventManager;
import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.AbstractGraphicsBridge;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.UIStatusBar;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import static com.panayotis.ce.CEventCommons.DEBUG_GRAPHICS;
import static crossmobile.ios.coregraphics.$coregraphics.context;
import static org.crossmobile.bind.system.Debug.*;

/**
 * UIWindow class defines an object known as a window that contains and controls
 * the visible parts of the screen, the views. A window intervenes between
 * events and the corresponding views. An application has only one window unless
 * it uses an external screen.
 */
@CMClass
public class UIWindow extends UIView {

    private UIViewController rootViewController;

    /**
     * Constructs a default UIWindow object located at (0,0) with 0 weight and 0
     * height.
     */
    public UIWindow() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIWindow object initialized with the dimensions and position
     * specified in the frame parameter.
     *
     * @param frame CGRect that defines dimension and position of UIWindow.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UIWindow(CGRect frame) {
        super(frame);
    }

    @Override
    public UIResponder nextResponder() {
        return UIApplication.sharedApplication();
    }

    @Override
    public void addSubview(UIView subView) {
        if (subView.controller != null)
            setRootViewController(subView.controller);
        super.addSubview(subView);
    }

    @Override
    public UIWindow window() {
        return this;
    }

    /**
     * Sets the specified controller as root view controller of this window.
     *
     * @param controller The root view controller for the window.
     */
    @CMSetter("@property(nonatomic, strong) UIViewController *rootViewController;")
    public void setRootViewController(UIViewController controller) {
        for (UIView child : subviews())
            child.removeFromSuperview();
        this.rootViewController = controller;
    }

    /**
     * Returns the root view controller of this window.
     *
     * @return Window's root view controller.
     */
    @CMGetter("@property(nonatomic, strong) UIViewController *rootViewController;")
    public UIViewController rootViewController() {
        return rootViewController;
    }

    /**
     * Adjusts a point's coordinates defined in this window to another given
     * window.
     *
     * @param point  The point to be adjusted.
     * @param window The destination window into whose coordinate system the
     *               original point will be adjusted. If NULL, then it uses the logical
     *               coordinate system of the screen as original.
     * @return The adjusted point.
     */
    @CMSelector("- (CGPoint)convertPoint:(CGPoint)point \n"
            + "               toWindow:(UIWindow *)window;")
    public CGPoint convertPointToWindow(CGPoint point, UIWindow window) {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Adjusts a point's coordinates from a given window to this window.
     *
     * @param point  The point to be adjusted.
     * @param window The original window that contains the point to be adjusted
     *               to this window. If NULL, then it uses the logical coordinate system of
     *               the screen as original.
     * @return The adjusted point.
     */
    @CMSelector("- (CGPoint)convertPoint:(CGPoint)point \n"
            + "             fromWindow:(UIWindow *)window;")
    public CGPoint convertPointFromWindow(CGPoint point, UIWindow window) {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Adjusts a rectangle of this window to the coordinate system of given
     * window.
     *
     * @param point  The rectangle of this window.
     * @param window The destination window to which the rectangle of this
     *               window will be adjusted. If NULL,then it uses the logical coordinate
     *               system of the screen as a destination.
     * @return The adjusted rectangle.
     */
    @CMSelector("- (CGRect)convertRect:(CGRect)rect \n"
            + "             toWindow:(UIWindow *)window;")
    public CGRect convertRectToWindow(CGRect point, UIWindow window) {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Adjusts a rectangle of a given window's coordinate system to the
     * coordinate system of this window.
     *
     * @param point  The original rectangle.
     * @param window The original window that contains the rectangle to be
     *               adjusted.If NULL, then it uses the logical coordinate system of the
     *               screen as original.
     * @return The adjusted rectangle.
     */
    @CMSelector("- (CGRect)convertRect:(CGRect)rect \n"
            + "           fromWindow:(UIWindow *)window;")
    public CGRect convertRectFromWindow(CGRect point, UIWindow window) {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Makes the receiver key window and moves it in front of any other windows
     * so that it is visible.
     */
    @CMSelector("- (void)makeKeyAndVisible;")
    public void makeKeyAndVisible() {
        if (UIApplication.sharedApplication().keyWindow() == this)
            return;
        UIApplication.sharedApplication().setKeyWindow(this);
    }

    @Override
    public void willRemoveSubview(UIView subview) {
        if (subview != null && subview.controller != null && UIApplication.sharedApplication().keyWindow() == this)
            subview.controller.viewWillDisappear(true);
    }

    @Override
    void willAddSubview(UIView subview) {
        if (subview != null && subview.controller != null && UIApplication.sharedApplication().keyWindow() == this) {
            subview.controller.viewSafeAreaInsetsDidChange();
            subview.controller.viewDidAppear(true);
        }
    }

    @Override
    void didRemoveSubview(UIView subview) {
        if (subview != null && subview.controller != null && UIApplication.sharedApplication().keyWindow() == this)
            subview.controller.viewDidDisappear(true);
    }

    @Override
    public void didAddSubview(UIView subview) {
        if (subview != null && subview.controller != null && UIApplication.sharedApplication().keyWindow() == this)
            subview.controller.viewDidDisappear(true);
    }

    final void drawWindow() {
        CGContext cgx = UIGraphics.getCurrentContext();
        GraphicsContext cx = context(cgx);
        Native.graphics().metrics().preDraw(cx);
        AbstractGraphicsBridge.DrawingDepth = 0;

        cx.translate(getX(), getY());
        cx.setAlpha(alpha);
        try {
            drawingSelf(cgx);
        } catch (Exception e) {
            Native.system().error(null, e);
        }

        cx.translate(-getX(), -getY());
        cx.setAlpha(1);
        if (UIStatusBar.required)
            drawingChild(cgx, UIStatusBar.getStatusBar(), false);

        if (ENABLE_DEBUG) {
            CEventManager.fireEvent(DEBUG_GRAPHICS, this);
            if (Live_Graphics_Debug) {
                CGPoint[] p = Native.graphics().metrics().getActiveTouchLocations();
                if (p != null) {
                    cgx.setRGBStrokeColor(1, 0.3f, 0.2f, 0.7f);
                    cx.setLineWidth(2);
                    for (int i = 0; i < p.length; i++) {
                        cgx.moveToPoint(0, p[i].getY());
                        cgx.addLineToPoint(getWidth(), p[i].getY());
                        cgx.moveToPoint(p[i].getX(), 0);
                        cgx.addLineToPoint(p[i].getX(), getHeight());
                        cgx.moveToPoint(p[i].getX(), p[i].getY());
                        cgx.addArc(p[i].getX(), p[i].getY(), 30, 0, GraphicsContext._2_PI - 0.00001f, 0);
                        cgx.strokePath();
                    }
                }
            }
        }
        Native.graphics().metrics().postDraw(cx);
    }

    @Override
    public UIView hitTest(CGPoint point, UIEvent event) {
        UIView target = super.hitTest(point, event);
        return target == null ? this : target;
    }

    /**
     * Dispatches events sent to the receiver by the UIApplication object to its
     * views.
     *
     * @param event The event to process.
     */
    @CMSelector("- (void)sendEvent:(UIEvent *)event;")
    public void sendEvent(UIEvent event) {
        if (ENABLE_DEBUG && Ignore_Touches)
            return;
        cmEventDispatcher.dispatcher.processTouchEvent(event);
        if (ENABLE_DEBUG)
            if (Live_Touch_Debug)
                Native.graphics().refreshDisplay();
    }

    @Override
    CGPoint locationRelativeToRoot(CGPoint rloc) {
        return rloc;
    }
}
