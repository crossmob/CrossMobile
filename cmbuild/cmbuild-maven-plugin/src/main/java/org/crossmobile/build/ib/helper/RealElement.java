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

public abstract class RealElement extends Element {

    private String varname;

    protected static String variableFromID(String id) {
        if (id.equals("-1"))
            id = Objects.FILEOWNER;
        else
            id = id.replaceAll("-", "");
        return Objects.VARPREFIX + id;
    }

    @Override
    protected void addSupported() {
        addSupportedAttribute("id", Values.String);
        addSupportedAttribute("customClass", Values.String);
        // userLabel and misplaced are attributes used by the interface builder
        // to enhance user experience
        addSupportedAttribute("userLabel", Values.String);
        addSupportedAttribute("misplaced", Values.String);
        addSupportedChild(Elements.Connections);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        out.append(I4).append(variable()).append(" = ").append(constructor()).append(";" + NEWLINE);
        out.append(printConnections());
        return out.toString();
    }

    public String printConnections() {
        return printConnections(variable());
    }

    public String printConnections(String variable) {
        StringBuilder out = new StringBuilder();
        for (Connections c : parts(Elements.Connections))
            out.append(c.getOutlets(variable, getClassName()));
        return out.toString();
    }

    public String variable() {
        if (varname == null)
            varname = variableFromID(attrName("id"));
        return varname;
    }

    public String getClassName() {
        String cname = attrName("customClass");
        return cname == null ? getDefaultClassName() : cname.replace('_', '.');
    }

    protected String getDefaultClassName() {
        String name = Elements.getName(this);
        return name.equals("Placeholder") ? "Object" : "UI" + name;
    }

    protected String constructor() {
        return "new " + getClassName() + "()";
    }

    protected String publicConstructor() {
        return "public " + variable() + "()";
    }

    protected void appendValue(StringBuilder out, String value) {
        append(out, "set" + capitalize(value), value(value));
    }

    protected void appendValue(StringBuilder out, String methodname, String value) {
        append(out, methodname, value(value));
    }

    protected void appendEnumAttribute(StringBuilder out, String attribute, String enumClass) {
        append(out, "set" + capitalize(attribute), attr(attribute) == null ? null :enumClass + "." + attr(attribute));
    }

    protected void appendEnumAttributeTo(StringBuilder out, String to, String attribute, String enumClass) {
        appendTo(out, to, "set" + capitalize(attribute),  attr(attribute) == null ? null :enumClass + "." + attr(attribute));
    }

    protected void appendAttribute(StringBuilder out, String attribute) {
        append(out, "set" + capitalize(attribute), attr(attribute));
    }

    protected void appendAttributeCall(StringBuilder out, String attribute) {
        appendCall(out, "set" + capitalize(attribute), attr(attribute));
    }

    protected void appendAttribute(StringBuilder out, String methodname, String attribute) {
        append(out, methodname, attr(attribute));
    }

    protected void appendListAttribute(StringBuilder out, String attribute) {
        appendListAttribute(out, "UI" + capitalize(attribute), attribute);
    }

    protected void appendListAttribute(StringBuilder out, String baseClass, String attribute) {
        append(out, "set" + capitalize(attribute), baseClass + "." + capitalize(attrName(attribute)));
    }

    protected void appendValueTo(StringBuilder out, String to, String value) {
        appendTo(out, to, "set" + capitalize(value), value(value));
    }

    protected void appendValueTo(StringBuilder out, String to, String methodname, String value) {
        appendTo(out, to, methodname, value(value));
    }

    protected void appendAttributeTo(StringBuilder out, String to, String attribute) {
        appendTo(out, to, "set" + capitalize(attribute), attr(attribute));
    }

    protected void appendAttributeTo(StringBuilder out, String to, String methodname, String attribute) {
        appendTo(out, to, methodname, attr(attribute));
    }

    protected void appendListAttributeTo(StringBuilder out, String to, String attribute) {
        appendListAttributeTo(out, to, "UI" + capitalize(attribute), attribute);
    }

    protected void appendListAttributeTo(StringBuilder out, String to, String baseClass, String attribute) {
        appendTo(out, to, "set" + capitalize(attribute), baseClass + "." + capitalize(attrName(attribute)));
    }

    protected void append(StringBuilder out, String methodname, String data) {
        appendTo(out, variable(), methodname, data);
    }

    protected void appendCall(StringBuilder out, String methodname, String data) {
        if (data != null && !"".equals(data))
            out.append(I4).append(methodname).append("(").append(data).append(");").append(NEWLINE);
    }

    protected void appendTo(StringBuilder out, String to, String methodname, String data) {
        if (data != null && !"".equals(data))
            out.append(I4).append(to).append(".").append(methodname).append("(").append(data).append(");").append(NEWLINE);
    }
}
