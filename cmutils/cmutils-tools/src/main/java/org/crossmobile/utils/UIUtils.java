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

    public static double getScaleBasedOnDPI(int DPI) {
        double scale = DPI / 96d;
        if (scale < 1.1) return 1;
        else if (scale < 1.35) return 1.25;
        else if (scale < 1.6) return 1.5;
        else if (scale < 1.8) return 1.75;
        else if (scale < 2.1) return 2;
        else if (scale < 2.3) return 2.25;
        else if (scale < 2.6) return 2.5;
        else if (scale < 3.1) return 3;
        else if (scale < 3.6) return 3.5;
        else if (scale < 4.2) return 4;
        else return 5;
    }


}
