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
package org.crossmobile.gui.actives;

import org.crossmobile.gui.elements.Theme;

import javax.swing.*;
import java.awt.*;

public class ActiveMenuSeparator extends JPopupMenu.Separator {

    private static boolean shouldDraw = System.getProperty("os.name").toLowerCase().contains("mac");

    {
        setPreferredSize(new Dimension(10, 2));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (shouldDraw) {
            g.setColor(Theme.current().iconbottom);
            g.drawLine(0, 1, getWidth(), 1);
        }
    }

}
