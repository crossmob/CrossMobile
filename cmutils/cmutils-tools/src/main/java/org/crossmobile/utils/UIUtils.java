/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
