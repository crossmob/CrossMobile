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

import org.crossmobile.plugin.model.NType;

import static org.crossmobile.utils.NamingUtils.toObjC;
import static org.crossmobile.plugin.utils.Texters.toObjCType;
import static org.crossmobile.utils.NamingUtils.getClassNameSimple;

public abstract class Emitter {

    private final String paramName;
    private final String givenVar;
    private final String paramVar;
    private final String nativeType;
    private final String safeNativeType;
    private final String javaType;
    private final String simpleName;
    protected final boolean isForward;
    protected final boolean isTransformed;

    public Emitter(String varName, NType type, boolean isTransformed, boolean isForward) {
        this("", varName, type, isTransformed, isForward);
    }

    public Emitter(String paramName, String varName, NType type, boolean isTransformed, boolean isForward) {
        this.givenVar = varName;
        this.paramVar = isTransformed ? varName + "$conv" : varName;
        this.paramName = isForward ? paramName : "";
        this.nativeType = type.getNativeType();
        this.safeNativeType = type.getSafeNativeType();
        this.javaType = toObjCType(type.getType());
        this.simpleName = toObjC(getClassNameSimple(type.getType()));
        this.isForward = isForward;
        this.isTransformed = isTransformed;
    }

    public final String givenVar() {
        return givenVar;
    }

    public final String paramVar() {
        return paramVar;
    }

    public final String paramName() {
        return paramName;
    }

    public String getNativeType() {
        return nativeType;
    }

    public String getSafeNativeType() {
        return safeNativeType;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getInstanceName() {
        return "self";
    }

    public final String init() {
        return isForward ? initForward() : initReverse();
    }

    public final String embed() {
        return isForward ? embedForward() : embedReverse();
    }

    public final String destroy() {
        return isForward ? destroyForward() : destroyReverse();
    }

    public final String exec(String exec, boolean needsDestroy) {
        // inverse wiring due to return type
        return isForward ? execReverse(exec, needsDestroy) : execForward(exec, needsDestroy);
    }

    public final String result(String exec, boolean needsDestroy) {
        // inverse wiring due to return type
        return isForward ? resultReverse(exec, needsDestroy) : resultForward(exec, needsDestroy);
    }

    protected String initForward() {
        return "";
    }

    protected String initReverse() {
        return "";
    }

    protected String embedForward() {
        return paramVar;
    }

    protected String embedReverse() {
        return paramVar;
    }

    protected String destroyForward() {
        return "";
    }

    protected String destroyReverse() {
        return "";
    }

    protected String execForward(String exec, boolean needsDestroy) {
        return needsDestroy
                ? (nativeType.equals("instancetype") ? "id" : (isForward ? nativeType : javaType)) + " " + givenVar + " = " + exec + ";\n"
                : "return " + exec + ";\n";
    }

    protected String resultForward(String exec, boolean needsDestroy) {
        return needsDestroy
                ? "return " + givenVar + ";\n"
                : "";
    }

    protected String execReverse(String exec, boolean needsDestroy) {
        return execForward(exec, needsDestroy);
    }

    protected String resultReverse(String exec, boolean needsDestroy) {
        return resultForward(exec, needsDestroy);
    }

    public boolean isParameterHidden() {
        return false;
    }

    public String objCParamSeparator() {
        return ":";
    }
}
