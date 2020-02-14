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

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class TooltipManager {

    private static final PopupFactory popupFactory = PopupFactory.getSharedInstance();
    private Popup popup;
    private JToolTip toolTip;
    private final JComponent parent;

    TooltipManager(JComponent parent) {
        this.parent = parent;
        parent.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (toolTip != null) {
                    try {
                        Point p = parent.getLocationOnScreen();
                        p.y += parent.getHeight() + 1;
                        popup = popupFactory.getPopup(parent, toolTip, p.x, p.y);
                        popup.show();
                    } catch (Exception ignore) {
                        hidePopup();
                    }
                }
            }

            private void hidePopup() {
                if (popup != null) {
                    popup.hide();
                    popup = null;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hidePopup();
            }
        });
    }

    void setToolTipText(String text) {
        if (text == null || text.trim().isEmpty())
            toolTip = null;
        else {
            if (toolTip == null)
                toolTip = parent.createToolTip();
            toolTip.setTipText(text);
        }
    }

    void setToolTip(JToolTip toolTip) {
        this.toolTip = toolTip;
    }
}
