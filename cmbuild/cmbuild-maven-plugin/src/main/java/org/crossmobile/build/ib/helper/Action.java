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

import org.crossmobile.build.ib.Values;

public class Action extends RealElement {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("selector", Values.String);
        addSupportedAttribute("destination", Values.String);
        addSupportedAttribute("eventType", Values.Enum);
    }

    @Override
    public String toCode() {
        return "";
    }

    public String addTarget(String variable) {
        String eventType = attr("eventType");
        String action = getAction("sender");

        if (eventType == null || eventType.isEmpty() || action.isEmpty())
            return "";

        return I4 + variable + ".addTarget((sender, event) -> "
                + action
                + ", " + "UIControlEvents." + eventType + ");" + NEWLINE;
    }

    public String getAction(String sender) {
        String destination = attrName("destination");
        String selector = attrName("selector");

        if (selector == null || selector.isEmpty() || destination == null || destination.isEmpty())
            return "";

        destination = variableFromID(destination);
        if (selector.endsWith(":"))
            selector = selector.substring(0, selector.length() - 1);

        return Objects.GETTER + destination + "()." + selector + "(" + sender + ")";
    }

}
