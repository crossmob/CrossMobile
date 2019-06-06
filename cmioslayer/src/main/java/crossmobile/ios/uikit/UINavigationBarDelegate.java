/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UINavigationBarDelegate interface is the delegate responsible for handling
 * push and pop actions of a navigation bar.
 */
@CMClass
public interface UINavigationBarDelegate {

    /**
     * It is used before an item is pushed to the navigation bar.
     *
     * @param bar  The navigation bar that corresponds to this delegate.
     * @param item The item that is about to be pushed to the navigation bar.
     * @return TRUE if the push is permitted.
     */
    @CMSelector("- (BOOL)navigationBar:(UINavigationBar *)navigationBar \n"
            + "       shouldPushItem:(UINavigationItem *)item;")
    default boolean shouldPushItem(UINavigationBar bar, UINavigationItem item) {
        return true;
    }

    /**
     * It is used after an item is pushed to the navigation bar.
     *
     * @param bar  The navigation bar that corresponds to this delegate.
     * @param item The item that was pushed to the navigation bar
     */
    @CMSelector("- (void)navigationBar:(UINavigationBar *)navigationBar \n"
            + "          didPushItem:(UINavigationItem *)item;")
    default void didPushItem(UINavigationBar bar, UINavigationItem item) {
    }

    /**
     * It is used before an item is popped from the navigation bar.
     *
     * @param bar  The navigation bar that corresponds to this delegate.
     * @param item The item that is about to be popped from the navigation bar.
     * @return TRUE if the pop is permitted.
     */
    @CMSelector("- (BOOL)navigationBar:(UINavigationBar *)navigationBar \n"
            + "        shouldPopItem:(UINavigationItem *)item;")
    default boolean shouldPopItem(UINavigationBar bar, UINavigationItem item) {
        return true;
    }

    /**
     * It is used after an item is poped from the navigation bar.
     *
     * @param bar  The navigation bar that corresponds to this delegate.
     * @param item The item that was poped from the navigation bar
     */
    @CMSelector("- (void)navigationBar:(UINavigationBar *)navigationBar \n"
            + "           didPopItem:(UINavigationItem *)item;")
    default void didPopItem(UINavigationBar bar, UINavigationItem item) {
    }
}
