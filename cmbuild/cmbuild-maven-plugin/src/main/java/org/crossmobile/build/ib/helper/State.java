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

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Values;

public class State extends Element {

    @Override
    protected void addSupported() {
        addSupportedAttribute("key", Values.String);
        addSupportedAttribute("title", Values.LocalizedString);
        addSupportedAttribute("image", Values.String);
        addSupportedAttribute("backgroundImage", Values.String);

        addSupportedChild("titleColor", Elements.Color);
        addSupportedChild("titleShadowColor", Elements.Color);
    }

    @Override
    public String toCode() {
        return "";
    }

    public String toCode(String varname) {
        StringBuilder out = new StringBuilder();
        String state = attrName("key");
        state = "UIControlState." + capitalize(state);
        stateAttr(out, varname, state, "title");
        stateImage(out, varname, state, "image");
        stateImage(out, varname, state, "backgroundImage");
        stateChild(out, varname, state, "titleShadowColor");
        stateChild(out, varname, state, "titleColor");
        return out.toString();
    }

    private void stateAttr(StringBuilder out, String varname, String state, String attr) {
        setState(out, varname, state, attr, attr(attr));
    }

    private void stateImage(StringBuilder out, String varname, String state, String attr) {
        String img = attr(attr);
        if (img != null)
            setState(out, varname, state, attr, "UIImage.imageNamed(" + img + ")");
    }

    private void stateChild(StringBuilder out, String varname, String state, String attr) {
        setState(out, varname, state, attr, value(attr));
    }

    private void setState(StringBuilder out, String varname, String state, String attr, String value) {
        if (value != null)
            out.append(I4).append(varname).append(".set").append(capitalize(attr))
                    .append("(").append(value).append(", ").append(state).append(");").append(NEWLINE);
    }
}
