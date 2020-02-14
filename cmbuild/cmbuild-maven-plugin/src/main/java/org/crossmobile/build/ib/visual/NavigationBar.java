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
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build.ib.visual;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Value;
import org.crossmobile.build.ib.Values;

public class NavigationBar extends View {

    @Override
    protected void addSupported() {
        super.addSupported();

        addSupportedAttribute("barStyle", new Value.Selections(new String[]{"default", "black", "blackTranslucent"}));
        addSupportedAttribute("translucent", Values.Boolean);
        addSupportedAttribute("inset", null);

        addSupportedChild("barTintColor", Elements.Color);
        addSupportedChild("textColor", Elements.Color);
        addSupportedChild("textShadowColor", Elements.Color);
        addSupportedChild("titleTextAttributes", Elements.TextAttributes);
    }

    public String toCode(String variable) {
        StringBuilder out = new StringBuilder();
        appendTo(out, "navigationBar()", "setTranslucent", attr("translucent", "YES"));
        appendTo(out, "navigationBar()", "setBarStyle", attr("barStyle", "default"));
        return out.toString();
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());

        return out.toString();
    }

}
