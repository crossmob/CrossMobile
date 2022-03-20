/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
    default void textDidChange(UISearchBar p1, String p2) {
    }

    /**
     * It is used when the search text editing is permitted.
     *
     * @param p1 The search bar that corresponds to this delegate.
     * @return TRUE if editing is permitted.
     */
    @CMSelector("- (BOOL)searchBarShouldBeginEditing:(UISearchBar *)searchBar;")
    default boolean shouldBeginEditing(UISearchBar p1) {
        return true;
    }

    /**
     * It is used when the search text editing just finished.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarTextDidBeginEditing:(UISearchBar *)searchBar;")
    default void textDidBeginEditing(UISearchBar p1) {
    }

    /**
     * It is used when the search text editing should finish.
     *
     * @param p1 The search bar that corresponds to this delegate.
     * @return TRUE if editing should finish.
     */
    @CMSelector("- (BOOL)searchBarShouldEndEditing:(UISearchBar *)searchBar;")
    default boolean shouldEndEditing(UISearchBar p1) {
        return true;
    }

    /**
     * It is used when the search text editing has finished.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarTextDidEndEditing:(UISearchBar *)searchBar;")
    default void textDidEndEditing(UISearchBar p1) {
    }

    /**
     * It is used when the bookmark button was tapped.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarBookmarkButtonClicked:(UISearchBar *)searchBar;")
    default void bookmarkButtonClicked(UISearchBar p1) {
    }

    /**
     * It is used when the cancel button was tapped.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarCancelButtonClicked:(UISearchBar *)searchBar;")
    default void cancelButtonClicked(UISearchBar p1) {
    }

    /**
     * It is used when the search button was tapped.
     *
     * @param p1 The search bar that corresponds to this delegate.
     */
    @CMSelector("- (void)searchBarSearchButtonClicked:(UISearchBar *)searchBar;")
    default void searchButtonClicked(UISearchBar p1) {
    }

    /**
     * It is used when the scope button selected changed.
     *
     * @param p1 The search bar that corresponds to this delegate.
     * @param p2 The selected scope button defined by its index.
     */
    @CMSelector("- (void)searchBar:(UISearchBar *)searchBar \n"
            + "selectedScopeButtonIndexDidChange:(NSInteger)selectedScope;")
    default void selectedScopeButtonIndexDidChange(UISearchBar p1, int p2) {
    }
}
