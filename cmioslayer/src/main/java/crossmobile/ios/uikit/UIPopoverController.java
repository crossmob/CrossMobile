/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.List;

/**
 * UIPopoverController class defines an object that is used in order to provide
 * custom control of popover items.
 */
@Deprecated
@CMClass
public class UIPopoverController extends NSObject {

    private UIPopoverControllerDelegate delegate;
    private UIViewController contentViewController;

    /**
     * Constructs a popover controller.
     *
     * @param viewController The view controller for managing the popover’s content.
     */
    @CMConstructor("- (instancetype)initWithContentViewController:(UIViewController *)viewController;")
    public UIPopoverController(UIViewController viewController) {
    }

    /**
     * Returns the delegate of the popover.
     *
     * @return The delegate of the popover.
     */
    @CMGetter("@property(nonatomic, weak) id<UIPopoverControllerDelegate> delegate;")
    public UIPopoverControllerDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate of the popover.
     *
     * @param delegate The delegate of the popover.
     */
    @CMSetter("@property(nonatomic, weak) id<UIPopoverControllerDelegate> delegate;")
    public void setDelegate(UIPopoverControllerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the view controller of the popover.
     *
     * @return The view controller of the popover.
     */
    @CMGetter("@property(nonatomic, strong) UIViewController *contentViewController;")
    public UIViewController contentViewController() {
        return contentViewController;
    }

    /**
     * Set the specified view controller for the popover.
     *
     * @param contentViewController The view controller of the popover.
     */
    @CMSetter("@property(nonatomic, strong) UIViewController *contentViewController;")
    public void setContentViewController(UIViewController contentViewController) {
        this.contentViewController = contentViewController;
    }

    /**
     * Returns the size of the popover.
     *
     * @return The size of the popover.
     */
    @CMGetter("@property(nonatomic) CGSize popoverContentSize;")
    public CGSize popoverContentSize() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Sets the size of the popover.
     *
     * @param popoverContentSize The size of the popover.
     */
    @CMSetter("@property(nonatomic) CGSize popoverContentSize;")
    public void setPopoverContentSize(CGSize popoverContentSize) {
        Native.system().notImplemented();
    }

    /**
     * Returns a Boolean that shows whether the popover is visible.
     *
     * @return TRUE then the popover is visible.
     */
    @CMGetter("@property(nonatomic, readonly, getter=isPopoverVisible) BOOL popoverVisible;")
    public boolean isPopoverVisible() {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Returns the direction of the popover arrow.
     *
     * @return The direction of the popover arrow.
     */
    @CMGetter("@property(nonatomic, readonly) UIPopoverArrowDirection popoverArrowDirection;")
    public long popoverArrowDirection() {
        Native.system().notImplemented();
        return 0;
    }

    /**
     * Returns the list of views related to the popover.
     *
     * @return The list of views related to the popover.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<__kindof UIView *> *passthroughViews;")
    public List<UIView> passthroughViews() {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Relates the specified list of views with the popover.
     *
     * @param passthroughViews The list of views related to the popover.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<__kindof UIView *> *passthroughViews;")
    public void setPassthroughViews(List<UIView> passthroughViews) {
        Native.system().notImplemented();
    }

    /**
     * Set the specified view controller for the popover using animation or not.
     *
     * @param viewController The view controller of the popover.
     * @param animated       TRUE the change is animated.
     */
    @CMSelector("- (void)setContentViewController:(UIViewController *)viewController \n" +
            "                        animated:(BOOL)animated;")
    public void setContentViewController(UIViewController viewController, boolean animated) {
        Native.system().notImplemented();
    }

    /**
     * Resizes the popover using animation or not.
     *
     * @param size     The new size of the popover.
     * @param animated TRUE the change is animated.
     */
    @CMSelector("- (void)setPopoverContentSize:(CGSize)size \n" +
            "                     animated:(BOOL)animated;")
    public void setPopoverContentSize(CGSize size, boolean animated) {
        Native.system().notImplemented();
    }

    /**
     * Displays the popover using animation or not and anchor it to the
     * specified location of the view.
     *
     * @param rect            The rectangular area of the view that contains the popover.
     * @param view            The view that contains the popover.
     * @param arrowDirections The arrow that determines the side of the
     *                        rectangle to which the popover is positioned.
     * @param animated        TRUE then the change is animated.
     */
    @CMSelector("- (void)presentPopoverFromRect:(CGRect)rect \n" +
            "                        inView:(UIView *)view \n" +
            "      permittedArrowDirections:(UIPopoverArrowDirection)arrowDirections \n" +
            "                      animated:(BOOL)animated;")
    public void presentPopoverFromRect(CGRect rect, UIView view, long arrowDirections, boolean animated) {
        Native.system().notImplemented();
    }

    /**
     * Displays the popover using animation or not and anchors it to the
     * specified bar button item.
     *
     * @param item            The bar button item to which the popover is anchored.
     * @param arrowDirections The arrow that determines the side of the bar
     *                        button item to which the popover is positioned.
     * @param animated        TRUE then the change is animated.
     */
    @CMSelector("- (void)presentPopoverFromBarButtonItem:(UIBarButtonItem *)item \n" +
            "               permittedArrowDirections:(UIPopoverArrowDirection)arrowDirections \n" +
            "                               animated:(BOOL)animated;")
    public void presentPopoverFromBarButtonItem(UIBarButtonItem item, long arrowDirections, boolean animated) {
        Native.system().notImplemented();
    }

    /**
     * Dismisses the popover programmatically using animation or not.
     *
     * @param animated TRUE then the change is animated.
     */
    @CMSelector("- (void)dismissPopoverAnimated:(BOOL)animated;")
    public void dismissPopoverAnimated(boolean animated) {
        Native.system().notImplemented();
    }
}
