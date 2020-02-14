/*
 * (c) 2019 by Panayotis Katsaloulis
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
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.lang.reflect.Field;

public class ActiveMenu extends JMenu {

    static final int DELTA = System.getProperty("os.name").toLowerCase().contains("mac") ? 0 : 10;

    {
        setBorder(new CompoundBorder(getBorder(), BorderFactory.createEmptyBorder(6, DELTA, 6, DELTA)));

        JPopupMenu popupMenu = new ActivePopupMenu();
        popupMenu.setInvoker(this);
        popupListener = createWinListener(popupMenu);
        try {
            Field popupMenuF = JMenu.class.getDeclaredField("popupMenu");
            if (popupMenuF != null) {
                popupMenuF.setAccessible(true);
                popupMenuF.set(this, popupMenu);
            }
        } catch (NoSuchFieldException | IllegalAccessException ignored) {
            System.out.println(ignored);
        }
    }

    @Override
    public Color getForeground() {
        return isEnabled() ? Theme.current().text : Theme.current().disabled;
    }

    @Override
    public Color getBackground() {
        return Theme.current().areaPrimary;
    }
}
