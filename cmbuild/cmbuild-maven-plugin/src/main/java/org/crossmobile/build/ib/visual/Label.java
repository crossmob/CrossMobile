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
import org.crossmobile.build.ib.Values;

public class Label extends View {

    @Override
    protected void addSupported() {
        super.addSupported();

        addSupportedAttribute("highlighted", Values.Boolean);
        addSupportedAttribute("text", Values.LocalizedString);
        addSupportedAttribute("textAlignment", Values.Enum);
        addSupportedAttribute("adjustsFontSizeToFit", Values.Boolean);
        addSupportedAttribute("lineBreakMode", Values.String);
        addSupportedAttribute("minimumScaleFactor", Values.Float);
        addSupportedAttribute("numberOfLines", Values.Integer);
        addSupportedAttribute("preferredMaxLayoutWidth", Values.Float);
        addSupportedAttribute("baselineAdjustment", Values.String);

        addSupportedChild("fontDescription", Elements.FontDescription);
        addSupportedChild("textColor", Elements.Color);
        addSupportedChild("shadowColor", Elements.Color);
        addSupportedChild("shadowOffset", Elements.Size);

        addSupportedAttribute("minimumFontSize", Values.Float);
        addSupportedAttribute("adjustsLetterSpacingToFitWidth", Values.Boolean);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());
        appendAttribute(out, "highlighted");
        appendAttribute(out, "text");
        String textAlignment = attr("textAlignment");
        if (textAlignment != null)
            out.append(I4).append(variable()).append(".setTextAlignment(NSTextAlignment.").append(textAlignment).append(");").append(NEWLINE);
        append(out, "setFont", item("fontDescription").toCode());
        append(out, "setTextColor", item("textColor") == null ? null : item("textColor").toCode());
        append(out, "setShadowColor", item("shadowColor") == null ? null : item("shadowColor").toCode());
        append(out, "setShadowOffset", item("shadowOffset") == null ? null : item("shadowOffset").toCode());
        appendAttribute(out, "setAdjustsFontSizeToFitWidth", "adjustsFontSizeToFit");
//        appendAttribute(out, "lineBreakMode");
        appendAttribute(out, "minimumScaleFactor");
        appendAttribute(out, "numberOfLines");
        appendAttribute(out, "preferredMaxLayoutWidth");
        appendListAttribute(out, "baselineAdjustment");
        return out.toString();
    }

}
