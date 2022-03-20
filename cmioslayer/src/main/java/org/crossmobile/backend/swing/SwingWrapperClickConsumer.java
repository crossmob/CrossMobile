/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class SwingWrapperClickConsumer implements MouseListener, MouseMotionListener {

    private final MouseListener[] mouse;
    private final MouseMotionListener[] mouseMotion;
    public boolean active = true;

    public SwingWrapperClickConsumer(JComponent parent) {
        this.mouse = parent.getMouseListeners();
        this.mouseMotion = parent.getMouseMotionListeners();
        parent.addMouseListener(this);
        parent.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (active)
            for (MouseListener mouse1 : mouse)
                mouse1.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        SwingGraphicsBridge.component.mousePressed(e);
        if (active)
            for (MouseListener mouse1 : mouse)
                mouse1.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX() < 0 || e.getY() < 0)
            return;
        SwingGraphicsBridge.component.mouseReleased(e);
        if (active)
            for (MouseListener mouse1 : mouse)
                mouse1.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (active)
            for (MouseListener mouse1 : mouse)
                mouse1.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (active)
            for (MouseListener mouse1 : mouse)
                mouse1.mouseExited(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        SwingGraphicsBridge.component.mouseDragged(e);
        if (active)
            for (MouseMotionListener mouseMotion1 : mouseMotion)
                mouseMotion1.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        SwingGraphicsBridge.component.mouseMoved(e);
        if (active)
            for (MouseMotionListener mouseMotion1 : mouseMotion)
                mouseMotion1.mouseMoved(e);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
