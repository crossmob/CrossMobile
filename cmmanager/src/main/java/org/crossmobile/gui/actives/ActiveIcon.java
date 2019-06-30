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

import com.panayotis.hrgui.HiResIcon;
import org.crossmobile.gui.elements.Theme;

import java.awt.*;

public class ActiveIcon extends HiResIcon implements ThemeChanged {

    private final Image bright;
    private final Image dark;

    {
        ThemeNotifier.register(this);
    }

    public ActiveIcon(String resourceName) {
        super(resourceName, Theme.bright().icontop, Theme.bright().iconbottom);
        this.bright = getImage();
        this.dark = new HiResIcon(resourceName, Theme.dark().icontop, Theme.dark().iconbottom).getImage();
        themeChanged(Theme.current() == Theme.dark());
    }

    @Override
    public void themeChanged(boolean dark) {
        setImage(dark ? this.dark : this.bright);
    }
}
