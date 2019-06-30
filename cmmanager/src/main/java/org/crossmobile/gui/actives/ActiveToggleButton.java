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

import com.panayotis.hrgui.HiResEmptyBorder;
import com.panayotis.hrgui.HiResIcon;
import com.panayotis.hrgui.HiResToggleButton;
import org.crossmobile.gui.elements.Theme;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ActiveToggleButton extends HiResToggleButton {

    private final TooltipManager ttm = new TooltipManager(this);

    private boolean isPressed = false;
    private boolean isRollover = false;

    {
        setUI(new BasicButtonUI());
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                isRollover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isRollover = false;
                repaint();
            }
        });
    }

    public ActiveToggleButton(String text, int borderSize) {
        this(text, null, borderSize);
    }

    public ActiveToggleButton(String text, HiResIcon icon) {
        this(text, icon, 12);
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ActiveToggleButton(String text, HiResIcon icon, int bordersize) {
        super(text);
        if (icon != null)
            setIcons(icon);
        setBorder(new HiResEmptyBorder(bordersize, bordersize, bordersize, bordersize));
    }


    @Override
    public void setToolTipText(String text) {
        ttm.setToolTipText(text);
    }

    public void setToolTip(JToolTip toolTip) {
        ttm.setToolTip(toolTip);
    }

    @Override
    public void paint(Graphics g) {
        Color back = null;
        if (isEnabled())
            if (isPressed)
                back = Theme.current().pressedButton;
            else if (isRollover)
                back = Theme.current().rolloverButton;
            else if (isSelected())
                back = Theme.current().selectedButton;
        if (back != null) {
            g.setColor(back);
            Dimension d = getSize();
            g.fillRect(0, 0, d.width, d.height);
        }
        super.paint(g);
    }

    @Override
    public Color getForeground() {
        return Theme.current().text;
    }
}
