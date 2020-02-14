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
package org.crossmobile.plugin.objc.param;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.utils.ReflectionUtils;

import java.lang.reflect.Method;

import static org.crossmobile.plugin.utils.Texters.methodObjCName;

class EmitterSelector extends Emitter {

    private final String selector;

    EmitterSelector(NParam param, boolean forward) {
        super(param.getName(), param.getVarname(), param.getNType(), false, forward);
        Class baseClass = param.getAffiliation() != null
                ? param.getAffiliation().getParameter().getJavaParameter().getType()
                : param.getJavaParameter().getType();
        Method m = ReflectionUtils.getLambdaMethod(baseClass);
        StringBuilder sel = new StringBuilder();
        sel.append(methodObjCName(m));
        for (int i = 0; i < m.getParameterCount(); i++)
            sel.append(":");
        selector = sel.toString();
    }

    @Override
    protected String embedForward() {
        return "@selector(" + selector + ")";
    }

    @Override
    public String getInstanceName() {
        return isForward
                ? "(" + givenVar() + " == JAVA_NULL ? nil : " + givenVar() + ")"
                : "(" + givenVar() + " ? JAVA_NULL : " + givenVar() + ")";
    }

}
