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
package org.crossmobile.build.ib.visual;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Values;
import org.crossmobile.build.ib.helper.Objects;
import org.crossmobile.build.ib.helper.RealElement;

public class NavigationItem extends RealElement {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("key", Values.String);
        addSupportedAttribute("title", Values.LocalizedString);
        addSupportedChild("rightBarButtonItem", Elements.BarButtonItem);
        addSupportedChild("leftBarButtonItem", Elements.BarButtonItem);
        addSupportedChild("titleView", Elements.View);
    }

    public String toCode() {
        StringBuilder out = new StringBuilder();
        appendAttributeTo(out, "navigationItem()", "title");
        if (item("rightBarButtonItem") != null)
            appendTo(out, "navigationItem()", "setRightBarButtonItem", Objects.GETTER + ((BarButtonItem) item("rightBarButtonItem")).variable() + "()");
        if (item("leftBarButtonItem") != null)
            appendTo(out, "navigationItem()", "setLeftBarButtonItem", Objects.GETTER + ((BarButtonItem) item("leftBarButtonItem")).variable() + "()");
        if (item("titleView") != null)
            appendTo(out, "navigationItem()", "setTitleView", Objects.GETTER + ((View) item("titleView")).variable() + "()");
        return out.toString();
    }
}
