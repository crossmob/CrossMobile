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
import org.crossmobile.build.ib.Values;

public class TextView extends View {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedChild("fontDescription", Elements.FontDescription);
        addSupportedChild("textInputTraits", Elements.TextInputTraits);
        addSupportedChild("textColor", Elements.Color);
        addSupportedAttribute("textAlignment", Values.Enum);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());

        appendTo(out, variable(), "setFont", item("fontDescription").toCode());
        appendValue(out, "textColor");
        appendEnumAttribute(out, "textAlignment", "NSTextAlignment");
        return out.toString();
    }

}
