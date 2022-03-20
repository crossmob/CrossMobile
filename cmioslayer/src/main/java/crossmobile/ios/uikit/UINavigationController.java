/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.GraphicsBridgeConstants;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * UINavigationController class defines an object that handles view controllers
 * related to views organized in a hierarchy.
 */
@SuppressWarnings("deprecation")
@CMClass
public class UINavigationController extends UIViewController {

    private List<UIViewController> items;
    private UINavigationControllerDelegate delegate;
    private final UINavigationBar navigationBar;
    private final UIToolbar toolBar;


    /**
     * The default UINavigationController required for the
     * MFMessageComposeViewController.
     */
    public UINavigationController() {
        this(null);
    }

    /**
     * Initializes and returns a newly created navigation controller.
     *
     * @param rootViewController The view controller that resides at the bottom
     *                           of the navigation stack. This object cannot be an instance of the
     *                           UITabBarController class.
     */
    @SuppressWarnings({"LeakingThisInConstructor", "OverridableMethodCallInConstructor"})
    @CMConstructor("- (instancetype)initWithRootViewController:(UIViewController *)rootViewController;")
    public UINavigationController(UIViewController rootViewController) {
        navigationBar = new UINavigationBar();
        navigationBar.setNavigationController(this);
        toolBar = new UIToolbar();
        toolBar.setHidden(true);
        toolBar.setNavigationController(this);
        items = new ArrayList<>();
        pushViewController(rootViewController, false, false);
    }

    /**
     * Returns the top view controller of the navigation stack.
     *
     * @return The top view controller of the navigation stack.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIViewController *topViewController;")
    public UIViewController topViewController() {
        int size = items.size();
        if (size < 1)
            return null;
        return items.get(size - 1);
    }

    /**
     * Returns the view controller whose view is currently visible on screen.
     *
     * @return Theview controller whose view is currently visible on screen.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIViewController *visibleViewController;")
    public UIViewController visibleViewController() {
//        if (hasModalViewController())
//            return modalViewController();
//        else
        return topViewController();
    }

    /**
     * Returns the list of view controllers currently into the navigation stack.
     *
     * @return The list of view controllers currently into the navigation stack.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;")
    public List<UIViewController> viewControllers() {
        return new ArrayList<>(items);
    }

    /**
     * Sets the list of view controllers into the navigation stack replacing the
     * existing.
     *
     * @param controllers The new list of view controllers.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;")
    public void setViewControllers(List<UIViewController> controllers) {
        setViewControllers(controllers, false);
    }

    /**
     * Sets the list of view controllers into the navigation stack replacing the
     * existing using animation or not.
     *
     * @param controllers The new list of view controllers.
     * @param animated    TRUE the change is animated.
     */
    @CMSelector("- (void)setViewControllers:(NSArray<UIViewController *> *)viewControllers \n"
            + "                  animated:(BOOL)animated;")
    public void setViewControllers(List<UIViewController> controllers, boolean animated) {
        if (controllers == null || controllers.size() < 1)
            throw new RuntimeException("Attempting to assign empty Navigation list!");

        UIViewController old = topViewController();
        UIViewController cur = controllers.get(controllers.size() - 1);
        items = new ArrayList<>(controllers);

        List<UINavigationItem> navitems = new ArrayList<>();
        for (UIViewController c : items) {
            c.setParentController(this);
            navitems.add(c.navigationItem());
        }
        navigationBar.setItems(navitems);
        preExchange(old, cur, animated);
        updateView(new PostExchangeDelegate(old, cur, animated), animated ? UIViewAnimationOptions.TransitionFlipFromRight : UIViewAnimationOptions.TransitionNone);
    }

    /**
     * Pushes the specified view controller into this navigation stack and
     * updates the display.
     *
     * @param controller The view controller that is pushed into the stack.
     * @param animated   TRUE the push is animated.
     */
    @CMSelector("- (void)pushViewController:(UIViewController *)viewController \n"
            + "                  animated:(BOOL)animated;")
    public void pushViewController(UIViewController controller, boolean animated) {
        pushViewController(controller, animated, isViewLoaded());
    }

