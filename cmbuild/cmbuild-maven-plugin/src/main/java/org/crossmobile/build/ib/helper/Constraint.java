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

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Values;


public class Constraint extends Element {

    @Override
    protected void addSupported() {
        addSupportedAttribute("firstItem", Values.String);
        addSupportedAttribute("secondItem", Values.String);
        addSupportedAttribute("firstAttribute", Values.Enum);
        addSupportedAttribute("secondAttribute", Values.Enum);
        addSupportedAttribute("multiplier", Values.String);
        addSupportedAttribute("constant", Values.String);
        addSupportedAttribute("relation", Values.Enum);
        addSupportedAttribute("priority", Values.Float);

        //usuported
        addSupportedAttribute("id", Values.String);
        addSupportedAttribute("symbolic", Values.String);
    }

    public String toCode(String view) {
        StringBuilder out = new StringBuilder();
        String firstItem = attrName("firstItem") == null ? view : variableFromID(attrName("firstItem"));
        String firstAttribute = attr("firstAttribute");
        String relation = attr("relation", "relationEqual");
        String secondItem = attrName("secondItem") == null ? "null" : variableFromID(attrName("secondItem"));
        String secondAttribute = attr("secondAttribute", "notAnAttribute");
        String multiplier = attrName("multiplier") == null ? "1" : attrName("multiplier");
        String constant = attrName("constant") == null ? "0" : attrName("constant");
        String priority = attr("priority");
        if (priority != null)
            out.append("NSLayoutConstraint ").append(variableFromID(attrName("id"))).append(" = ");
        out.append("NSLayoutConstraint.constraintWithItem(")
                .append(firstItem)
                .append(", NSLayoutAttribute.").append(firstAttribute)
                .append(", NSLayoutRelation.").append(relation)
                .append(", ").append(secondItem)
                .append(", NSLayoutAttribute.").append(secondAttribute)
                .append(", ").append(multiplier)
                .append("f, ").append(constant).append("f)");
        if (priority != null) {
            out.append(";").append(NEWLINE);
            out.append(I4).append(variableFromID(attrName("id"))).append(".setPriority(").append(priority).append(");").append(NEWLINE);
            out.append(I4).append(variableFromID(attrName("id")));
        }
        out.append(".setActive(true);");

        return out.toString();
    }

    private String variableFromID(String id) {

        id = id.replaceAll("-", "");
        return "_" + id;
//        return "get_" + id + "()";
    }

    @Override
    public String toCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
