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
import org.crossmobile.build.ib.helper.TextInputTraits;

public class TextField extends Control {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedChild("fontDescription", Elements.FontDescription);
        addSupportedChild("textInputTraits", Elements.TextInputTraits);
        addSupportedAttribute("borderStyle", new Value.Selections(new String[]{"default", "line", "bezel", "roundedRect"}));
        addSupportedAttribute("clearButtonMode", new Value.Selections(new String[]{"default", "whileEditing", "unlessEditing", "always"}));
        addSupportedAttribute("clearsOnBeginEditing", Values.Boolean);
        addSupportedAttribute("minimumFontSize", Values.Integer);
        addSupportedAttribute("adjustsFontSizeToFit", Values.Boolean);
        addSupportedAttribute("autocapitalizationType", new Value.Selections(new String[]{"none", "words", "sentences", "allCharacters"}));
        addSupportedAttribute("autocorrectionType", new Value.Selections(new String[]{"default", "no", "yes"}));
        addSupportedAttribute("keyboardType", new Value.Selections(new String[]{"default", "alphabet", "numbersAndPunctuation", "URL", "numberPad", "phonePad", "namePhonePad", "emailAddress", "decimalPad", "twitter", "webSearch"}));
        addSupportedAttribute("keyboardAppearance", new Value.Selections(new String[]{"default", "alert", "light"}));
        addSupportedAttribute("returnKeyType", new Value.Selections(new String[]{"default", "go", "google", "next", "route", "search", "send", "yahoo", "done", "emergencyCall"}));
        addSupportedAttribute("enablesReturnKeyAutomatically", Values.Boolean);
        addSupportedAttribute("secureTextEntry", Values.Boolean);
        addSupportedAttribute("placeholder", Values.LocalizedString);
        addSupportedAttribute("textAlignment", Values.String);

        addSupportedChild("textColor", Elements.Color);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());
        appendAttribute(out, "placeholder");
        appendAttribute(out, "borderStyle");
        appendTo(out, variable(), "setFont", item("fontDescription").toCode());

        ((TextInputTraits)item("textInputTraits")).toCode(out, variable());

        String textAlignment = attrName("textAlignment");
        if (textAlignment != null)
            out.append(I4).append(variable()).append(".setTextAlignment(NSTextAlignment.").append(capitalize(textAlignment)).append(");").append(NEWLINE);
        return out.toString();
    }

}
