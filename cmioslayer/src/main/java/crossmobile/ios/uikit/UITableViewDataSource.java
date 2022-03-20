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
 * UITableViewDataSource class contains all the essential methods for the
 * initialization and modification of a table view such as inserting, deleting
 * and relocating rows.
 */
@CMClass
public interface UITableViewDataSource {

    /**
     * Requests a cell to add in the specified row of the table view.
     *
     * @param table The table view into which the cell is inserted.
     * @param idx   The index of the row.
     * @return The cell that will be inserted into the row.
     */
    @CMSelector("- (UITableViewCell *)tableView:(UITableView *)tableView \n"
            + "         cellForRowAtIndexPath:(NSIndexPath *)indexPath;")
    public UITableViewCell cellForRowAtIndexPath(UITableView table, NSIndexPath idx);

    /**
     * Returns the number of sections of the specified table view.
     *
     * @param table The table view for which the number of sections is returned.
     * @return The number of sections.
     */
    @CMSelector("- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView;")
    default int numberOfSectionsInTableView(UITableView table) {
        return 1;
    }

    /**
     * Returns the number of rows of the specified table view's section.
     *
     * @param table   The table view for whose section the number of rows is
     *                returned.
     * @param section The index of the table view's section.
     * @return The number of rows of the specified section.
     */
    @CMSelector("- (NSInteger)tableView:(UITableView *)tableView \n"
            + " numberOfRowsInSection:(NSInteger)section;")
    public int numberOfRowsInSection(UITableView table, int section);

    /**
     * Requests permission to insert or delete data of the specified table
     * view's row.
     *
     * @param table        The table view within which the editing is done.
     * @param editingStyle The editing(insertion or deletion) of the row.
     * @param indexPath    The index of the row.
     * @see crossmobile.ios.uikit.UITableViewCellEditingStyle
     */
    @CMSelector("- (void)tableView:(UITableView *)tableView \n"
            + "commitEditingStyle:(UITableViewCellEditingStyle)editingStyle \n"
            + "forRowAtIndexPath:(NSIndexPath *)indexPath;")
    default void commitEditingStyle(UITableView table, int editingStyle, NSIndexPath indexPath) {
    }

    /**
     * Checks whether the row of the specified table view is editable.
     *
     * @param table     The table view for which the check is done.
     * @param indexPath The index of the row.
     * @return true TRUE if the row is editable.
     */
    @CMSelector("- (BOOL)tableView:(UITableView *)tableView \n"
            + "canEditRowAtIndexPath:(NSIndexPath *)indexPath;")
    default boolean canEditRowAtIndexPath(UITableView table, NSIndexPath indexPath) {
        return true;
    }

    /**
     * Requests permission to relocate the row of the specified table view.
     *
     * @param table     The table view within which the relocation request is done.
     * @param indexPath The index of the row.
     * @return TRUE if it is permitted.
     */
    @CMSelector("- (BOOL)tableView:(UITableView *)tableView \n"
            + "canMoveRowAtIndexPath:(NSIndexPath *)indexPath;")
    default boolean canMoveRowAtIndexPath(UITableView table, NSIndexPath indexPath) {
        return false;
    }

    /**
     * Relocates the data of the initial row to the final row within the
     * specified table view.
     *
     * @param table         The table view within which the relocation is done.
     * @param fromIndexPath The index of the initial row.
     * @param toIndexPath   The index of the final row.
     */
    @CMSelector("- (void)tableView:(UITableView *)tableView \n"
            + "moveRowAtIndexPath:(NSIndexPath *)sourceIndexPath \n"
            + "      toIndexPath:(NSIndexPath *)destinationIndexPath;")
    default void moveRowAtIndexPath(UITableView table, NSIndexPath fromIndexPath, NSIndexPath toIndexPath) {
    }

    /**
     * Requests the title for the header of the specified table view's section.
     *
     * @param table   The table view for which the title is requested.
     * @param section The section of the table view.
     * @return The section of the title.If NULL then the will be no title.
     */
    @CMSelector("- (NSString *)tableView:(UITableView *)tableView \n"
            + "titleForHeaderInSection:(NSInteger)section;\n"
            + "")
    default String titleForHeaderInSection(UITableView table, int section) {
        return null;
    }

    /**
     * Requests the title for the footer of the specified table view's section.
     *
     * @param table   The table view for which the title is requested.
     * @param section The section of the table view.
     * @return The section of the title.If NULL then the will be no title.
     */
    @CMSelector("- (NSString *)tableView:(UITableView *)tableView \n"
            + "titleForFooterInSection:(NSInteger)section;")
    default String titleForFooterInSection(UITableView table, int section) {
        return null;
    }
}
