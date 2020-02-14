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
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NType;

import static org.crossmobile.plugin.reg.TypeRegistry.getCastingIfNeeded;

class EmitterObject extends Emitter {

    private final String convFunction;
    private final boolean needsRetain;
    private final String casting;

    EmitterObject(NParam param, NSelector sel, boolean forward) {
        this(param.getName(), param.getVarname(), param.getNType(), !(sel.isConstructor() || sel.isFakeConstructor()), forward);
    }

    EmitterObject(String paramName, String varName, NType type, boolean noObjectRetainNeeded, boolean forward) {
        super(paramName, varName, type, !type.getConverterFunction().isEmpty(), forward);
        this.convFunction = type.getConverterFunction();
        this.needsRetain = !noObjectRetainNeeded;
        casting = getCastingIfNeeded(type.getNativeType());
    }

    @Override
    protected String embedForward() {
        return convFunction + "(" + getForward() + ")";
    }

    private String getForward() {
        return givenVar() + " == JAVA_NULL ? nil : " + givenVar();
    }

    @Override
    protected String embedReverse() {
        return "(" + givenVar() + " ? " + casting + givenVar() + " : JAVA_NULL)";
    }

    @Override
    protected String execForward(String exec, boolean needsDestroy) {
        return (!needsRetain && !needsDestroy)
                ? "return " + exec + ";\n"
                : super.execForward(exec, true);
    }

    @Override
    protected String resultForward(String caller, boolean needsDestroy) {
        if (!needsRetain && !needsDestroy)
            return "";
        else if (!needsRetain)
            return "return " + givenVar() + ";\n";
        else
            return "return [(" + givenVar() + " ? " + givenVar() + " : JAVA_NULL) " + "retain];\n";
    }

    @Override
    protected String execReverse(String exec, boolean needsDestroy) {
        return super.execReverse(exec, needsDestroy); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String resultReverse(String exec, boolean needsDestroy) {
        return "return [(" + givenVar() + " == JAVA_NULL ? nil : " + givenVar() + ") " + "autorelease];\n";
    }

}
