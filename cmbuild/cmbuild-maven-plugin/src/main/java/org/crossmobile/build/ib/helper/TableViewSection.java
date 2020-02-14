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
