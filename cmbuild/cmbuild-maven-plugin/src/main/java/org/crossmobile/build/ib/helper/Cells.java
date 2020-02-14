/*
 * (c) 2020 by Panayotis Katsaloulis
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
 * You should have received attr copy of the GNU General Public License
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.visual.TableViewCell;

public class Cells extends Subviews {

    @Override
    protected void addSupported() {
        addSupportedChild(Elements.TableViewCell);
    }

    public String constructor() {
        StringBuilder out = new StringBuilder("new UITableViewCell[] {");
        for (TableViewCell tableViewCell : parts(Elements.TableViewCell))
            out.append(NEWLINE).append(I5).append(Objects.GETTER).append(tableViewCell.variable()).append("(),");
        out.deleteCharAt(out.length() - 1);
        out.append(NEWLINE).append(I4).append("}");
        return out.toString();
    }

}
