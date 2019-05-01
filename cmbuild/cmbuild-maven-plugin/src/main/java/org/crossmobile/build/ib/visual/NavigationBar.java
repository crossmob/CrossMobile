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

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Value;
import org.crossmobile.build.ib.Values;

public class NavigationBar extends View {

    @Override
    protected void addSupported() {
        super.addSupported();

        addSupportedAttribute("barStyle", new Value.Selections(new String[]{"default", "black", "blackTranslucent"}));
        addSupportedAttribute("translucent", Values.Boolean);
        addSupportedAttribute("inset", null);

        addSupportedChild("barTintColor", Elements.Color);
        addSupportedChild("textColor", Elements.Color);
        addSupportedChild("textShadowColor", Elements.Color);
        addSupportedChild("titleTextAttributes", Elements.TextAttributes);
    }

    public String toCode(String variable) {
        StringBuilder out = new StringBuilder();
        appendTo(out, "navigationBar()", "setTranslucent", attr("translucent", "YES"));
        appendTo(out, "navigationBar()", "setBarStyle", attr("barStyle", "default"));
        return out.toString();
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());

        return out.toString();
    }

}
