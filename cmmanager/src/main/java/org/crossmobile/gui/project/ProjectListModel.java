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
