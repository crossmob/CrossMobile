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

import org.crossmobile.build.ib.Value;
import org.crossmobile.build.ib.Values;

public class ScrollView extends View {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("indicatorStyle", new Value.Selections(new String[]{"default", "black", "white"}));
        addSupportedAttribute("showsVerticalScrollIndicator", Values.Boolean);
        addSupportedAttribute("showsHorizontalScrollIndicator", Values.Boolean);
        addSupportedAttribute("scrollEnabled", Values.Boolean);
        addSupportedAttribute("pagingEnabled", Values.Boolean);
        addSupportedAttribute("directionalLockEnabled", Values.Boolean);
        addSupportedAttribute("bounces", Values.Boolean);
        addSupportedAttribute("alwaysBounceHorizontal", Values.Boolean);
        addSupportedAttribute("alwaysBounceVertical", Values.Boolean);
        addSupportedAttribute("bouncesZoom", Values.Boolean);
        addSupportedAttribute("minimumZoomScale", Values.Integer);
        addSupportedAttribute("maximumZoomScale", Values.Integer);
        addSupportedAttribute("delaysContentTouches", Values.Boolean);
        addSupportedAttribute("canCancelContentTouches", Values.Boolean);
        addSupportedAttribute("keyboardDismissMode", new Value.Selections(new String[]{"noDismiss", "onDrag", "interactive"}));

    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());
        appendAttribute(out, "showsVerticalScrollIndicator");
        appendAttribute(out, "showsHorizontalScrollIndicator");
        appendAttribute(out, "scrollEnabled");
        appendAttribute(out, "pagingEnabled");
        appendAttribute(out, "directionalLockEnabled");
        appendAttribute(out, "bounces");
        appendAttribute(out, "alwaysBounceHorizontal");
        appendAttribute(out, "alwaysBounceVertical");
        appendAttribute(out, "delaysContentTouches");
        appendAttribute(out, "canCancelContentTouches");
        return out.toString();
    }

}
