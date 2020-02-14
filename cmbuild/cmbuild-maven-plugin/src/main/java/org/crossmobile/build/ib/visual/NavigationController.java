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
package org.crossmobile.build.ib.visual;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.helper.Connections;
import org.crossmobile.build.ib.helper.Segue;

public class NavigationController extends ViewController {

    private String destination = "";

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedChild(Elements.Connections);
        addSupportedChild("navigationBar", Elements.NavigationBar);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder(super.toCode());
        NavigationBar navigationBar;
        if ((navigationBar = (NavigationBar) item("navigationBar")) != null)
            out.append(navigationBar.toCode(variable()));
        return out.toString();
    }

    @Override
    protected String toCodeSuper() {
        for (Connections c : parts(Elements.Connections))
            for (Segue s : c.parts(Elements.Segue))
                destination = (s.getKind().equals("relationship") && s.getRelation().equals("rootViewController")) ? s.getDestination() : destination;
        return destination.isEmpty() ? "" : "super(new " + variableFromID(destination) + "());" + NEWLINE;
    }
}
