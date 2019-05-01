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
package org.crossmobile.gui.actives;

import com.panayotis.hrgui.HiResRadioButton;
import org.crossmobile.gui.elements.Theme;

import javax.swing.*;
import java.awt.*;

public class ActiveRadioButton extends HiResRadioButton {
    private final TooltipManager ttm = new TooltipManager(this);

    {
        setOpaque(false);
    }

    public ActiveRadioButton() {
    }

    public ActiveRadioButton(Icon icon) {
        super(icon);
    }

    public ActiveRadioButton(Action a) {
        super(a);
    }

    public ActiveRadioButton(Icon icon, boolean selected) {
        super(icon, selected);
    }

    public ActiveRadioButton(String text) {
        super(text);
    }

    public ActiveRadioButton(String text, boolean selected) {
        super(text, selected);
    }

    public ActiveRadioButton(String text, Icon icon) {
        super(text, icon);
    }

    public ActiveRadioButton(String text, Icon icon, boolean selected) {
        super(text, icon, selected);
    }

    @Override
    public void setToolTipText(String text) {
        ttm.setToolTipText(text);
    }

    public void setToolTip(JToolTip toolTip) {
        ttm.setToolTip(toolTip);
    }

    @Override
    public Color getForeground() {
        return Theme.current().text;
    }

}
