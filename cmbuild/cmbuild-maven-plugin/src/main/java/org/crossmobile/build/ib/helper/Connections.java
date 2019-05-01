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
import org.crossmobile.build.ib.Elements;

public class Connections extends Element {

    @Override
    protected void addSupported() {
        addSupportedChild(Elements.Outlet);
        addSupportedChild(Elements.Action);
        addSupportedChild(Elements.Segue);
    }

    @Override
    public String toCode() {
        return "";
    }

    public String getOutlets(String variableName, String variableType) {
        StringBuilder out = new StringBuilder();
        for (Outlet o : parts(Elements.Outlet))
            out.append(o.getOutlet(variableName, variableType));
        return out.toString();
    }

    public String getActions(String variable) {
        StringBuilder out = new StringBuilder();
        for (Action o : parts(Elements.Action))
            out.append(o.addTarget(variable));
        return out.toString();
    }

    public String getSegues(String variable) {
        StringBuilder out = new StringBuilder();
        for (Segue o : parts(Elements.Segue))
            out.append(o.getTarget(variable));
        return out.toString();
    }

}