    private void pushViewController(UIViewController controller, boolean animated, boolean updateViews) {
        if (controller == null)
            return;
//        if (controller instanceof UINavigationController)
//            throw new IllegalArgumentException("Pushing a navigation controller is not supported");
        controller.setParentController(this);
        UIViewController old = topViewController();
        items.add(controller);
        if (!updateViews)
            return;

        navigationBar.pushNavigationItem(controller.navigationItem(), animated);
        preExchange(old, controller, animated);
        updateView(new PostExchangeDelegate(old, controller, animated), animated ? UIViewAnimationOptions.TransitionFlipFromRight : UIViewAnimationOptions.TransitionNone);
    }

    @Override
    public void showViewController(UIViewController vc, Object sender) {
        pushViewController(vc, true, isViewLoaded());
    }

    /**
     * Returns and pops the top view controller of the navigation stack using
     * animation or not.
     *
     * @param animated TRUE the pop is animated
     * @return The view controller that was popped from the stack.
     */
    @CMSelector("- (UIViewController *)popViewControllerAnimated:(BOOL)animated;")
    public UIViewController popViewControllerAnimated(boolean animated) {
        return popViewControllerAnimated(animated, isViewLoaded());
    }

    private UIViewController popViewControllerAnimated(boolean animated, boolean updateViews) {
        int idx = items.size() - 1;
        if (idx < 1)
            return null;

        UIViewController old = items.get(idx);
        items.remove(idx);
        if (!updateViews)
            return old;
        idx--;
        UIViewController cur = items.get(idx);
        preExchange(old, cur, animated);
        navigationBar.popNavigationItemAnimated(animated);
        old.setParentController(null);
        updateView(new PostExchangeDelegate(old, cur, animated), animated ? UIViewAnimationOptions.TransitionFlipFromLeft : UIViewAnimationOptions.TransitionNone);
        return old;
    }

    /**
     * Returns the list of all the view controllers of the navigation stack that
     * are poped out using animation or not, until the specified view
     * controller.
     *
     * @param controller The view controller that is left at the top of the
     *                   navigation stack.
     * @param animated   TRUE the pop is animated.
     * @return The list of all the view controllers of the stack that are poped
     * out.
     */
    @CMSelector("- (NSArray<__kindof UIViewController *> *)popToViewController:(UIViewController *)viewController \n"
            + "                                                     animated:(BOOL)animated;")
    public List<UIViewController> popToViewController(UIViewController controller, boolean animated) {
        int idx = items.indexOf(controller);
        if (idx < 0 || idx == (items.size() - 1))
            return new ArrayList<>();

        UIViewController old = topViewController();
        preExchange(old, controller, animated);

        List<UIViewController> res = new ArrayList<>();
        List<UINavigationItem> navitems = navigationBar.items();
        int howmany = items.size() - 1 - idx;
        for (int i = 0; i < howmany; i++) {
            UIViewController item = items.remove(idx + 1);
            item.setParentController(null);
            res.add(item);
            navitems.remove(idx + 1);
        }
        navigationBar.setItems(navitems);

        updateView(new PostExchangeDelegate(old, controller, animated), animated ? UIViewAnimationOptions.TransitionFlipFromLeft : UIViewAnimationOptions.TransitionNone);
        return res;
    }

    /**
     * Returns the list of all the view controllers of the navigation stack that
     * are poped out using animation or not. Leaves only the root view
     * controller as the top view controller and updates the display.
     *
     * @param animated TRUE the pop is animated.
     * @return The list of all the view controllers of the navigation stack that
     * are poped out.
     */
    @CMSelector("- (NSArray<__kindof UIViewController *> *)popToRootViewControllerAnimated:(BOOL)animated;")
    public List<UIViewController> popToRootViewControllerAnimated(boolean animated) {
        return popToViewController(items.get(0), animated);
    }

    /**
     * Returns a Boolean that indicates whether the navigation bar of this
     * navigation controller is hidden.
     *
     * @return TRUE then the navigation bar of this navigation controller is
     * hidden.
     */
    @CMGetter("@property(nonatomic, getter=isNavigationBarHidden) BOOL navigationBarHidden;")
    public boolean isNavigationBarHidden() {
        return navigationBar.isHidden();
    }

