/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
