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
import org.crossmobile.gui.utils.LaunchType;
import org.crossmobile.gui.utils.Paths;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.ParamList;
import org.crossmobile.utils.SystemDependent;

public class ReleaseParameter extends RadioParameter {

    private static final boolean XRay = Paths.getXRayPath() != null;

    public ReleaseParameter(ParamList list, LaunchType defaultType) {
        super(list, null,
                XRay ? new String[]{"images/debug", "images/xray", "images/release"} : new String[]{"images/debug", "images/release"},
                XRay ? new String[]{"Debug profile", "XRay profile", "Release profile"} : new String[]{"Debug profile", "Release profile"},
                XRay ? new String[]{"debug", "xray", "release"} : new String[]{"debug", "release"},
                defaultType.name().toLowerCase(), false);
    }


    @Override
    protected String getVisualTag() {
        return "Profile selection";
    }

    @Override
    public boolean shouldTrackChanges() {
        return false;
    }
}
