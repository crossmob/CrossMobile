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

import org.crossmobile.build.ib.Value;

public class ProgressView extends View {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("progressViewStyle", new Value.Selections(new String[]{"default", "bar"}));
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());

        appendAttribute(out, "progressViewStyle");
        return out.toString();
    }

    @Override
    protected String constructor() {
        return "new UIProgressView(" + attr("progressViewStyle", "0") + ")";
    }

}
