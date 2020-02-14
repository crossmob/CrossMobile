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

import javax.swing.border.EtchedBorder;
import java.awt.*;

public class ActiveEtchedBorder extends EtchedBorder implements ThemeChanged {

    {
        ThemeNotifier.register(this);
        themeChanged(Theme.current() == Theme.dark());
    }

    public ActiveEtchedBorder() {
    }

    public ActiveEtchedBorder(int etchType) {
        super(etchType);
    }

    public ActiveEtchedBorder(Color highlight, Color shadow) {
        super(highlight, shadow);
    }

    public ActiveEtchedBorder(int etchType, Color highlight, Color shadow) {
        super(etchType, highlight, shadow);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return new Insets(3, 3, 3, 3);
    }

    @Override
    public void themeChanged(boolean dark) {
        highlight =  Theme.current().iconbottom;
        shadow = dark ? Color.black : Color.lightGray;
    }
}