    /**
     * Sets a Boolean that defines whether the navigation bar of this navigation
     * controller. is hidden.
     *
     * @param navigationBarHidden TRUE then the navigation bar of this
     *                            navigation controller is hidden.
     */
    @CMSetter("@property(nonatomic, getter=isNavigationBarHidden) BOOL navigationBarHidden;")
    public void setNavigationBarHidden(boolean navigationBarHidden) {
        setNavigationBarHidden(navigationBarHidden, false);
    }

    /**
     * Hides or shows the navigation bar of this controller using animation or
     * not.
     *
     * @param navigationBarHidden TRUE then sets the navigation bar hidden.
     * @param animated            TRUE then the change is animated.
     */
    @CMSelector("- (void)setNavigationBarHidden:(BOOL)hidden \n"
            + "                      animated:(BOOL)animated;")
    public void setNavigationBarHidden(boolean navigationBarHidden, boolean animated) {
        navigationBar.setHidden(navigationBarHidden);
        if (isViewLoaded())
            view().layoutSubviews();
    }

    /**
     * Returns the navigation bar of this navigation controller.
     *
     * @return The navigation bar of this navigation controller.
     */
    @CMGetter("@property(nonatomic, readonly) UINavigationBar *navigationBar;")
    public UINavigationBar navigationBar() {
        return navigationBar;
    }

    /**
     * Returns a Boolean that defines toolbar's visibility.
     *
     * @return TRURE then the toolbar is hidden.
     */
    @CMGetter("@property(nonatomic, getter=isToolbarHidden) BOOL toolbarHidden;")
    public boolean isToolbarHidden() {
        return toolBar.isHidden();
    }

    /**
     * Sets a Boolean that defines whether toolbar is hidden or not.
     *
     * @param toolbarHidden TRUE then sets the toolbar hidden.
     */
    @CMSetter("@property(nonatomic, getter=isToolbarHidden) BOOL toolbarHidden;")
    public void setToolbarHidden(boolean toolbarHidden) {
        setToolbarHidden(toolbarHidden, false);
    }

    /**
     * Hides or shows toolbar using animation or not.
     *
     * @param toolbarHidden TRUE then hides the toolbar.
     * @param animated      TRUE then uses animation for the change.
     */
    @CMSelector("- (void)setToolbarHidden:(BOOL)hidden \n"
            + "                animated:(BOOL)animated;")
    public void setToolbarHidden(boolean toolbarHidden, boolean animated) {
        toolBar.setHidden(toolbarHidden);
    }

    /**
     * Returns the custom toolbar of this navigation controller.
     *
     * @return The custom toolbar of this navigation controller.
     */
    @CMGetter("@property(nonatomic, readonly) UIToolbar *toolbar;")
    public UIToolbar toolbar() {
        return toolBar;
    }

