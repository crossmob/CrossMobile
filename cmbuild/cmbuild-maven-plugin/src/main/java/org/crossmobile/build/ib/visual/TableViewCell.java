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

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Value;
import org.crossmobile.build.ib.Values;
import org.crossmobile.build.ib.helper.Connections;
import org.crossmobile.build.ib.helper.Objects;
import org.crossmobile.build.ib.helper.Segue;

import java.util.Collection;

public class TableViewCell extends View {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("style", new Value.Selections(new String[]{"custom", "IBUITableViewCellStyleDefault", "IBUITableViewCellStyleValue1", "IBUITableViewCellStyleValue2", "IBUITableViewCellStyleSubtitle"}));
        addSupportedAttribute("reuseIdentifier", Values.String);
        addSupportedAttribute("selectionStyle", new Value.Selections(new String[]{"none", "blue", "gray", "default"}));
        addSupportedAttribute("accessoryType", new Value.Selections(new String[]{"none", "disclosureIndicator", "detailDisclosureButton", "checkmark", "detailButton"}));
        addSupportedAttribute("editingAccessoryType", new Value.Selections(new String[]{"none", "disclosureIndicator", "detailDisclosureButton", "checkmark", "detailButton"}));
        addSupportedAttribute("indentationLevel", Values.Integer);
        addSupportedAttribute("indentationWidth", Values.Float);
        addSupportedAttribute("preservesSuperviewLayoutMargins", Values.Boolean);
        addSupportedAttribute("shouldIndentWhileEditing", Values.Boolean);
        addSupportedAttribute("showsReorderControl", Values.Boolean);
        addSupportedAttribute("rowHeight", Values.Float);
        addSupportedAttribute("textLabel", Values.String); // Reference to label in content View, ignore.
        addSupportedChild("contentView", Elements.TableViewCellContentView);
    }

    @Override
    public String variable() {
        return super.variable();
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());
        return out.toString();
    }

    @Override
    public String toCodeTo(String variable) {
        StringBuilder out = new StringBuilder(super.toCodeTo(variable));
        appendAttributeTo(out, variable, "selectionStyle");
        appendAttributeTo(out, variable, "accessoryType");
        appendAttributeTo(out, variable, "editingAccessoryType");
        appendAttributeTo(out, variable, "preservesSuperviewLayoutMargins");
        appendAttributeTo(out, variable, "shouldIndentWhileEditing");
        appendAttributeTo(out, variable, "showsReorderControl");
        if(attr("rowHeight")!=null)
            out.append(I4).append("org.crossmobile.build.StoryBoardBinder.bindRowHeightToTableViewCell(").append(variable).append(", ").append(attr("rowHeight")).append(");").append(NEWLINE);
        TableViewCellContentView cv = (TableViewCellContentView) item("contentView");
        if (cv != null)
            out.append(cv.toCodeTo(variable));
        out.append(printConnections(variable));
        addSegues(out, variable);
        return out.toString();
    }

    @Override
    protected String constructor() {
        return "new " + getClassName() + "(" + attr("style", "custom") + ", " + attr("reuseIdentifier") + ")";
    }

    @Override
    public String prototype() {
        StringBuilder proto = new StringBuilder();
        proto.append(I4).append("super(").append(attr("style", "custom")).append(", ").append(attr("reuseIdentifier")).append(");").append(NEWLINE);

        proto.append(toCodeTo("this"));

        return proto.toString();
    }

    private void addSegues(StringBuilder out, String variable){
        for (Connections connections : parts(Elements.Connections)) {
            for (Segue segue : connections.parts(Elements.Segue)) {
                out.append(I4).append("org.crossmobile.build.StoryBoardBinder.bindSegueWithTableviewCell(")
                        .append(variable).append(", ")
                        .append(segue.trigger()).append(", ")
                        .append(Objects.GETTER).append(segue.variable()).append("());").append(NEWLINE);
            }
        }
    }

    @Override
    public <T extends Element> Collection<T> getInnerParts(T Element) {
        Element cv = item("contentView");
        if (cv != null)
            return cv.parts(Element);
        return super.getInnerParts(Element);
    }

    public String toCode(String id) {
        StringBuilder out = new StringBuilder();
        out.append(I4).append(id).append(".registerClass(").append(variable()).append("_Prototype.class,").append(attr("reuseIdentifier", "")).append(")");
        return out.toString();
    }
}
