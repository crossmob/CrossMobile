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
package org.crossmobile.xray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.EventListener;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AutoResizingVisual extends JComponent {

    private static final int FlexibleLeftMargin = 1;
    private static final int FlexibleWidth = 1 << 1;
    private static final int FlexibleRightMargin = 1 << 2;
    private static final int FlexibleTopMargin = 1 << 3;
    private static final int FlexibleHeight = 1 << 4;
    private static final int FlexibleBottomMargin = 1 << 5;

    private static final int INX = 14;
    private static final int INY = 14;
    private static final int OUTX = 14;
    private static final int OUTY = 14;
    private static final int ARROW = 4;

    private static final Color ENABLED = Color.red;
    private static final Color DISABLED = new Color(255, 200, 200);

    private static final int sizex = INX * 2 + OUTX * 2 + 5;
    private static final int sizey = INY * 2 + OUTY * 2 + 5;

    private boolean fixedTop = true;
    private boolean fixedLeft = true;
    private boolean fixedBottom = false;
    private boolean fixedRight = false;
    private boolean flexibleWidth = false;
    private boolean flexibleHeight = false;

    @SuppressWarnings("unchecked")
    private final Consumer<Boolean>[] setters = new Consumer[6];
    @SuppressWarnings("unchecked")
    private final Supplier<Boolean>[] getters = new Supplier[6];

    private int resizingMask;
    private boolean ignoreMouse = true;
    private int lastSelection = -1;
    private boolean oldValue;

    {
        recalculateAutoResizeMask();

        setters[0] = v -> fixedTop = v;
        setters[1] = v -> fixedLeft = v;
        setters[2] = v -> fixedBottom = v;
        setters[3] = v -> fixedRight = v;
        setters[4] = v -> flexibleWidth = v;
        setters[5] = v -> flexibleHeight = v;
        getters[0] = () -> fixedTop;
        getters[1] = () -> fixedLeft;
        getters[2] = () -> fixedBottom;
        getters[3] = () -> fixedRight;
        getters[4] = () -> flexibleWidth;
        getters[5] = () -> flexibleHeight;

        Dimension size = new Dimension(sizex, sizey);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                lastSelection = checkMouseLocation(e.getX(), e.getY());
                ignoreMouse = lastSelection < 0;
                if (lastSelection >= 0) {
                    oldValue = getters[lastSelection].get();
                    setters[lastSelection].accept(!oldValue);
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                recalculateAutoResizeMask();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (ignoreMouse)
                    return;
                setters[lastSelection].accept((checkMouseLocation(e.getX(), e.getY()) == lastSelection) != oldValue);
                repaint();
            }
        });
    }

    @SuppressWarnings("WeakerAccess")
    public void setAutoResizeMask(int mask) {
        fixedTop = (mask & FlexibleTopMargin) == 0;
        fixedLeft = (mask & FlexibleLeftMargin) == 0;
        fixedBottom = (mask & FlexibleBottomMargin) == 0;
        fixedRight = (mask & FlexibleRightMargin) == 0;
        flexibleWidth = (mask & FlexibleWidth) != 0;
        flexibleHeight = (mask & FlexibleHeight) != 0;
        recalculateAutoResizeMask();
    }

    @SuppressWarnings("unused")
    public int getAutoResizeMask() {
        return resizingMask;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, sizex - 1, sizey - 1);

        g.setColor(Color.lightGray);
        g.drawRect(0, 0, sizex - 1, sizey - 1);

        g.setColor(Color.gray);
        g.drawRect(OUTX + 1, OUTY + 1, INX * 2 + 2, INY * 2 + 2);

        drawEnabled(g, fixedTop);
        drawVertOut(g, 1);

        drawEnabled(g, fixedLeft);
        drawHorOut(g, 1);

        drawEnabled(g, fixedBottom);
        drawVertOut(g, OUTY + INY * 2 + 4);

        drawEnabled(g, fixedRight);
        drawHorOut(g, OUTX + INX * 2 + 4);

        drawEnabled(g, flexibleWidth);
        drawHorIn(g);

        drawEnabled(g, flexibleHeight);
        drawVertIn(g);

    }

    private void drawVertOut(Graphics g, int y) {
        g.drawLine(OUTX + INX + 2, y, OUTX + INX + 2, y + OUTY - 1);
        g.drawLine(OUTX + INX + 2 - ARROW, y, OUTX + INX + ARROW + 2, y);
        g.drawLine(OUTX + INX + 2 - ARROW, y + OUTY - 1, OUTX + INX + ARROW + 2, y + OUTY - 1);
    }

    private void drawHorOut(Graphics g, int x) {
        g.drawLine(x, OUTY + INY + 2, x + OUTX - 1, OUTY + INY + 2);
        g.drawLine(x, OUTY + INY + 2 - ARROW, x, OUTY + INY + ARROW + 2);
        g.drawLine(x + OUTX - 1, OUTY + INY + 2 - ARROW, x + OUTX - 1, OUTY + INY + ARROW + 2);
    }

    private void drawHorIn(Graphics g) {
        g.drawLine(OUTX + 2, OUTY + INY + 2, OUTX + 2 + INX * 2, OUTY + INY + 2);
        g.drawLine(OUTX + 2, OUTY + INY + 2, OUTX + 2 + ARROW, OUTY + INY + 2 - ARROW);
        g.drawLine(OUTX + 2, OUTY + INY + 2, OUTX + 2 + ARROW, OUTY + INY + 2 + ARROW);
        g.drawLine(OUTX + 2 + INX * 2, OUTY + INY + 2, OUTX + 2 + INX * 2 - ARROW, OUTY + INY + 2 - ARROW);
        g.drawLine(OUTX + 2 + INX * 2, OUTY + INY + 2, OUTX + 2 + INX * 2 - ARROW, OUTY + INY + 2 + ARROW);
    }

    private void drawVertIn(Graphics g) {
        g.drawLine(OUTX + INX + 2, OUTY + 2, OUTX + INX + 2, OUTY + 2 + INY * 2);
        g.drawLine(OUTX + INX + 2, OUTY + 2, OUTX + INX + 2 - ARROW, OUTY + 2 + ARROW);
        g.drawLine(OUTX + INX + 2, OUTY + 2, OUTX + INX + 2 + ARROW, OUTY + 2 + ARROW);
        g.drawLine(OUTX + INX + 2, OUTY + 2 + INY * 2, OUTX + INX + 2 - ARROW, OUTY + 2 + INY * 2 - ARROW);
        g.drawLine(OUTX + INX + 2, OUTY + 3 + INY * 2, OUTX + INX + 2 + ARROW, OUTY + 2 + INY * 2 - ARROW);
    }

    private void drawEnabled(Graphics g, boolean enabled) {
        g.setColor(enabled ? ENABLED : DISABLED);
    }

    private int checkMouseLocation(int x, int y) {
        if (x < 0 || y < 0 || x >= sizex || y >= sizey)
            return -1;
        float xrelative = (2f * x - sizex) / sizex;
        float yrelative = (sizey - 2f * y) / sizey;
        double theta = Math.atan2(yrelative, xrelative);
        int quadrant;
        if (Math.abs(theta) <= Math.PI / 4)
            quadrant = 3;
        else if (theta > 0 && theta <= 3 * Math.PI / 4)
            quadrant = 0;
        else if (theta < 0 && theta >= -3 * Math.PI / 4)
            quadrant = 2;
        else
            quadrant = 1;
        if (!(x < OUTX + 1 || x >= (sizex - OUTX - 1) || y < OUTY + 1 || y >= (sizey - OUTY - 1)))  // inner box
            quadrant = quadrant == 1 || quadrant == 3 ? 4 : 5;
        return quadrant;
    }

    private void recalculateAutoResizeMask() {
        int oldmask = resizingMask;
        resizingMask = (fixedTop ? 0 : FlexibleTopMargin)
                | (fixedLeft ? 0 : FlexibleLeftMargin)
                | (fixedBottom ? 0 : FlexibleBottomMargin)
                | (fixedRight ? 0 : FlexibleRightMargin)
                | (flexibleWidth ? FlexibleWidth : 0)
                | (flexibleHeight ? FlexibleHeight : 0);
        if (oldmask != resizingMask)
            fireUpdate();
    }

    @SuppressWarnings("WeakerAccess")
    public void addListener(AutoResizingListener listener) {
        listenerList.add(AutoResizingListener.class, listener);
    }

    @SuppressWarnings("unused")
    public void removeListener(AutoResizingListener listener) {
        listenerList.remove(AutoResizingListener.class, listener);
    }

    private void fireUpdate() {
        for (AutoResizingListener listener : listenerList.getListeners(AutoResizingListener.class))
            listener.maskUpdatedTo(resizingMask);
    }

    public interface AutoResizingListener extends EventListener {

        void maskUpdatedTo(int autoResizingMask);
    }
}
