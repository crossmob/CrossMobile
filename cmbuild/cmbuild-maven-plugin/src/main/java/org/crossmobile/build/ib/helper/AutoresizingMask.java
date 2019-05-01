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
 * You should have received attr copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Values;

public class AutoresizingMask extends Element {

    @Override
    protected void addSupported() {
        addSupportedAttribute("key", Values.String);
        addSupportedAttribute("flexibleMinX", Values.Boolean);
        addSupportedAttribute("widthSizable", Values.Boolean);
        addSupportedAttribute("flexibleMaxX", Values.Boolean);
        addSupportedAttribute("flexibleMinY", Values.Boolean);
        addSupportedAttribute("heightSizable", Values.Boolean);
        addSupportedAttribute("flexibleMaxY", Values.Boolean);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        if (attr("flexibleMinX", "NO").equals("true"))
            out.append(" | ").append("UIViewAutoresizing.FlexibleLeftMargin");
        if (attr("widthSizable", "NO").equals("true"))
            out.append(" | ").append("UIViewAutoresizing.FlexibleWidth");
        if (attr("flexibleMaxX", "NO").equals("true"))
            out.append(" | ").append("UIViewAutoresizing.FlexibleRightMargin");
        if (attr("flexibleMinY", "NO").equals("true"))
            out.append(" | ").append("UIViewAutoresizing.FlexibleTopMargin");
        if (attr("heightSizable", "NO").equals("true"))
            out.append(" | ").append("UIViewAutoresizing.FlexibleHeight");
        if (attr("flexibleMaxY", "NO").equals("true"))
            out.append(" | ").append("UIViewAutoresizing.FlexibleBottomMargin");
        String res = out.toString();
        return res.isEmpty() ? res : res.substring(3);
    }
}
