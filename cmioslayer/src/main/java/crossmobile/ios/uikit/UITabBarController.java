/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.ArrayList;
import java.util.List;

/**
 * UITabBarController class defines a view controller for the tab bar.
 */
@CMClass
public class UITabBarController extends UIViewController {

    private UITabBarControllerDelegate delegate;
    private final UITabBar tabBar;
    private List<UIViewController> viewControllers;
    private List<UIViewController> customizableViewControllers;
    private int selectedIndex;

    /**
     * The default UITabBarController constructor.
     */
    @SuppressWarnings({"LeakingThisInConstructor", "deprecation"})
    public UITabBarController() {
        delegate = null;
        tabBar = new UITabBar(new CGRect(0, 0, UIScreen.mainScreen().applicationFrame().getSize().getWidth(), 49));
        tabBar.tbcontrol = this;
        viewControllers = null;
        customizableViewControllers = null;
        selectedIndex = -1;
    }

    @Override
    public void loadView() {
        setView(new TabView());
        setViewControllers(viewControllers, true);
        setSelectedIndex(selectedIndex, true);
    }

    /**
     * Returns the list of customized view controllers related to this tab bar
     * controller.
     *
     * @return The list of customized view controllers related to this tab bar
     * controller.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<__kindof UIViewController *> *customizableViewControllers;")
    public List<UIViewController> customizableViewControllers() {
        return customizableViewControllers == null ? null : new ArrayList<>(customizableViewControllers);
    }

    /**
     * Sets the list of customized view controllers related to this tab bar
     * controller.
     *
     * @param viewControllers The list of customized view controllers related to
     *                        this tab bar controller.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<__kindof UIViewController *> *customizableViewControllers;")
    public void setCustomizableViewControllers(List<UIViewController> viewControllers) {
        this.customizableViewControllers = viewControllers == null ? null : new ArrayList<>(viewControllers);
    }

    /**
     * Returns the delegate for this tab bar controller.
     *
     * @return The delegate for this tab bar controller.
     */
    @CMGetter("@property(nonatomic, weak) id<UITabBarControllerDelegate> delegate;")
    public UITabBarControllerDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this tab bar controller.
     *
     * @param delegate The delegate for this tab bar controller.
     */
    @CMSetter("@property(nonatomic, weak) id<UITabBarControllerDelegate> delegate;")
    public void setDelegate(UITabBarControllerDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns the view controller that is responsible for the More navigation
     * interface.
     *
     * @return The view controller that is responsible for the More navigation
     * interface.
     */
    @CMGetter("@property(nonatomic, readonly) UINavigationController *moreNavigationController;")
    public UINavigationController moreNavigationController() {
        return null;
    }

    /**
     * Returns the view controller related to the selected item.
     *
     * @return The view controller related to the selected item.
     */
    @CMGetter("@property(nonatomic, assign) __kindof UIViewController *selectedViewController;")
    public UIViewController selectedViewController() {
        return selectedIndex < 0 || viewControllers == null || selectedIndex >= viewControllers.size() ? null : viewControllers.get(selectedIndex);
    }

    /**
     * Sets the view controller related to the selected item.
     *
     * @param selectedViewController The view controller related to the selected
     *                               item.
     */
    @CMSetter("@property(nonatomic, assign) __kindof UIViewController *selectedViewController;")
    public void setSelectedViewController(UIViewController selectedViewController) {
        setSelectedIndex(selectedViewController == null || viewControllers == null || viewControllers.isEmpty() ? -1 : viewControllers.indexOf(selectedViewController));
    }

    /**
     * Returns the index of the controller related to the selected bar item.
     *
     * @return The index of the controller related to the selected bar item.
     */
    @CMGetter("@property(nonatomic) NSUInteger selectedIndex;")
    public int selectedIndex() {
        return selectedIndex;
    }

    /**
     * Sets the index of the controller related to the selected bar item.
     *
     * @param selectedIndex The index of the controller related to the selected
     *                      bar item.
     */
    @CMSetter("@property(nonatomic) NSUInteger selectedIndex;")
    public void setSelectedIndex(int selectedIndex) {
        setSelectedIndex(selectedIndex, isViewLoaded());
    }

    private void setSelectedIndex(int selectedIndex, boolean updateViews) {
        if (selectedIndex < 0 || viewControllers == null || viewControllers.isEmpty() || selectedIndex == this.selectedIndex)
            return;
        UIViewController older = this.selectedIndex >= 0 ? viewControllers.get(this.selectedIndex) : null;
        this.selectedIndex = selectedIndex < viewControllers.size() ? selectedIndex : -1;
        UIViewController newer = this.selectedIndex >= 0 ? viewControllers.get(selectedIndex) : null;

        if (older != null)
            older.viewWillDisappear(false);
        if (!updateViews)
            return;
        if (newer != null) {
            if (!newer.isViewLoaded())
                newer.loadView();
            newer.execViewWillAppear(false);
        }
        tabBar.setSelectedIndex(this.selectedIndex);
        updateView();
        if (older != null)
            older.viewWillDisappear(false);
        if (newer != null)
            newer.execViewDidAppear(false);
    }

    /**
     * Returns the tab bar related to this controller.
     *
     * @return The tab bar related to this controller.
     */
    @CMGetter("@property(nonatomic, readonly) UITabBar *tabBar;")
    public UITabBar tabBar() {
        return tabBar;
    }

    /**
     * Returns the list of root view controllers displayed by this tab bar.
     *
     * @return The list of root view controllers displayed by this tab bar.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;")
    public List<UIViewController> viewControllers() {
        return viewControllers == null ? null : new ArrayList<>(viewControllers);
    }

    /**
     * Assigns the list of view controllers to be displayed by this tab bar
     * controller.
     *
     * @param viewControllers The list of view controllers to be displayed by
     *                        this tab bar controller.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<__kindof UIViewController *> *viewControllers;")
    public void setViewControllers(List<UIViewController> viewControllers) {
        setViewControllers(viewControllers, false);
    }

    /**
     * Assigns the list of the root view controllers to be displayed by this tab
     * bar controller.
     *
     * @param viewControllers The list of root view controllers assigned to this
     *                        tab bar controller.
     * @param animated        TRUE the change is animated.
     */
    @CMSelector("- (void)setViewControllers:(NSArray<__kindof UIViewController *> *)viewControllers \n"
            + "                  animated:(BOOL)animated;")
    public void setViewControllers(List<UIViewController> viewControllers, boolean animated) {
        setViewControllers(viewControllers, animated, isViewLoaded());
    }

    private void setViewControllers(List<UIViewController> viewControllers, boolean animated, boolean updateViews) {
        if (viewControllers == null)
            return;
        this.viewControllers = new ArrayList<>(viewControllers);
        if (!updateViews)
            return;

        List<UITabBarItem> tabs = new ArrayList<>();
        for (UIViewController contr : viewControllers) {
            contr.setParentController(this);
            tabs.add(contr.tabBarItem());
        }
        tabBar.setItems(tabs, animated);
    }

    void updateView() {
        Native.widget().resignFocus();
        UIViewController activeVC = selectedViewController();
        TabView thisView = (TabView) view();
        UIView childView = activeVC.view();

        if (childView == thisView.childView)
            return;
        thisView.layoutViewAsCore(childView);   // do this before animations!
        if (thisView.childView != null)
            thisView.childView.removeFromSuperview();
        thisView.childView = childView;
        thisView.addSubview(childView);
        thisView.bringSubviewToFront(tabBar);
    }

    @Override
    public void didReceiveMemoryWarning() {
        for (UIViewController vc : viewControllers)
            vc.didReceiveMemoryWarning();
        super.didReceiveMemoryWarning();
    }

    @Override
    boolean viewShouldNotOverlapWithParentDecorations() {
        return true;
    }

    private final class TabView extends UIView {

        private UIView childView;

        public TabView() {
            super(new CGRect(0, 0, 300, 300));
            tabBar.setFrame(new CGRect(0, 300 - Theme.Bar.Tab.DEFAULTHEIGHT, 300, Theme.Bar.Tab.DEFAULTHEIGHT));
            tabBar.setAutoresizingMask(UIViewAutoresizing.FlexibleWidth | UIViewAutoresizing.FlexibleTopMargin);
            addSubview(tabBar);
        }

        @Override
        public void layoutSubviews() {
            super.layoutSubviews();
            layoutViewAsCore(childView);
        }

        // Update view needs not to re-layout, but to position new child view instead
        void layoutViewAsCore(UIView view) {
            if (view != null) {
                float tabBarHeight = tabBar.isHidden() ? 0 : Theme.Bar.Tab.DEFAULTHEIGHT;
                view.setFrame(new CGRect(0, 0, cframe().getSize().getWidth(), cframe().getSize().getHeight() - tabBarHeight));
            }
        }
    }
}
