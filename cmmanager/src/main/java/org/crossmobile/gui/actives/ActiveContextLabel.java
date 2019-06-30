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

public class ActiveContextLabel extends ActiveLabel implements ThemeChanged {

    public enum Context {
        RUNNING {
            @Override
            Color getColor() {
                return Theme.current().backgroundRunning;
            }
        }, SUCCESS {
            @Override
            Color getColor() {
                return Theme.current().backgroundSuccess;
            }
        }, WARNING {
            @Override
            Color getColor() {
                return Theme.current().backgroundWarning;
            }
        }, ERROR {
            @Override
            Color getColor() {
                return Theme.current().backgroundError;
            }
        };

        abstract Color getColor();
    }

    private Context ctx = Context.RUNNING;

    {
        ThemeNotifier.register(this);
        themeChanged(Theme.current() == Theme.dark());
    }

    public ActiveContextLabel(String text, HiResIcon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public ActiveContextLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public ActiveContextLabel(String text) {
        super(text);
    }

    public ActiveContextLabel(HiResIcon icon, int horizontalAlignment) {
        super(icon, horizontalAlignment);
    }

    public ActiveContextLabel(HiResIcon icon) {
        super(icon);
    }

    public ActiveContextLabel() {
    }

    public void setContext(Context context) {
        if (context == null)
            return;
        this.ctx = context;
        themeChanged(Theme.current() == Theme.dark());
    }

    @Override
    public void themeChanged(boolean dark) {
        setBackground(ctx.getColor());
    }
}
