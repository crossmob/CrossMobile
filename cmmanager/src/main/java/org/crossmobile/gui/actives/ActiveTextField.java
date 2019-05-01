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

import com.panayotis.hrgui.HiResTextComponent;
import com.panayotis.hrgui.HiResTextField;
import org.crossmobile.gui.elements.Theme;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ActiveTextField extends HiResTextField implements ThemeChanged {

    private final TooltipManager ttm = new TooltipManager(this);

    public ActiveTextField() {
        this("");
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ActiveTextField(String text) {
        super(text);
        setOpaque(true);
        ThemeNotifier.register(this);
        themeChanged(Theme.current() == Theme.dark());
    }

    @Override
    public void setToolTipText(String text) {
        ttm.setToolTipText(text);
    }

    public void setToolTip(JToolTip toolTip) {
        ttm.setToolTip(toolTip);
    }

    @Override
    public void themeChanged(boolean dark) {
        updateTheme(this, dark);
    }

    static void updateTheme(HiResTextComponent comp, boolean dark) {
        comp.comp().setBackground(Theme.current().textBack);
        comp.comp().setForeground(dark ? Color.white : Color.black);
        comp.comp().setBorder(new MatteBorder(1, 1, 1, 1, Theme.current().textBorder));
        comp.comp().setCaretColor(dark ? Color.white : Color.black);
    }
}
