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
import org.crossmobile.build.ib.helper.Objects;
import org.crossmobile.build.ib.helper.Subviews;


public class StackView extends View {

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode(true));
        out.append(I4).append(variable()).append(".setDistribution(").append("UIStackViewDistribution.").append(attr("distribution", "fill")).append(");").append(NEWLINE);
        out.append(I4).append(variable()).append(".setAxis(").append("UILayoutConstraintAxis.").append(attr("axis", "horizontal")).append(");").append(NEWLINE);
        out.append(I4).append(variable()).append(".setAlignment(").append("UIStackViewAlignment.").append(attr("alignment", "fill")).append(");").append(NEWLINE);
        appendAttribute(out, "spacing");
        appendAttribute(out, "baselineRelativeArrangement");
        appendAttribute(out, "layoutMarginsRelativeArrangement");

        for (Subviews e : parts(Elements.Subviews))
            for (View s : e.parts(Elements.View))
                out.append(I4).append(variable()).append(".addArrangedSubview(").append(Objects.GETTER).append(s.variable()).append("());").append(NEWLINE);

        return out.toString();
    }

    @Override
    protected String constructor() {
        return "new " + getClassName() + "(new ArrayList<>())";
    }

    @Override
    protected void addSupported() {
        super.addSupported();

        addSupportedAttribute("spacing", Values.Integer);
        addSupportedAttribute("axis", Values.Enum);
        addSupportedAttribute("distribution", Values.Enum);
        addSupportedAttribute("alignment", Values.Enum);
        addSupportedAttribute("baselineRelativeArrangement", Values.Boolean);
        addSupportedAttribute("layoutMarginsRelativeArrangement", Values.Boolean);

    }

}
