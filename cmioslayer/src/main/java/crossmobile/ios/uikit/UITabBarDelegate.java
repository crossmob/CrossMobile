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
