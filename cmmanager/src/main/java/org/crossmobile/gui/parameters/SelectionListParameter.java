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

import com.panayotis.hrgui.HiResComboBox;
import com.panayotis.hrgui.HiResComponent;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamDisplay;
import org.crossmobile.utils.ParamDisplay.GenericParamDisplay;
import org.crossmobile.utils.ParamList;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;

public abstract class SelectionListParameter extends ProjectParameter {

    private String[] parameter;
    private String[] display;
    private String[] definition;
    private int value;
    private HiResComboBox<?> item;

    public SelectionListParameter(ParamList plist, Param key, String[] parameter, String[] display, String[] definition, int deflt) {
        this(plist, key, convert(parameter, display, definition, deflt));
    }

    public SelectionListParameter(ParamList plist, Param key, Collection<? extends ParamDisplay> pdds) {
        super(plist, key);
        updateVisuals(pdds, false);
        try {
            String v = plist.get(key).trim().toLowerCase();
            for (int i = 0; i < parameter.length; i++)
                if (parameter[i].toLowerCase().endsWith(v)) {
                    value = i;
                    break;
                }
        } catch (Exception ex) {
            Log.error(ex);
        }
    }

    @Override
    public String getValue() {
        return value < 0 ? "" : parameter[value];
    }

    @Override
    protected boolean isSingleLineVisual() {
        return true;
    }

    @Override
    protected HiResComponent initVisuals() {
        item = new HiResComboBox<>(display);
        item.setSelectedIndex(value);
        item.setOpaque(false);
        item.addActionListener((ActionEvent ae) -> {
            int newValue = item.getSelectedIndex();
            if (newValue != value) {
                value = newValue;
                fireValueUpdated();
            }
        });
        return item;
    }

    protected void setValue(String value) {
        int index = 0;
        for (int i = 0; i < parameter.length; i++)
            if (parameter[i].equals(value))
                index = i;
        item.setSelectedIndex(index);
    }

    protected final void updateVisuals(Collection<? extends ParamDisplay> items, boolean fireUpdate) {
        parameter = new String[items.size()];
        display = new String[parameter.length];
        definition = new String[parameter.length];
        int index = 0;
        for (ParamDisplay ppd : items) {
            parameter[index] = ppd.parameter();
            display[index] = ppd.display();
            definition[index] = ppd.definition();
            if (display[index] == null)
                display[index] = parameter[index];
            if (ppd.isDefault())
                this.value = index;
            index++;
        }
        if (fireUpdate)
            fireValueUpdated();
    }

    private static Collection<ParamDisplay> convert(String[] parameter, String[] display, String[] definition, int deflt) {
        Collection<ParamDisplay> result = new ArrayList<>();
        for (int i = 0; i < parameter.length; i++)
            result.add(new GenericParamDisplay(parameter[i],
                    display == null ? null : display[i],
                    definition == null ? null : definition[i],
                    deflt == i));
        return result;
    }
}
