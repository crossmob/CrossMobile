package org.crossmobile.gui.actives;

import com.panayotis.hrgui.HiResPanel;

import java.awt.*;

public class ActivePanel extends HiResPanel {
    {
        setOpaque(false);
    }

    public ActivePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public ActivePanel(LayoutManager layout) {
        super(layout);
    }

    public ActivePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public ActivePanel() {
    }
}
