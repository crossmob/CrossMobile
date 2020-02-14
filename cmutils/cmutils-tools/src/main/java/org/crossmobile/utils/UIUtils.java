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
package org.crossmobile.utils;

import java.awt.*;
import java.util.Collection;

public class UIUtils {

    public static void syncWidth(Collection<? extends Component> components) {
        int width = 0;
        for (Component comp : components) {
            comp.setPreferredSize(null);
            width = Math.max(width, comp.getPreferredSize().width);
        }
        for (Component comp : components) {
            Dimension d = comp.getPreferredSize();
            d.width = width;
            comp.setMinimumSize(d);
            comp.setMaximumSize(d);
            comp.setPreferredSize(d);
            comp.setSize(d);
        }
    }

}
