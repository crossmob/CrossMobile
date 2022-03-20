/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSIndexPath;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * UITableView interface is the delegate that is responsible for handling
 * operations related to table views such as inserting and deleting cells.
 */
@CMClass
public interface UITableViewDelegate {

    /**
     * It is used before drawing a cell for a particular row.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param cell      The cell to be drawn.
     * @param indexPath The row of the cell,
     */
    @CMSelector("- (void)tableView:(UITableView *)tableView willDisplayCell:(UITableViewCell *)cell forRowAtIndexPath:(NSIndexPath *)indexPath;")
    default void willDisplayCell(UITableView tableview, UITableViewCell cell, NSIndexPath indexPath) {
    }

    /**
     * It is used after a tap on the accessory view of a row.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param indexPath The related row.
     */
    @CMSelector("- (void)tableView:(UITableView *)tableView \n"
            + "accessoryButtonTappedForRowWithIndexPath:(NSIndexPath *)indexPath;")
    default void accessoryButtonTappedForRowWithIndexPath(UITableView tableview, NSIndexPath indexPath) {
    }

    /**
     * It is used after a row is selected.
     *
     * @param tableview A table view that corresponds to this delegate.
     * @param indexPath The selected row.
     */
    @CMSelector("- (void)tableView:(UITableView *)tableView \n"
            + "didSelectRowAtIndexPath:(NSIndexPath *)indexPath;")
    default void didSelectRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
    }

    /**
     * It is used after the deselection of a row.
     *
     * @param tableview A table view that corresponds to this delegate.
     * @param indexPath The deselection of a row.
     */
    @CMSelector("- (void)tableView:(UITableView *)tableView \n"
            + "didDeselectRowAtIndexPath:(NSIndexPath *)indexPath;")
    default void didDeselectRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
    }

    /**
     * It is used before the table view is set on editing mode.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param indexPath The row that is about to be edited.
     */
    @CMSelector("- (void)tableView:(UITableView *)tableView \n"
            + "willBeginEditingRowAtIndexPath:(NSIndexPath *)indexPath;")
    default void willBeginEditingRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
    }

    /**
     * It is used after a table view was set on editing mode.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param indexPath The row that was edited.
     */
    @CMSelector("- (void)tableView:(UITableView *)tableView \n"
            + "didEndEditingRowAtIndexPath:(NSIndexPath *)indexPath;")
    default void didEndEditingRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
    }

    /**
     * It is used while a table view is in editing mode in order to indent the
     * background.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param indexPath The row that is edited.
     * @return TRUE the background of the row should be indented.
     */
    @CMSelector("- (BOOL)tableView:(UITableView *)tableView \n"
            + "shouldIndentWhileEditingRowAtIndexPath:(NSIndexPath *)indexPath;")
    default boolean shouldIndentWhileEditingRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
        return true;
    }

    /**
     * It is used to define the editing style of a row.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param indexPath The row that is edited.
     * @return The editing style of the row.
     */
    @CMSelector("- (UITableViewCellEditingStyle)tableView:(UITableView *)tableView \n"
            + "           editingStyleForRowAtIndexPath:(NSIndexPath *)indexPath;")
    default int editingStyleForRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
        return UITableViewCellEditingStyle.Delete;
    }

    /**
     * It is used in order to specify the height of a row.
     *
     * @param tableView The table view that corresponds to this delegate.
     * @param indexPath The related row.
     * @return The height of the row.
     */
    @CMSelector("- (CGFloat)tableView:(UITableView *)tableView \n"
            + "heightForRowAtIndexPath:(NSIndexPath *)indexPath;")
    default double heightForRowAtIndexPath(UITableView tableView, NSIndexPath indexPath) {
        return Double.NaN;
    }

    /**
     * It is used in order to display a header to a section of the table view.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param section   The section of the tableView.
     * @return The view to be displayed on the header of the section.
     */
    @CMSelector("- (UIView *)tableView:(UITableView *)tableView \n"
            + "viewForHeaderInSection:(NSInteger)section;")
    default UIView viewForHeaderInSection(UITableView tableview, int section) {
        return null;
    }

    /**
     * It is used in order to display a footer to a section of the table view.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param section   The section of the tableView.
     * @return The view to be displayed on the footer of the section.
     */
    @CMSelector("- (UIView *)tableView:(UITableView *)tableView\n"
            + "viewForFooterInSection:(NSInteger)section;")
    default UIView viewForFooterInSection(UITableView tableview, int section) {
        return null;
    }

    /**
     * It is used in order to define the height of the header of a section.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param section   The related section.
     * @return The height of the header.
     */
    @CMSelector("- (CGFloat)tableView:(UITableView *)tableView \n"
            + "heightForHeaderInSection:(NSInteger)section;")
    default double heightForHeaderInSection(UITableView tableview, int section) {
        return Double.NaN;
    }

    /**
     * It is used in order to define the height of the footer of a section.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param section   The related section.
     * @return The height of the footer.
     */
    @CMSelector("- (CGFloat)tableView:(UITableView *)tableView \n"
            + "heightForFooterInSection:(NSInteger)section;")
    default double heightForFooterInSection(UITableView tableview, int section) {
        return Double.NaN;
    }

    /**
     * It is used in order to change the default title of the delete button.
     *
     * @param tableview The table view that corresponds to this delegate.
     * @param indexPath The related row of the table view.
     * @return The title of the delete button.
     */
    @CMSelector("- (NSString *)tableView:(UITableView *)tableView \n"
            + "titleForDeleteConfirmationButtonForRowAtIndexPath:(NSIndexPath *)indexPath;")
    default String titleForDeleteConfirmationButtonForRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
        return null;
    }
}
