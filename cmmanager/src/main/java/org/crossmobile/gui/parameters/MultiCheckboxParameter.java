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
package org.crossmobile.gui.parameters;

import com.panayotis.hrgui.HiResComponent;
import com.panayotis.hrgui.HiResPanel;
import org.crossmobile.gui.actives.ActiveCheckBox;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class MultiCheckboxParameter extends MultiBooleanParameter {

    private ActiveCheckBox[] items;
    private final int columns;

    public MultiCheckboxParameter(ParamList plist, Param key, String[] parameter, String[] display, String textValue, int columns, char separator) {
        this(plist, key, parameter, display, null, textValue, columns, separator);
    }

    public MultiCheckboxParameter(ParamList plist, Param key, String[] parameter, String[] display, String[] tooltips, String textValue, int columns, char separator) {
        super(plist, key, parameter, display, tooltips, textValue, separator);
        this.columns = columns > 0 ? columns : 1;
    }

    @Override
    protected final void activateIndex(int idx) {
        items[idx].setSelected(true);
    }

    @Override
    protected HiResComponent initVisuals() {
        HiResPanel visuals = new HiResPanel();
        visuals.setLayout(new GridLayout(0, columns));
        visuals.setOpaque(false);
        items = new ActiveCheckBox[value.length];
        ActionListener listener = (ActionEvent ae) -> {
            int index = Integer.parseInt(ae.getActionCommand());
            value[index] = items[index].isSelected();
            fireValueUpdated();
        };
        for (int index = 0; index < items.length; index++) {
            ActiveCheckBox cb = new ActiveCheckBox(display[index]);
            cb.addActionListener(listener);
            visuals.add(cb);
            cb.setActionCommand(String.valueOf(index));
            cb.setSelected(value[index]);
            cb.setOpaque(false);
            if (tooltips != null)
                cb.setToolTipText(tooltips[index]);
            items[index] = cb;
        }
        return visuals;
    }
}
