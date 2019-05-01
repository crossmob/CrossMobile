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
import com.panayotis.hrgui.ScreenUtils;
import org.crossmobile.gui.actives.ActiveCheckBox;
import org.crossmobile.gui.actives.ActiveIcon;
import org.crossmobile.gui.actives.ActiveToggleButton;
import org.crossmobile.utils.Param;
import org.crossmobile.utils.ParamList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class BooleanParameter extends ProjectParameter {

    private boolean value;
    private final String enabledIcon;
    private final String disabledIcon;
    private final String enabledText;
    private final String disabledText;

    public BooleanParameter(ParamList list, Param key, boolean deflt) {
        this(list, key, null, null, null, null, deflt);
    }

    public BooleanParameter(ParamList list, Param key, String enabledText, String disabledText, String enabledIcon, String disabledIcon, boolean deflt) {
        super(list, key);
        value = deflt;
        try {
            String v = list.get(key).trim().toLowerCase();
            value = v.equals("true") || v.equals("yes") || v.equals("enabled") || v.equals("1");
        } catch (Exception ex) {
        }
        this.enabledIcon = enabledIcon == null ? "" : enabledIcon;
        this.disabledIcon = disabledIcon == null ? "" : disabledIcon;
        this.enabledText = enabledText == null ? "" : enabledText;
        this.disabledText = disabledText == null ? "" : disabledText;
    }

    @Override
    public String getValue() {
        return Boolean.toString(value);
    }

    @Override
    protected final String getVisualTag() {
        if (enabledIcon.isEmpty() && disabledIcon.isEmpty())
            return "";
        else
            return getVisualBooleanTag();
    }

    protected abstract String getVisualBooleanTag();

    @Override
    protected HiResComponent initVisuals() {
        HiResComponent comp;
        if (!enabledIcon.isEmpty() || !disabledIcon.isEmpty()) {
            HiResPanel basePanel = new HiResPanel(new BorderLayout(0, (int) (3 * ScreenUtils.getGraphicsScale())));
            basePanel.setOpaque(false);
            ActiveToggleButton enabledB = new ActiveToggleButton(enabledText, new ActiveIcon(enabledIcon));
            enabledB.addActionListener(e -> {
                if (!value) {
                    value = true;
                    fireValueUpdated();
                }
            });
            ActiveToggleButton disabledB = new ActiveToggleButton(disabledText, new ActiveIcon(disabledIcon));
            disabledB.addActionListener(e -> {
                if (value) {
                    value = false;
                    fireValueUpdated();
                }
            });
            String tooltip = tooltipForStatus(false);
            if (tooltip != null)
                disabledB.setToolTipText(tooltip);
            tooltip = tooltipForStatus(true);
            if (tooltip != null)
                enabledB.setToolTipText(tooltip);
            ButtonGroup bg = new ButtonGroup();
            bg.add(enabledB);
            bg.add(disabledB);

            HiResPanel buttonPanel = new HiResPanel(new GridLayout(1, 0));
            buttonPanel.setOpaque(false);
            basePanel.add(buttonPanel, BorderLayout.WEST);
            buttonPanel.add(disabledB);
            buttonPanel.add(enabledB);

            if (value)
                enabledB.setSelected(true);
            else
                disabledB.setSelected(true);
            comp = basePanel;
        } else {
            ActiveCheckBox cb = new ActiveCheckBox(getVisualBooleanTag());
            cb.setSelected(value);
            cb.setOpaque(false);
            cb.addActionListener((ActionEvent ae) -> {
                if (value != cb.isSelected()) {
                    value = cb.isSelected();
                    fireValueUpdated();
                }
            });
            String tooltip = tooltipForStatus(null);
            if (tooltip != null)
                cb.setToolTipText(tooltip);
            comp = cb;
        }
        return comp;
    }

    /**
     * The tooltip to display based on the currently selected status
     *
     * @param status the status: could be null if a check box is used instead of a boolean image icon
     * @return the desired tooltip
     */
    protected String tooltipForStatus(Boolean status) {
        return null;
    }
}
