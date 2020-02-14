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

public class ImageView extends View {

    @Override
    protected void addSupported() {
        super.addSupported();

        addSupportedAttribute("image", Values.String);
        addSupportedAttribute("highlightedImage", Values.String);
        addSupportedAttribute("highlighted", Values.Boolean);
        addSupportedAttribute("placeholderIntrinsicHeight", Values.Float);
        addSupportedAttribute("placeholderIntrinsicWidth", Values.Float);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());
        addImage(out, "image", "setImage");
        addImage(out, "highlightedImage", "setHighlightedImage");
        appendAttribute(out, "highlighted");
        return out.toString();
    }

    private void addImage(StringBuilder out, String attr, String methodName) {
        String img = attr(attr);
        if (img != null)
            append(out, methodName, "UIImage.imageNamed(" + img + ")");
    }

}
