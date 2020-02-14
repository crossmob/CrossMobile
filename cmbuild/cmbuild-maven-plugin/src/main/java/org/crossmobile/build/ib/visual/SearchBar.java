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

public class SearchBar extends Control {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("text", Values.LocalizedString);
        addSupportedAttribute("prompt", Values.LocalizedString);
        addSupportedAttribute("placeholder", Values.LocalizedString);
        addSupportedChild("textInputTraits", Elements.TextInputTraits);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());
        appendAttribute(out,"text");
        appendAttribute(out,"prompt");
        appendAttribute(out,"placeholder");
        return out.toString();
    }

}
