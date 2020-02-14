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
package org.crossmobile.build.ib.visual;

import org.crossmobile.build.ib.Values;

public class TableViewCellContentView extends View {
    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("tableViewCell", Values.String);
        addSupportedAttribute("insetsLayoutMarginsFromSafeArea", Values.Boolean);
        addSupportedAttribute("preservesSuperviewLayoutMargins", Values.Boolean);
    }

    @Override
    public String toCode() {
        return toCodeTo(null);
    }

    @Override
    public String toCodeTo(String variable) {
        variable = variable + ".contentView()";
        StringBuilder out = new StringBuilder(super.toCodeTo(variable));
        out.append(super.addSubviews(variable));
        out.append(late(variable(), true).replaceAll(variable(), variable));
        return out.toString();
    }
}
