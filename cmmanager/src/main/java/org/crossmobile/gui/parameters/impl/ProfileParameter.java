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

import org.crossmobile.gui.parameters.RadioParameter;
import org.crossmobile.gui.utils.Profile;
import org.crossmobile.utils.CollectionUtils;
import org.crossmobile.utils.ParamList;
import org.crossmobile.utils.TextUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.crossmobile.utils.CollectionUtils.asList;

public class ProfileParameter extends RadioParameter {
    private static final List<String> PROFILES;

    static {
        PROFILES = new ArrayList<>();
        for (Profile p : Profile.values())
            if (p.isValid())
                PROFILES.add(p.name().toLowerCase());
    }

    public ProfileParameter(ParamList list, Profile defaultType) {
        super(list, null, asList(PROFILES, a -> "images/" + a),
                asList(PROFILES, TextUtils::capitalize),
                PROFILES, defaultType.name().toLowerCase(), false);
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
