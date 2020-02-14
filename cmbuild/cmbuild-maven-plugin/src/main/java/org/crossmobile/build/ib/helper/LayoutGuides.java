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
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Elements;

import java.util.Collection;

public class LayoutGuides extends Element {
    @Override
    protected void addSupported() {
        addSupportedChild(Elements.ViewControllerLayoutGuide);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        Collection<ViewControllerLayoutGuide> viewControllerLayoutGuides;
        if (!(viewControllerLayoutGuides = parts(Elements.ViewControllerLayoutGuide)).isEmpty())
            for (ViewControllerLayoutGuide viewControllerLayoutGuide : viewControllerLayoutGuides)
                out.append(viewControllerLayoutGuide.toCode());
        return out.toString();
    }
}
