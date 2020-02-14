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

import org.crossmobile.plugin.model.MethodType;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.plugin.reg.TypeRegistry;

import java.lang.reflect.Modifier;

import static org.crossmobile.bridge.ann.CMReference.REFERENCE_NAME;
import static org.crossmobile.utils.NamingUtils.toObjC;
import static org.crossmobile.utils.NamingUtils.getClassNameSimple;

class EmitterCType extends Emitter {

    private final String nativeName;
    private final String javaClassName;
    private final boolean struct;
    private final boolean asSelf;
    private final boolean constructor;

    EmitterCType(NParam param, boolean constructor, boolean forward) {
        this(param.getName(), param.getVarname(), param.getNType(), constructor, isSelf(param), forward);
    }

    EmitterCType(String paramName, String varName, NType type, boolean constructor, boolean asSelf, boolean forward) {
        this(paramName, varName, type, null, constructor, asSelf, forward);
    }

    EmitterCType(String paramName, String varName, NType type, Class<?> selfType, boolean constructor, boolean asSelf, boolean forward) {
        super(paramName, varName, type, true, forward);
        selfType = selfType == null ? type.getType() : selfType;
        this.nativeName = getClassNameSimple(selfType);
        this.javaClassName = toObjC(selfType);
        this.struct = TypeRegistry.isStruct(selfType);
        this.asSelf = asSelf;
        this.constructor = constructor;
    }

    @Override
    protected String embedForward() {
        String target = asSelf ? "self" : givenVar();
        return struct
                ? "[" + target + " get" + getNativeType() + "]"
                : target + "->" + REFERENCE_NAME;
    }

    @Override
    protected String initReverse() {
        return getJavaType() + " " + paramVar() + " = [[" + javaClassName + " alloc] initWith" + nativeName + ":" + givenVar() + "];\n";
    }

    @Override
    protected String destroyReverse() {
        return "[" + paramVar() + " release];\n";
    }

    @Override
    protected String execForward(String exec, boolean needsDestroy) {
        exec = (constructor ? "[self initWith" : "[[" + javaClassName + " alloc] initWith") + nativeName + ":" + exec + "]";
        return super.execForward(exec, needsDestroy);
    }

    @Override
    protected String execReverse(String exec, boolean needsDestroy) {
        return struct
                ? getJavaType() + " " + givenVar() + " = " + exec + ";\n"
                + getNativeType() + " " + paramVar() + " = [" + givenVar() + " get" + nativeName + "];\n"
                + "[" + givenVar() + " " + (struct ? "release" : "autorelease") + "];\n"
                : getJavaType() + " " + givenVar() + " = " + exec + ";\n"
                + "[" + givenVar() + " autorelease];\n";
    }

    @Override
    protected String resultReverse(String exec, boolean needsDestroy) {
        return struct
                ? "return " + paramVar() + ";\n"
                : "return " + givenVar() + "->" + REFERENCE_NAME + ";\n";
    }

    private static boolean isSelf(NParam param) {
        return param.getContainer().getMethodType() == MethodType.FUNCTION
                && param.getContainer().getParams().get(0) == param
                && !Modifier.isStatic(param.getContainer().getJavaExecutable().getModifiers())
                && param.getNType().getType().isAssignableFrom(param.getContainer().getContainer().getType());
    }

}
