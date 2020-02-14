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

import org.crossmobile.build.ib.Values;

public class Segue extends RealElement {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("destination", Values.String);
        addSupportedAttribute("kind", Values.String);
        addSupportedAttribute("relationship", Values.String);
        addSupportedAttribute("id", Values.String);
        addSupportedAttribute("trigger", Values.String);
        addSupportedAttribute("identifier", Values.String);
    }

    @Override
    protected String constructor() {
        StringBuilder out = new StringBuilder();
        out.append("new ").append(getClassName()).append("(").append(attr("identifier")).append(", ").append(Objects.GETTER).append(Objects.SCENE_VC)
                .append("(), ").append("new ").append(variableFromID(attrName("destination"))).append("())");
        if (!attr("kind").equals("custom")) {
            out.append(" {").append(NEWLINE);
            out.append(I5).append("@Override").append(NEWLINE);
            out.append(I5).append("public void perform() {").append(NEWLINE);
            out.append(I6).append(Objects.GETTER).append(Objects.SCENE_VC).append("().showViewController(destinationViewController(), true);").append(NEWLINE);
            out.append(I5).append("}").append(NEWLINE);
            out.append(I4).append("}");
        }
        return out.toString();
    }

    public String getKind() {
        return attrName("kind");
    }

    public String getRelation() {
        return attrName("relationship");
    }

    public String getDestination() {
        return attrName("destination");
    }

    public String identifier() {
        return attr("identifier", "null");
    }

    public String trigger() {
        return attr("trigger", "action");
    }

    StringBuilder getTarget(String variable) {
        StringBuilder out = new StringBuilder();
        out.append(I4).append(variable).append(".addTarget((UIControl uiControl, UIEvent uiEvent) ->{").append(NEWLINE);
        out.append(getSegway(variable));
        out.append(I4).append("}, UIControlEvents.TouchUpInside);").append(NEWLINE);
        return out;
    }

    public String getSegway(String variable) {
        StringBuilder out = new StringBuilder();
        out.append(I5).append("if(").append(Objects.GETTER).append(Objects.SCENE_VC).append("().shouldPerformSegueWithIdentifier(")
                .append(attr("identifier")).append(", ").append(variable).append(")) {").append(NEWLINE);
        out.append(I6).append(Objects.GETTER).append(Objects.SCENE_VC).append("().prepareForSegue(").append(Objects.GETTER)
                .append(variable()).append("(), ").append(variable).append(");").append(NEWLINE);
        out.append(I6).append(variable()).append(".perform();").append(NEWLINE);
        out.append(I5).append("}").append(NEWLINE);
        return out.toString();
    }

    @Override
    public String variable() {
        return super.variable();
    }

    @Override
    protected String getDefaultClassName() {
        return "UIStoryboardSegue";
    }
}
