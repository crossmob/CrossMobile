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
package org.crossmobile.gui.elements;

import org.crossmobile.gui.ProjectFrame;
import org.crossmobile.gui.actives.ActiveButton;
import org.crossmobile.gui.actives.ActivePanel;

import java.awt.*;
import java.util.function.Consumer;

public class BottomPanel extends ActivePanel {

    private ProjectFrame projectFrame;
    private final ActiveButton button;

    public BottomPanel(String label, String icon, Consumer<ProjectFrame> callback) {
        super(new FlowLayout(FlowLayout.LEFT));
         button = new ActiveButton();
        if (label != null)
            button.setText(label);
        if (icon != null)
            button.setIcon(icon);
        if (callback != null)
            button.addActionListener(e -> callback.accept(this.projectFrame));
        add(button);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        button.setEnabled(enabled);
    }

    public void setProjectFrame(ProjectFrame projectFrame) {
        this.projectFrame = projectFrame;
    }
}
