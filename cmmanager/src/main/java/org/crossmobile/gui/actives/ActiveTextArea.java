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

import com.panayotis.hrgui.HiResTextArea;
import org.crossmobile.gui.elements.Theme;

import javax.swing.*;
import javax.swing.text.Document;

import static org.crossmobile.gui.actives.ActiveTextField.updateTheme;

public class ActiveTextArea extends HiResTextArea implements ThemeChanged {

    private final TooltipManager ttm = new TooltipManager(this);

    {
        setOpaque(true);
        ThemeNotifier.register(this);
        themeChanged(Theme.current() == Theme.dark());
    }

    public ActiveTextArea() {
    }

    public ActiveTextArea(String text) {
        super(text);
    }

    public ActiveTextArea(int rows, int columns) {
        super(rows, columns);
    }

    public ActiveTextArea(String text, int rows, int columns) {
        super(text, rows, columns);
    }

    public ActiveTextArea(Document doc) {
        super(doc);
    }

    public ActiveTextArea(Document doc, String text, int rows, int columns) {
        super(doc, text, rows, columns);
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
}
