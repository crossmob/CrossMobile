/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.cat;

import org.crossmobile.backend.desktop.DesktopLocations;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IconHolder extends JPanel {

    public static final int XICONS = 6;
    public static final int YICONS = 4;
    public static final int ICONSIZE = 60;
    public static final int SPACE = 5;
    public static final int TEXTHEIGHT = 12;
    //
    public static final int XSIZE = ICONSIZE + SPACE * 2;
    public static final int YSIZE = ICONSIZE + SPACE * 2 + TEXTHEIGHT;
    public static final int DELETELOC;
    //
    private static final Dimension size = new Dimension(XICONS * XSIZE, YICONS * YSIZE);
    private static final BufferedImage delete;
    //
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final Set<IconSelectionListener> listeners = new HashSet<>();
    private List<List<MobileApp>> apps;
    private int page;
    private int selected;
    private int current;
    // Editable parameters
    private boolean editable = false;
    private long time = 0;
    private final Timer animTimer = new Timer(1000 / 50, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            time++;
            repaint();
        }
    }) {
        @Override
        public void start() {
            super.start();
            time = 0;
        }
    };

    static {
        BufferedImage d = null;
        try {
            d = ImageIO.read(IconHolder.class.getResourceAsStream(DesktopLocations.ICONS + "delete.png"));
        } catch (Exception ex) {
        }
        delete = d;
        DELETELOC = delete == null ? 0 : (ICONSIZE - delete.getWidth()) / 2;
    }

    public IconHolder() throws Exception {
        reloadData();
        if (apps.get(0).isEmpty())
            throw new Exception("Empty list");

        addMouseListener(new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                fireInfo(getSelectedApp(e));
                selected = current = getSelectedItem(e);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (current >= 0)
                    fireSelection(apps.get(page).get(current));
                selected = current = -1;
                repaint();
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                fireInfo(getSelectedApp(e));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                fireInfo(null);
            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseMoved(MouseEvent e) {
                fireInfo(getSelectedApp(e));
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                current = getSelectedItem(e);
                if (current != selected)
                    current = -1;
                repaint();
            }
        });

        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
    }

    private void reloadData() {
        page = 0;
        selected = -1;
        current = -1;
        apps = new ArrayList<>();

        int pageSize = XICONS * YICONS;
        int fillMeter = 0;
        apps.clear();
        List<MobileApp> clist = new ArrayList<>();
        apps.add(clist);
        for (MobileApp app : ApplicationCatalogue.getApps()) {
            if (fillMeter > pageSize) {
                clist = new ArrayList<>();
                apps.add(clist);
            }
            clist.add(app);
        }
        repaint();
    }

    private int getSelectedItem(MouseEvent e) {
        int x = e.getX() / XSIZE;
        int y = e.getY() / YSIZE;
        int res = x + y * XICONS;
        return (x < 0 || y < 0 || x >= XICONS || y >= YICONS || res >= apps.get(page).size()) ? -1 : res;
    }

    private MobileApp getSelectedApp(MouseEvent e) {
        int which = getSelectedItem(e);
        return which < 0 ? null : apps.get(page).get(which);
    }

    @Override
    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size.width, size.height);
        g.setColor(Color.WHITE);

        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 11));

        List<MobileApp> list = apps.get(page);

        finishDraw:
        for (int j = 0; j < YICONS; j++)
            for (int i = 0; i < XICONS; i++) {
                int cur = i + j * XICONS;
                if (cur >= list.size())
                    break finishDraw;
                int xoff = i * XSIZE;
                int yoff = j * YSIZE;

                MobileApp app = list.get(cur);

                if (editable) {
                    g.translate(xoff + SPACE + ICONSIZE / 2, yoff + SPACE + ICONSIZE / 2);
                    double rotation = Math.sin(time * 0.5 + i + j) / 8;
                    g.rotate(rotation);
                    g.drawImage(app.icon(cur == current), -ICONSIZE / 2, -ICONSIZE / 2, ICONSIZE, ICONSIZE, null);
                    if (delete != null)
                        g.drawImage(delete, DELETELOC, DELETELOC, null);
                    g.rotate(-rotation);
                    g.translate(-(xoff + SPACE + ICONSIZE / 2), -(yoff + SPACE + ICONSIZE / 2));
                } else
                    g.drawImage(app.icon(cur == current), xoff + SPACE, yoff + SPACE, ICONSIZE, ICONSIZE, null);

                String text = app.name();
                if (text.length() >= 10)
                    text = text.substring(0, 9) + "…";
                int width = g.getFontMetrics().stringWidth(text);
                g.drawString(text, xoff + (XSIZE - width) / 2, yoff + SPACE + ICONSIZE + TEXTHEIGHT);
            }
    }

    public void addIconListener(IconSelectionListener listener) {
        listeners.add(listener);
    }

    public void removeIconListener(IconSelectionListener listener) {
        listeners.remove(listener);
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        if (editable == this.editable)
            return;
        this.editable = editable;
        if (editable)
            animTimer.restart();
        else
            animTimer.stop();
        repaint();
    }

    private void fireInfo(MobileApp info) {
        for (IconSelectionListener listener : listeners)
            listener.iconInfo(info);
    }

    private void fireSelection(MobileApp selection) {
        if (selection == null)
            return;
        for (IconSelectionListener listener : listeners)
            listener.iconSelected(selection);
    }

    public void removeApp(MobileApp app) {
        ApplicationCatalogue.remove(app);
        reloadData();
    }
}
