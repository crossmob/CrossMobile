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
package org.crossmobile.plugin.objc.param;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.VarargType;

import static org.crossmobile.plugin.reg.TypeRegistry.VARARG_SIZE_SUPPORT;
import static org.crossmobile.utils.TextUtils.TAB;

class EmitterVarArgs extends Emitter {

    private final VarargType type;

    EmitterVarArgs(NParam param, boolean forward) {
        super(param.getName(), param.getVarname(), param.getNType(), false, forward);
        type = param.getNType().getVarargType();
    }

    @Override
    protected String embedForward() {
        if (type.virtual)
            return super.embedForward();
        StringBuilder out = new StringBuilder();
        out.append('\n');
        for (int i = 0; i < VARARG_SIZE_SUPPORT; i++)
            out.append(TAB).append("($ != JAVA_NULL && $->length > # ? $->array.o[#] : ".replace("$", givenVar()).replace("#", Integer.toString(i))).
                    append(type.function ? "NULL" : "nil").
                    append("),\n");
        out.append(TAB).append(type.function ? "NULL" : "nil");
        return out.toString();
    }
}
