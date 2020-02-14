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

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Value;
import org.crossmobile.build.ib.Values;
import org.crossmobile.build.ib.helper.*;

import java.util.ArrayList;
import java.util.Collection;

public class View extends RealElement {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("hidden", Values.Boolean);
        addSupportedAttribute("autoresizesSubviews", Values.Boolean);
        addSupportedAttribute("opaque", Values.Boolean);
        addSupportedAttribute("clipsSubviews", Values.Boolean);
        addSupportedAttribute("clearsContextBeforeDrawing", Values.Boolean);
        addSupportedAttribute("multipleTouchEnabled", Values.Boolean);
        addSupportedAttribute("userInteractionEnabled", Values.Boolean);
        addSupportedAttribute("alpha", Values.Float);
        addSupportedAttribute("tag", Values.Integer);
        addSupportedAttribute("contentMode", new Value.Selections(new String[]{"scaleToFill", "scaleAspectFit", "scaleAspectFill", "redraw", "center", "top", "bottom", "left", "right", "topLeft", "topRight", "bottomLeft", "bottomRight"}));
        addSupportedAttribute("insetsLayoutMarginsFromSafeArea", Values.Boolean);
        addSupportedAttribute("restorationIdentifier", Values.String);
        addSupportedChild("frame", Elements.Rect);
        addSupportedChild("backgroundColor", Elements.Color);
        addSupportedChild("tintColor", Elements.Color);
        addSupportedChild("autoresizingMask", Elements.AutoresizingMask);

        addSupportedChild(Elements.Subviews);
        addSupportedChild(Elements.Connections);
        addSupportedChild(Elements.Constraints);
        // Silent data
        addSupportedAttribute("fixedFrame", Values.Boolean);
        addSupportedAttribute("translatesAutoresizingMaskIntoConstraints", Values.Boolean);
        addSupportedAttribute("verticalHuggingPriority", Values.Float);
        addSupportedAttribute("horizontalHuggingPriority", Values.Float);
        addSupportedAttribute("horizontalCompressionResistancePriority", Values.Float);
        addSupportedAttribute("verticalCompressionResistancePriority", Values.Float);
        addSupportedChild("contentStretch", Elements.Rect); // deprecated
        addSupportedAttribute("key", Values.String);
        addSupportedChild("safeArea", Elements.ViewLayoutGuide);
    }

    @Override
    public String toCode() {
        return toCode(false);
    }

    public String toCode(boolean withoutSubviews) {
        StringBuilder out = new StringBuilder(super.toCode());
        out.append(toCodeTo(variable()));
        if (!withoutSubviews)
            out.append(addSubviews(variable()));
        return out.toString();
    }

    public String addSubviews(String variable) {
        StringBuilder out = new StringBuilder();
        for (Subviews e : parts(Elements.Subviews))
            for (View s : e.parts(Elements.View)) {
                out.append(I4).append(variable).append(".addSubview(").append(Objects.GETTER).append(s.variable()).append("());").append(NEWLINE);
                out.append(I4).append(Objects.LATE_INITTER).append(s.variable()).append("();").append(NEWLINE);
            }
        return out.toString();
    }

    public String toCodeTo(String variable) {
        StringBuilder out = new StringBuilder();
        appendAttributeTo(out, variable, "hidden");
        appendAttributeTo(out, variable, "autoresizesSubviews");
        appendAttributeTo(out, variable, "opaque");
        appendAttributeTo(out, variable, "setClipsToBounds", "clipsSubviews");
        appendAttributeTo(out, variable, "clearsContextBeforeDrawing");
        appendAttributeTo(out, variable, "multipleTouchEnabled");
        appendAttributeTo(out, variable, "userInteractionEnabled");
        appendAttributeTo(out, variable, "alpha");
        appendAttributeTo(out, variable, "tag");
        appendAttributeTo(out, variable, "contentMode");
        appendAttributeTo(out, variable, "restorationIdentifier");
        appendAttributeTo(out, variable, "translatesAutoresizingMaskIntoConstraints");
        appendValueTo(out, variable, "frame");
        appendValueTo(out, variable, "backgroundColor");
        appendValueTo(out, variable, "tintColor");

        String ar = value("autoresizingMask");
        if (ar != null && !ar.equals("0"))
            appendTo(out, variable, "setAutoresizingMask", ar);

        return out.toString();
    }

    public String late() {
        return late(variable(), false);
    }

    public String late(String variable, boolean shouldUpdateSelfConstraints) {
        StringBuilder late = new StringBuilder();
        LayoutGuide safeArea;
        if ((safeArea = (LayoutGuide) item("safeArea")) != null)
            late.append(safeArea.toCode(variable));
        boolean hasConstraints = false;
        for (Constraints c : parts(Elements.Constraints))
            for (Constraint o : c.parts(Elements.Constraint)) {
                late.append(I4).append(o.toCode(variable)).append(NEWLINE);
                hasConstraints = true;
            }
        // TODO: the following method should be obsolete, if a proper layout/constraint manager is preset
        if (shouldUpdateSelfConstraints && hasConstraints)
            late.append(I4).append("this.layoutSubviews();").append(NEWLINE);

        if (attrName("verticalHuggingPriority") != null)
            late.append(I4).append(variable).append(".setContentHuggingPriority(").append(attrName("verticalHuggingPriority")).append("f, ").append("UILayoutConstraintAxis.Vertical);").append(NEWLINE);
        if (attrName("horizontalHuggingPriority") != null)
            late.append(I4).append(variable).append(".setContentHuggingPriority(").append(attrName("horizontalHuggingPriority")).append("f, ").append("UILayoutConstraintAxis.Horizontal);").append(NEWLINE);
        if (attrName("horizontalCompressionResistancePriority") != null)
            late.append(I4).append(variable).append(".setContentCompressionResistancePriority(").append(attrName("horizontalCompressionResistancePriority")).append("f, ").append("UILayoutConstraintAxis.Vertical);").append(NEWLINE);
        if (attrName("verticalCompressionResistancePriority") != null)
            late.append(I4).append(variable).append(".setContentCompressionResistancePriority(").append(attrName("verticalCompressionResistancePriority")).append("f, ").append("UILayoutConstraintAxis.Horizontal);").append(NEWLINE);
        return late.toString();
    }

    public String prototype() {
        return "";
    }

    public <T extends Element> Collection<T> getInnerParts(T Element) {
        return new ArrayList<>();
    }

    public String segueMap(String viewcontroller) {
        StringBuilder out = new StringBuilder();
        for (Connections connections : parts(Elements.Connections))
            for (Segue segue : connections.parts(Elements.Segue))
                out.append(I4).append("org.crossmobile.build.StoryBoardBinder.bindSegueWithViewController(")
                        .append(viewcontroller).append(".this, ")
                        .append(segue.identifier()).append(", ")
                        .append(Objects.GETTER).append(segue.variable()).append("());").append(NEWLINE);
        for (Subviews subviews : parts(Elements.Subviews))
            for (View view : subviews.parts(Elements.View))
                out.append(view.segueMap(viewcontroller));
        return out.toString();
    }
}
