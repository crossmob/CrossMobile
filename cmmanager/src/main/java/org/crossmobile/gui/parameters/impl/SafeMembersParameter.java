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
