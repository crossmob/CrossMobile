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
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Values;

public class Segment extends RealElement {

    @Override
    protected void addSupported() {
        addSupportedAttribute("title", Values.LocalizedString);
        addSupportedAttribute("image", Values.String);
    }

    @Override
    public String toCode() {
        if (attr("image") != null)
            return "UIImage.imageNamed(" + attr("image") + ")";
        if (attr("title") != null)
            return attr("title");
        return "";
    }
}
