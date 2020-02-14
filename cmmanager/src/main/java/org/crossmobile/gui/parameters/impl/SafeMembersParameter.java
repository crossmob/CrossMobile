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

import org.crossmobile.gui.parameters.BooleanParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.CM_OBJC_SAFEMEMBERS;

public class SafeMembersParameter extends BooleanParameter {

    public SafeMembersParameter(ParamList list) {
        super(list, CM_OBJC_SAFEMEMBERS.tag(), true);
    }

    @Override
    protected String getVisualBooleanTag() {
        return "Use safe member references";
    }

    @Override
    protected String tooltipForStatus(Boolean status) {
        return "<html>When enabled, full java inheritance on member variables is supported.<br/>" +
                "If safe references are disabled, then the generated iOS code is faster,<br/>" +
                "but inherited objects could not have members with the same name as<br/>" +
                "in parent objects. ";
    }
}
