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
package org.crossmobile.gui.parameters.impl;

import org.crossmobile.gui.parameters.SelectionListParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.CM_PROJECT;

public class ProjectTypeParameter extends SelectionListParameter {

    public ProjectTypeParameter(ParamList list) {
        super(list, CM_PROJECT.tag(), new String[]{"iphone", "ipad", "ios"}, new String[]{"Phone only", "Pad only", "Hybrid Phone and Pad"}, new String[]{"Project will be phone-only", "Project will be pad-only", "Project will support both phone and pad idioms"}, 0);
    }

    @Override
    public String getVisualTag() {
        return "Project type";
    }
}
