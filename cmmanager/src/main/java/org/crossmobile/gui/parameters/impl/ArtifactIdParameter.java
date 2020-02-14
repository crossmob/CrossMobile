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

import org.crossmobile.gui.elements.IdDocumentFilter;
import org.crossmobile.gui.parameters.FreeTextParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.ARTIFACT_ID;

public class ArtifactIdParameter extends FreeTextParameter {

    public static final String DEFAULT_ARTIFACT_ID = "crossmobile.projects";

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ArtifactIdParameter(ParamList list) {
        super(list, ARTIFACT_ID.tag());
        setValue(getValue());
        setFilter(new IdDocumentFilter(true));
        setTooltip(IdDocumentFilter.TOOLTIP_SIMPLE);
    }

    @Override
    public String getVisualTag() {
        return "Application name";
    }

    @Override
    public String getValue() {
        String val = super.getValue();
        if (val == null)
            return DEFAULT_ARTIFACT_ID;
        return val.toLowerCase();
    }

}
