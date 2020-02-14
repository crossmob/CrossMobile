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

import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.plugin.reg.TypeRegistry;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;

import static org.crossmobile.plugin.reg.TypeRegistry.*;
import static org.crossmobile.utils.NamingUtils.getClassNameFull;

public class ResultEmitter {

    private final static String RESULT = "re$ult";
    private final NType returnType;
    private final Class javaType;
    private final boolean forward;
    private final Emitter result;
    private final StringBuilder destroyBuffer = new StringBuilder();

    public ResultEmitter(NSelector sel, boolean forward) {
        this(sel.getReturnType(),
                sel.getJavaReturn(),
                sel.getOriginalCode(),
                sel.getReturnType().getType().isPrimitive() && !sel.getJavaReturn().isPrimitive(),
                sel.isConstructor(), sel.isFakeConstructor(), forward);
    }

    private ResultEmitter(NType returnType, Class javaType, String origCode, boolean boxed, boolean constructor, boolean fakeConstructor, boolean forward) {
        this.returnType = returnType;
        this.javaType = javaType;
        this.forward = forward;
        this.result = parseReturn(returnType, javaType, origCode, boxed, constructor, fakeConstructor, !forward);
    }

    private ResultEmitter(NType returnType, Class javaType, boolean forward, Emitter result) {
        this.returnType = returnType;
        this.javaType = javaType;
        this.forward = forward;
        this.result = result;
    }

    private Emitter parseReturn(NType type, Class javaType, String origCode, boolean boxed, boolean constructor, boolean fakeConstructor, boolean reverse) {
        if (isAnyReference(javaType))
            return new EmitterCType("", RESULT, type, isObjCReference(javaType) ? javaType : null, constructor, false, reverse);
        else if (javaType.equals(Void.TYPE))
            return EmitterVoid.TYPE;
        else if (type.isPrimitive())
            return new EmitterPrimitive("", RESULT, type, boxed, reverse);
        if (javaType.isArray())
            return new EmitterArray("", RESULT, type, javaType, reverse);
        else if (isObjCBased(javaType) || isJavaWrapped(javaType) || isTarget(javaType))
            return new EmitterObject("", RESULT, type, constructor || fakeConstructor, reverse);
        else if (type.getBlock() != null || isBlockTarget(javaType))
            return new EmitterBlock(RESULT, type, reverse);
        else {
            System.out.println("Unknown return emitter for " + getClassNameFull(type.getType()) + " in selector `" + origCode + "`");
            return new Emitter(RESULT, type, false, forward) {
            };
        }
    }

    ResultEmitter copy() {
        return new ResultEmitter(returnType, javaType, forward, result);
    }

    public void appendDestroy(String destroy) {
        destroyBuffer.append(destroy);
    }

    public void emit(Streamer out, String caller) throws IOException {
        boolean needsDestroy = destroyBuffer.length() > 0;
        out.append(result.exec(caller, needsDestroy))
                .append(destroyBuffer.toString())
                .append(result.result(caller, needsDestroy));
    }

}
