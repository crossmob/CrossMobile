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
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Values;

public class TextInputTraits extends RealElement {

    @Override
    protected void addSupported() {
        addSupportedAttribute("key", Values.String);
        addSupportedAttribute("textContentType", Values.String);
        addSupportedAttribute("keyboardType", Values.Enum);
        addSupportedAttribute("autocapitalizationType", Values.Enum);
        addSupportedAttribute("secureTextEntry", Values.Boolean);
        addSupportedAttribute("autocorrectionType", Values.Enum);
        addSupportedAttribute("spellCheckingType", Values.Enum);
    }

    @Override
    public String toCode() {
        return "";
    }

    public void toCode(StringBuilder out, String variable) {
        appendAttributeTo(out, variable, "textContentType");
        appendAttributeTo(out, variable, "secureTextEntry");
        appendEnumAttributeTo(out, variable, "autocorrectionType" , "UITextAutocorrectionType");
        appendEnumAttributeTo(out, variable, "spellCheckingType", "UITextSpellCheckingType");
        appendEnumAttributeTo(out, variable, "keyboardType", "UIKeyboardType");
        appendEnumAttributeTo(out, variable, "autocapitalizationType", "UITextAutocapitalizationType");
    }
}
