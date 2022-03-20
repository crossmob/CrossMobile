/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;

/**
 * UITabBarDelegate interface is the delegate responsible for the customization
 * of tab bar objects.
 */
@CMClass
public interface UITabBarDelegate {

    /**
     * It is used before the display of the customized tab bar.
     *
     * @param bar   The tab bar that corresponds to this delegate.
     * @param items The items of the customized tab bar.
     */
    @CMSelector("- (void)tabBar:(UITabBar *)tabBar \n"
            + "willBeginCustomizingItems:(NSArray<UITabBarItem *> *)items;")
    default void willBeginCustomizingItems(UITabBar bar, List<UITabBarItem> items) {
    }

    /**
     * It is used after the display of the customized tab bar.
     *
     * @param bar   The tab bar that corresponds to this delegate.
     * @param items The items of the customized tab bar.
     */
    @CMSelector("- (void)tabBar:(UITabBar *)tabBar \n"
            + "didBeginCustomizingItems:(NSArray<UITabBarItem *> *)items;")
    default void didBeginCustomizingItems(UITabBar bar, List<UITabBarItem> items) {
    }

    /**
     * It is used before the dismissal of the customized tab bar.
     *
     * @param bar     The tab bar that corresponds to this delegate.
     * @param items   The items of the customized tab bar.
     * @param changed TRUE if tab bar's items did not change.
     */
    @CMSelector("- (void)tabBar:(UITabBar *)tabBar \n"
            + "willEndCustomizingItems:(NSArray<UITabBarItem *> *)items \n"
            + "       changed:(BOOL)changed;")
    default void willEndCustomizingItems(UITabBar bar, List<UITabBarItem> items, boolean changed) {
    }

    /**
     * It is used after the dismissal of the customized tab bar.
     *
     * @param bar     The tab bar that corresponds to this delegate.
     * @param items   The items on the customizing modal view.
     * @param changed TRUE if tab bar's items did not change.
     */
    @CMSelector("- (void)tabBar:(UITabBar *)tabBar \n"
            + "didEndCustomizingItems:(NSArray<UITabBarItem *> *)items \n"
            + "       changed:(BOOL)changed;")
    default void didEndCustomizingItems(UITabBar bar, List<UITabBarItem> items, boolean changed) {
    }

    /**
     * It is used after the user selected a tab bar item.
     *
     * @param bar  The tab bar that corresponds to this delegate.
     * @param item The selected tab bar item.
     */
    @CMSelector("- (void)tabBar:(UITabBar *)tabBar \n"
            + " didSelectItem:(UITabBarItem *)item;")
    public void didSelectItem(UITabBar bar, UITabBarItem item);
}
