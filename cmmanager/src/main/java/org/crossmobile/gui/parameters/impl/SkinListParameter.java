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
package org.crossmobile.gui.parameters.impl;

import org.crossmobile.gui.parameters.SelectionListParameter;
import org.crossmobile.utils.Dependency;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.CM_DESKTOP_SKIN;

public class SkinListParameter extends SelectionListParameter {

    public SkinListParameter(ParamList plist) {
        super(plist, CM_DESKTOP_SKIN.tag(), Dependency.getSystemSkins());
    }

    @Override
    public String getVisualTag() {
        return "Skin";
    }

}
