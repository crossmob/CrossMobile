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

class EmitterMemSize extends Emitter {

    private final String init;

    EmitterMemSize(NParam param, boolean forward) {
        super(param.getName(), param.getVarname(), param.getNType(), false, forward);
        String varname = param.getAffiliation().getParameter().getVarname();
        if (param.getAffiliation().getParameter().getJavaParameter().getType().equals(String.class))
            init = "[" + varname + " length]";
        else
            init = "(" + varname + " == JAVA_NULL ? 0 : " + varname + "->length)";
    }

    @Override
    protected String embedForward() {
        return init;
    }

}
