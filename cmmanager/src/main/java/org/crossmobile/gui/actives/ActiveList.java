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
import java.util.Vector;

public class ActiveList extends JList implements ThemeChanged {
    {
        ThemeNotifier.register(this);
        themeChanged(Theme.current() == Theme.dark());
    }

    public ActiveList(ListModel dataModel) {
        super(dataModel);
    }

    public ActiveList(Object[] listData) {
        super(listData);
    }

    public ActiveList(Vector listData) {
        super(listData);
    }

    public ActiveList() {
    }

    @Override
    public void setEnabled(boolean enabled) {
        themeChanged(Theme.current() == Theme.dark());
    }

    @Override
    public void themeChanged(boolean dark) {
        setBackground(isEnabled() ? Theme.current().backCell : Theme.current().disabled);
    }
}
