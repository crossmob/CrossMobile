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
