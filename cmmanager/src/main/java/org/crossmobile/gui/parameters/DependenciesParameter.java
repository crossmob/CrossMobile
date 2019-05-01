package org.crossmobile.gui.parameters;

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

import com.panayotis.hrgui.HiResComponent;
import org.crossmobile.gui.elements.DependencyEditor;
import org.crossmobile.utils.ParamList;
import org.crossmobile.utils.Pom;

import static org.crossmobile.utils.ParamsCommon.CM_PLUGINS;

public class DependenciesParameter extends ProjectParameter {

    private final DependencyEditor comp;

    private String value;

    public DependenciesParameter(ParamList list) {
        super(list, CM_PLUGINS.tag());
        value = list.get(CM_PLUGINS.tag());
        comp = new DependencyEditor(list, Pom.unpackDependencies(value));
        comp.addDependencyListener(deps -> {
            value = Pom.packDependencies(deps);
            fireValueUpdated();
        });
    }

    @Override
    public void updatePropertyList() {
        super.updatePropertyList();
        comp.updatePropertyList();
    }

    @Override
    public String getVisualTag() {
        return "";
    }

    @Override
    public String getValue() {
        if (value == null)
            return "";
        return value;
    }

    @Override
    protected HiResComponent initVisuals() {
        return comp;
    }
}
