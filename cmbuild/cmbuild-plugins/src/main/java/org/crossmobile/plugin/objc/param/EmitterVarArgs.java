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
import org.crossmobile.plugin.model.VarargType;

import static org.crossmobile.plugin.reg.TypeRegistry.VARARG_SIZE_SUPPORT;
import static org.crossmobile.utils.CollectionUtils.forEach;
import static org.crossmobile.utils.CollectionUtils.intList;
import static org.crossmobile.utils.TextUtils.TAB;

class EmitterVarArgs extends Emitter {

    private final VarargType type;

    EmitterVarArgs(NParam param, boolean forward) {
        super(param.getName(), param.getVarname(), param.getNType(), false, forward);
        type = param.getNType().getVarargType();
    }

    private void embedVararg(StringBuilder out, String DEFINE, boolean haveDouble, int upto) {
        out.append(TAB).append("#ifdef ").append(DEFINE).append("\n").append(TAB).append(TAB);
        forEach(intList(0, upto))
                .onAny(i -> {
                    out.append("var_p_item[").append(i).append("]");
                    if (haveDouble)
                        out.append(", var_d_item[").append(i).append("]");
                })
                .onFront(i -> out.append(", ")).onLast(i -> out.append("\n"))
                .go();
        out.append(TAB).append("#endif\n");
    }

    @Override
    protected String embedForward() {
        StringBuilder out = new StringBuilder();
        out.append('\n');
        if (type.virtual) {
            embedVararg(out, "VARARG_SIM_64", true, VARARG_SIZE_SUPPORT);
            embedVararg(out, "VARARG_PHONE_64", false, VARARG_SIZE_SUPPORT);
            embedVararg(out, "VARARG_32", false, VARARG_SIZE_SUPPORT * 2);
        } else {
            for (int i = 0; i < VARARG_SIZE_SUPPORT; i++)
                out.append(TAB).append("($ != JAVA_NULL && $->length > # ? $->array.o[#] : ".replace("$", givenVar()).replace("#", Integer.toString(i))).
                        append(type.function ? "NULL" : "nil").
                        append("),\n");
            out.append(TAB).append(type.function ? "NULL" : "nil");
        }
        return out.toString();
    }

    @Override
    protected String destroyForward() {
        return type.virtual
                ? "free(var_p_item);\nfree(var_d_item);\n"
                : super.destroyForward();
    }

    @Override
    protected String initForward() {
        return type.virtual
                ? "vartype* var_p_item;\ndouble* var_d_item;\n" +
                "gather_va_args(" + paramVar() + ", &var_p_item, &var_d_item, " + VARARG_SIZE_SUPPORT + ");\n"
                : super.initForward();
    }

    @Override
    public String objCParamSeparator() {
        return type.virtual ? "," : super.objCParamSeparator();
    }
}
