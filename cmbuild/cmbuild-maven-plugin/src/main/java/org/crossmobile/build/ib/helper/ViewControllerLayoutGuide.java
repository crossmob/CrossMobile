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

import org.crossmobile.build.ib.Values;

public class ViewControllerLayoutGuide extends RealElement {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("type", Values.String);
    }

    @Override
    public String getClassName() {
        return "UILayoutSupport";
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder().append(I4).append(variable()).append(" = ")
                .append(attrName("type")).append("LayoutGuide();").append(NEWLINE);
        return out.toString();
    }
}
