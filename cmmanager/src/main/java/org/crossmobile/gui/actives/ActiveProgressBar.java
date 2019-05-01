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

import com.panayotis.hrgui.HiResProgressBar;

import javax.swing.*;

public class ActiveProgressBar extends HiResProgressBar {
    public ActiveProgressBar() {
    }

    public ActiveProgressBar(int orient) {
        super(orient);
    }

    public ActiveProgressBar(int min, int max) {
        super(min, max);
    }

    public ActiveProgressBar(int orient, int min, int max) {
        super(orient, min, max);
    }

    public ActiveProgressBar(BoundedRangeModel newModel) {
        super(newModel);
    }
}
