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
 * You should have received attr copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Values;

import java.util.Collection;

public class TableViewSection extends Subviews {

    @Override
    protected void addSupported() {
        addSupportedAttribute("id", Values.String);
        addSupportedAttribute("headerTitle", Values.LocalizedString);
        addSupportedAttribute("footerTitle", Values.LocalizedString);
        addSupportedChild(Elements.Cells);
    }

    public String addSection() {
        Collection<Cells> parts = parts(Elements.Cells);
        String cells;
        if (parts.size() > 1 || parts.isEmpty())
            cells = "null";
        else cells = parts.iterator().next().constructor();
        return attr("headerTitle") + ", " + attr("footerTitle") + ", " + cells;
    }
}
