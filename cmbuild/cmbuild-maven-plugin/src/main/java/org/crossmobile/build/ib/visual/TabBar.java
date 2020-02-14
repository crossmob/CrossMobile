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

public class TabBar extends View {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedChild(Elements.Items);
        addSupportedAttribute("barStyle", new Value.Selections(new String[]{"default", "black"}));
        addSupportedAttribute("translucent", Values.Boolean);
        addSupportedAttribute("barTintColor", Values.Integer);
        addSupportedAttribute("itemPositioning", new Value.Selections(new String[]{"automatic", "fill", "centered"}));
        addSupportedAttribute("itemWidth", Values.Integer);
        addSupportedAttribute("itemSpacing", Values.Integer);

        addSupportedChild("selectedImageTintColor", Elements.Color);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());

        return out.toString();
    }

}
