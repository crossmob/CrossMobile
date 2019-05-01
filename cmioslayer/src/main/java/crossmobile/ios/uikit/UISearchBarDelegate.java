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
 * UISearchBarDelegate interface is the delegate that handles events related to
 * search bar objects.
 */
@CMClass
public interface UISearchBarDelegate {

    /**
     * It is used when the user changed the search text.
     *
     * @param p1 The search bar that corresponds to this delegate.
     * @param p2 The current text of the search field.
     */
    @CMSelector("- (void)searchBar:(UISearchBar *)searchBar \n"
            + "    textDidChange:(NSString *)searchText;")
    public default void textDidChange(UISearchBar p1, String p2) {
    }

    /**
     * It is used when the search text editing is permitted.
     *
     * @param p1 The search bar that corresponds to this delegate.
     * @return TRUE if editing is permitted.
     */
    @CMSelector("- (BOOL)searchBarShouldBeginEditing:(UISearchBar *)searchBar;")
    public default boolean shouldBeginEditing(UISearchBar p1) {
        return true;
    }

    /**
     * It is used when the search text editing just finished.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarTextDidBeginEditing:(UISearchBar *)searchBar;")
    public default void textDidBeginEditing(UISearchBar p1) {
    }

    /**
     * It is used when the search text editing should finish.
     *
     * @param p1 The search bar that corresponds to this delegate.
     * @return TRUE if editing should finish.
     */
    @CMSelector("- (BOOL)searchBarShouldEndEditing:(UISearchBar *)searchBar;")
    public default boolean shouldEndEditing(UISearchBar p1) {
        return true;
    }

    /**
     * It is used when the search text editing has finished.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarTextDidEndEditing:(UISearchBar *)searchBar;")
    public default void textDidEndEditing(UISearchBar p1) {
    }

    /**
     * It is used when the bookmark button was tapped.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarBookmarkButtonClicked:(UISearchBar *)searchBar;")
    public default void bookmarkButtonClicked(UISearchBar p1) {
    }

    /**
     * It is used when the cancel button was tapped.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarCancelButtonClicked:(UISearchBar *)searchBar;")
    public default void cancelButtonClicked(UISearchBar p1) {
    }

    /**
     * It is used when the search button was tapped.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarSearchButtonClicked:(UISearchBar *)searchBar;")
    public default void searchButtonClicked(UISearchBar p1) {
    }

    /**
     * It is used when the scope button selected changed.
     *
     * @param p1 The search bar that corresponds to this delegate.
     * @param p2 The selected scope button defined by its index.
     */
    @CMSelector("- (void)searchBar:(UISearchBar *)searchBar \n"
            + "selectedScopeButtonIndexDidChange:(NSInteger)selectedScope;")
    public default void selectedScopeButtonIndexDidChange(UISearchBar p1, int p2) {
    }
}
