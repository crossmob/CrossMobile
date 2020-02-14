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

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Value;
import org.crossmobile.build.ib.Values;
import org.crossmobile.build.ib.helper.Connections;

public class Control extends View {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("contentHorizontalAlignment", new Value.Selections(new String[]{"center", "left", "right", "fill"}));
        addSupportedAttribute("contentVerticalAlignment", new Value.Selections(new String[]{"center", "top", "bottom", "fill"}));
        addSupportedAttribute("enabled", Values.Boolean);
        addSupportedAttribute("highlighted", Values.Boolean);
        addSupportedAttribute("selected", Values.Boolean);
    }

    @Override
    public String toCode() {
        String variable = variable();
        StringBuilder out = new StringBuilder(super.toCode());
        appendAttribute(out, "enabled");
        appendAttribute(out, "highlighted");
        appendAttribute(out, "selected");
        appendAttribute(out, "contentHorizontalAlignment");
        appendAttribute(out, "contentVerticalAlignment");
        for (Connections c : parts(Elements.Connections)) {
            out.append(c.getActions(variable));
            out.append(c.getSegues(variable));
        }

        return out.toString();
    }

}
