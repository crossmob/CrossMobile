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
package org.crossmobile.gui.parameters;

import com.panayotis.hrgui.HiResComponent;
import com.panayotis.hrgui.HiResPanel;
import org.crossmobile.gui.actives.ActiveIcon;
import org.crossmobile.gui.actives.ActiveToggleButton;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import javax.swing.*;
import java.util.Objects;

public abstract class RadioParameter<T> extends ProjectParameter {

    private String[] values;
    private final String[] icons;
    private final String[] texts;
    private String value;

    public RadioParameter(ParamList list, Param key, String[] icons, String[] texts, String[] values, String deflt, boolean strict) {
        super(list, key);
        value = deflt;
        this.icons = icons;
        this.texts = texts;
        this.values = values;
        Objects.requireNonNull(icons);
        Objects.requireNonNull(texts);
        Objects.requireNonNull(this.values);
        if (values.length != icons.length)
            throw new IllegalArgumentException("Possible values are " + values.length + " but " + icons.length + " icons found");
        if (values.length != texts.length)
            throw new IllegalArgumentException("Possible values are " + values.length + " but " + texts.length + " texts found");

        boolean found = false;
        for (String current : values) {
            if (Objects.equals(current, deflt)) {
                found = true;
                break;
            }
        }
        if (!found && strict)
            throw new IllegalArgumentException("Default value " + deflt + " is not part of the expected values");
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    protected HiResComponent initVisuals() {
        HiResPanel comp = new HiResPanel();
        comp.setLayout(new BoxLayout(comp, BoxLayout.X_AXIS));
        comp.setOpaque(false);
        ButtonGroup bg = new ButtonGroup();
        for (int i = 0; i < values.length; i++) {
            ActiveToggleButton button = new ActiveToggleButton(texts[i], new ActiveIcon(icons[i]));
            button.setActionCommand(values[i]);
            bg.add(button);
            comp.add(button);
            if (Objects.equals(value, values[i]))
                button.setSelected(true);
            button.addActionListener(e -> {
                if (!Objects.equals(value, button.getActionCommand())) {
                    value = button.getActionCommand();
                    fireValueUpdated();
                }
            });
        }
        return comp;
    }
}
