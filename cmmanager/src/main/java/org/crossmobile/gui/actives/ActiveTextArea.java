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

import com.panayotis.hrgui.HiResTextArea;
import org.crossmobile.gui.elements.Theme;

import javax.swing.*;
import javax.swing.text.Document;

import static org.crossmobile.gui.actives.ActiveTextField.updateTheme;

public class ActiveTextArea extends HiResTextArea implements ThemeChanged {

    private final TooltipManager ttm = new TooltipManager(this);
    private boolean inactiveColorFollowsActive = false;

    {
        setOpaque(true);
        setTabSize(4);
        ThemeNotifier.register(this);
        themeChanged(Theme.current() == Theme.dark());
    }

    public ActiveTextArea() {
    }

    public ActiveTextArea(String text) {
        super(text);
    }

    public ActiveTextArea(int rows, int columns) {
        super(rows, columns);
    }

    public ActiveTextArea(String text, int rows, int columns) {
        super(text, rows, columns);
    }

    public ActiveTextArea(Document doc) {
        super(doc);
    }

    public ActiveTextArea(Document doc, String text, int rows, int columns) {
        super(doc, text, rows, columns);
    }

    @Override
    public void setToolTipText(String text) {
        ttm.setToolTipText(text);
    }

    public void setToolTip(JToolTip toolTip) {
        ttm.setToolTip(toolTip);
    }

    public void setInactiveColorFollowsActive(boolean inactiveColorFollowsActive) {
        if (this.inactiveColorFollowsActive == inactiveColorFollowsActive)
            return;
        this.inactiveColorFollowsActive = inactiveColorFollowsActive;
        themeChanged(Theme.current() == Theme.dark());
    }

    @Override
    public void themeChanged(boolean dark) {
        updateTheme(this, dark);
        if (inactiveColorFollowsActive)
            setDisabledTextColor(getForeground());
    }
}
