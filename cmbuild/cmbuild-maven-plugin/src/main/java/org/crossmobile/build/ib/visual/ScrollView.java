/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
