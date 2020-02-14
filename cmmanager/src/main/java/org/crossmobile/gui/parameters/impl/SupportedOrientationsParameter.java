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

import org.crossmobile.gui.parameters.MultiButtonParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.ORIENTATIONS_SUPPORTED;

public class SupportedOrientationsParameter extends MultiButtonParameter {

    private static final char SEPERATOR = ':';

    public SupportedOrientationsParameter(ParamList list) {
        super(list, ORIENTATIONS_SUPPORTED.tag(),
                new String[]{"UIInterfaceOrientationPortrait",
                        "UIInterfaceOrientationLandscapeRight",
                        "UIInterfaceOrientationPortraitUpsideDown",
                        "UIInterfaceOrientationLandscapeLeft"},
                new String[]{"Portrait", "Right", "Upside down", "Left"},
                new String[]{"images/portrait", "images/right", "images/upside", "images/left"},
                null, SEPERATOR);
    }

    @Override
    public String getVisualTag() {
        return "Supported orientations:";
    }

    public void setOrientation(String value) {
        activateValue(value);
    }
}
