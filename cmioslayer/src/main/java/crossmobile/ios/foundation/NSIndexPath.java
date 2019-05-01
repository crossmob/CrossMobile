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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * NSIndexPath class defines an object that represents the path that leads to a
 * node of a tree, for example a path of particular row of a UITableView.
 */
@CMClass
public class NSIndexPath extends NSObject implements NSSecureCoding {

    final int section;
    final int row;


    NSIndexPath(int row, int section) {
        this.row = row;
        this.section = section;
    }

    /**
     * Returns the index path of the specified row in the particular section.
     *
     * @param row     The row for which the path is requested.
     * @param section The section of the row.
     * @return The path of the specified row in the particular section.
     */
    @CMSelector("+ (instancetype)indexPathForRow:(NSInteger)row \n" +
            "                      inSection:(NSInteger)section;")
    public static NSIndexPath indexPathForRow(int row, int section) {
        return new NSIndexPath(row, section);
    }

    /**
     * Returns a number id of a particular section.
     *
     * @return The number id of a particular section.
     */
    @CMGetter("@property(nonatomic, readonly) NSInteger section;")
    public int section() {
        return section;
    }

    /**
     * Returns a number id of a particular row.
     *
     * @return The number id of a particular row
     */
    @CMGetter("@property(nonatomic, readonly) NSInteger row;")
    public int row() {
        return row;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NSIndexPath))
            return false;
        NSIndexPath other = (NSIndexPath) obj;
        return other.row == row && other.section == section;
    }

    @Override
    public int hashCode() {
        return row * 1000 + section;
    }

    @Override
    public String toString() {
        return "NSIndexPath section=" + section + " row=" + row;
    }
}
