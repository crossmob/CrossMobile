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

import org.crossmobile.gui.parameters.RadioParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.DEBUG_PROFILE;

public class AndroidLogParameter extends RadioParameter {
    public AndroidLogParameter(ParamList list) {
        super(list, null
                , new String[]{"images/4of4", "images/3of4", "images/2of4", "images/1of4"}
                , new String[]{"Full debug", "Out & Error", "Error", "NSLog only"}
                , new String[]{"full", "outerr", "err", "nslog"}, "outerr", false);
    }

    @Override
    protected String getVisualTag() {
        return "Debug output";
    }

    @Override
    public boolean shouldTrackChanges() {
        return false;
    }
}