    /**
     * Sets the delegate for this navigation controller.
     *
     * @param delegate The delegate for this navigation controller.
     * @see crossmobile.ios.uikit.UINavigationControllerDelegate
     */
    @CMSetter("@property(nonatomic, weak) id<UINavigationControllerDelegate> delegate;")
    public void setDelegate(UINavigationControllerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the delegate of this navigation controller.
     *
     * @return The delegate of this navigation controller.
     * @see crossmobile.ios.uikit.UINavigationControllerDelegate
     */
    @CMGetter("@property(nonatomic, weak) id<UINavigationControllerDelegate> delegate;")
    public UINavigationControllerDelegate delegate() {
        return this.delegate;
    }

    private void updateInsets(UIViewController topController, int sign) {
        UIScrollView scroll = null;
        if (topController != null)
            scroll = topController.getFirstScroll();
        if (scroll != null && topController.automaticallyAdjustsScrollViewInsets()) {
            double top = navigationBar.isHidden() || !navigationBar.isTranslucent() || scroll.frame().getOrigin().getY() > navigationBar.cframe().getSize().getHeight()
                    ? 0 : navigationBar.cframe().getSize().getHeight() - scroll.frame().getOrigin().getY();
            double bottom = toolBar.isHidden() || !toolBar.isTranslucent() ? 0 : toolBar.cframe().getSize().getHeight();
            UIEdgeInsets edge = new UIEdgeInsets(sign * top,
                    scroll.contentInset.getLeft(),
                    scroll.contentInset.getBottom() + sign * bottom,
                    scroll.contentInset.getRight());
            scroll.setContentInset(edge);
            scroll.setScrollIndicatorInsets(edge);
        }
    }

    @Override
    public void viewWillAppear(boolean animated) {
        UIViewController controller = topViewController();
        if (controller != null) {
            if (!controller.isViewLoaded())
                controller.loadView();
            controller.viewSafeAreaInsetsDidChange();
            controller.viewWillAppear(animated);
        }
    }

    @Override
    public void viewDidAppear(boolean animated) {
        UIViewController controller = topViewController();
        if (controller != null)
            controller.viewDidAppear(animated);
    }

    @Override
    public void viewWillDisappear(boolean animated) {
        UIViewController controller = topViewController();
        if (controller != null)
            controller.viewWillDisappear(animated);
    }

    @Override
    public void viewDidDisappear(boolean animated) {
        UIViewController controller = topViewController();
        if (controller != null)
            controller.viewDidDisappear(animated);
    }

    @Override
    public void didReceiveMemoryWarning() {
        for (UIViewController vc : items)
            vc.didReceiveMemoryWarning();
        super.didReceiveMemoryWarning();
    }

    @Override
    public void willRotateToInterfaceOrientation(int UIInterfaceOrientation, double duration) {
        UIViewController controller = topViewController();
        if (controller != null) {
            controller.willRotateToInterfaceOrientation(UIInterfaceOrientation, duration);
            UIScrollView scroll = controller.getFirstScroll();
            if (scroll != null && controller.automaticallyAdjustsScrollViewInsets()) {
                // recalculate insets for the new orientation
            }
        }
    }

    @Override
    public void didRotateFromInterfaceOrientation(int UIInterfaceOrientation) {
        if (isViewLoaded())
            view().layoutSubviews();
        UIViewController controller = topViewController();
        if (controller != null)
            controller.didRotateFromInterfaceOrientation(UIInterfaceOrientation);
    }

    @Override
    public void willAnimateRotationToInterfaceOrientation(int UIInterfaceOrientation, double duration) {
        UIViewController controller = topViewController();
        if (controller != null)
            controller.willAnimateRotationToInterfaceOrientation(UIInterfaceOrientation, duration);
    }

    @Override
    public void loadView() {
        setView(new NavigationView());
        List<UIViewController> newlist = items;
        items = Collections.emptyList();
        setViewControllers(newlist, false);
    }

    @Override
    public UITabBarItem tabBarItem() {
        UIViewController top = topViewController();
        if (top != null && top.tabBarItem != null)
            return top.tabBarItem;
        return super.tabBarItem();
    }

    void renewInsets(boolean b) {
        if (b)
            updateInsets(topViewController(), -1);
        else
            updateInsets(topViewController(), 1);
    }

    void updateView(final PostExchangeDelegate postEx, int animationOptions) {
        Native.widget().resignFocus();
        UIViewController topVC = topViewController();
        NavigationView thisView = (NavigationView) view();
        UIView childView = topVC.view();

        if (childView == thisView.childView)
            return;
        thisView.layoutViewAsCore(childView, true);   // do this before animations!

        Runnable actions = () -> {
            UIView oldChildView = thisView.childView;
            boolean oldChildViewExists = oldChildView != null;
            thisView.childView = childView;
            thisView.insertSubview(childView, oldChildViewExists ? 1 : 0);
            if (oldChildViewExists)
                oldChildView.removeFromSuperview();
        };

        if (animationOptions != UIViewAnimationOptions.TransitionNone) {
            boolean originalInteractionsEnabled = thisView.isUserInteractionEnabled();
            thisView.setUserInteractionEnabled(false);
            UIView.transitionWithView(thisView, GraphicsBridgeConstants.DefaultAnimationDuration, animationOptions, actions, result -> {
                postEx.perform();
                thisView.setUserInteractionEnabled(originalInteractionsEnabled);
            });
        } else
            actions.run();

        toolBar.setItems(topVC.toolbarItems());
        thisView.bringSubviewToFront(toolBar);
        thisView.bringSubviewToFront(navigationBar);

        if (animationOptions == UIViewAnimationOptions.TransitionNone && postEx != null)
            Native.lifecycle().postOnEventThread(postEx::perform);
    }

    private void preExchange(UIViewController old, UIViewController current, boolean animated) {
        if (old != null)
            old.viewWillDisappear(animated);
        if (current != null) {
            if (!current.isViewLoaded())
                current.view();  // To properly initialize view
            if (isViewLoaded())
                current.execViewWillAppear(animated);
        }
        if (delegate != null)
            delegate.willShowViewController(this, topViewController(), animated);
    }

    private class PostExchangeDelegate {

        private final UIViewController old;
        private final UIViewController current;
        private final boolean animated;

        public PostExchangeDelegate(UIViewController old, UIViewController current, boolean animated) {
            this.old = old;
            this.current = current;
            this.animated = animated;
        }

        void perform() {
            if (delegate != null)
                delegate.didShowViewController(UINavigationController.this, current, animated);
            if (old != null) {
                updateInsets(old, -1);
                old.viewDidDisappear(animated);
            }
            view().layoutSubviews();
            if (current != null)
                current.execViewDidAppear(animated);
        }
    }

    private final class NavigationView extends UIView {

        private UIView childView;

        public NavigationView() {
            super(new CGRect(0, 0, 300, 300));
            navigationBar.fixMetricsForStatusBar(UINavigationController.this, this);
            addSubview(navigationBar);
            toolBar.setFrame(new CGRect(0, 300 - Theme.Bar.Tool.DEFAULTHEIGHT, 300, Theme.Bar.Tool.DEFAULTHEIGHT));
            toolBar.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth | UIViewAutoresizing.FlexibleTopMargin);
            addSubview(toolBar);
        }

        @Override
        public void layoutSubviews() {
            super.layoutSubviews();
            layoutViewAsCore(childView, false);
            if (childView != null) {    // null due to early initialization, i.e. at viewWillLoad
                childView.layoutSubviews();
                navigationBar.fixMetricsForStatusBar(UINavigationController.this, childView);
            }
        }

        // Update view needs not to re-layout, but to position new child view instead
        void layoutViewAsCore(UIView view, boolean updateInsets) {
            if (view != null) {
                boolean needsClearViews = view.controller != null && view.controller.viewShouldNotOverlapWithParentDecorations();
                CGRect activeRect = getActiveFrame();
                double transNavBarHeight = navigationBar.isTranslucent() && !needsClearViews ? 0 : navBarHeight();
                double transToolBarHeight = toolBar.isTranslucent() && !needsClearViews ? 0 : toolBarHeight();
                activeRect.getOrigin().setY(activeRect.getOrigin().getY() + transNavBarHeight);
                activeRect.getSize().setHeight(activeRect.getSize().getHeight() - (transNavBarHeight + transToolBarHeight));
                view.setFrame(activeRect);
                if (updateInsets)
                    updateInsets(view.controller, 1);
            }
        }

    }

    @Override
    UIEdgeInsets getTotalSafeAreaInsets() {
        UIEdgeInsets safeInsets = super.getTotalSafeAreaInsets();
        safeInsets.setTop(safeInsets.getTop() + navBarHeight());
        safeInsets.setBottom(safeInsets.getBottom() + toolBarHeight());
        return safeInsets;
    }

    boolean viewShouldNotOverlapWithParentDecorations() {
        return true;
    }

    private double navBarHeight() {
        return navigationBar.isHidden() ? 0 : navigationBar.cframe().getSize().getHeight();
    }

    private double toolBarHeight() {
        return toolBar.isHidden() ? 0 : toolBar.cframe().getSize().getHeight();
    }
}
