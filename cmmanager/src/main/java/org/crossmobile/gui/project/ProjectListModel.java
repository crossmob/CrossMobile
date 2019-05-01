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
package org.crossmobile.gui.project;

import javax.swing.*;
import java.util.List;

public class ProjectListModel extends AbstractListModel {

    private List<ProjectInfo> list;

    public ProjectListModel() {
        reload();
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public ProjectInfo getElementAt(int i) {
        return list.get(i);
    }

    public final void reload() {
        list = RecentsProjectManager.getProjects();
        fireContentsChanged(this, 0, list.size() - 1);
    }

    public int getIndex(ProjectInfo item) {
        return list.indexOf(item);
    }
}
