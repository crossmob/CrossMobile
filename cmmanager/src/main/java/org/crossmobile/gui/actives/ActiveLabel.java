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

import com.panayotis.hrgui.HiResIcon;
import com.panayotis.hrgui.HiResLabel;
import org.crossmobile.gui.elements.Theme;

import java.awt.*;

public class ActiveLabel extends HiResLabel {

    {
        setOpaque(false);
    }

    public ActiveLabel(String text, HiResIcon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public ActiveLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public ActiveLabel(String text) {
        super(text);
    }

    public ActiveLabel(HiResIcon icon, int horizontalAlignment) {
        super(icon, horizontalAlignment);
    }

    public ActiveLabel(HiResIcon icon) {
        super(icon);
    }

    public ActiveLabel() {
    }

    @Override
    public Color getForeground() {
        return Theme.current().text;
    }
}
