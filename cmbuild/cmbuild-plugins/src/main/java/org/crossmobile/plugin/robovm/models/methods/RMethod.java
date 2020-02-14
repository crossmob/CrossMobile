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
package org.crossmobile.plugin.robovm.models.methods;

import javassist.CannotCompileException;
import javassist.CtBehavior;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.util.List;
import java.util.function.Function;

import static org.crossmobile.utils.JavassistUtils.addAnnotation;
import static org.crossmobile.utils.JavassistUtils.makeMethod;

public abstract class RMethod {
    static final Function<RParam, String> nparam = RParam::getNative;
    static final Function<RParam, String> nreturn = RParam::getNativeReturn;
    private final NSelector selector;
    private final RParam returnParam;
    private final List<RParam> parameters;
    private final NObject object;
    private final CtClass cclass;
    private final boolean needsReturn;
    protected CtBehavior method;
    private boolean needsMapping = false;


    public RMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        this.selector = selector;
        this.returnParam = returnParam;
        this.needsReturn = !returnParam.isVoid();
        this.parameters = parameters;
        this.needsMapping = returnParam.needsConvert() || parameters.stream().anyMatch(RParam::needsConvert);
        this.object = object;
        this.cclass = cclass;
    }

    public CtBehavior getMethod() {
        return method;
    }

    public boolean needsMapping() {
        return needsMapping;
    }

    public NSelector getSelector() {
        return selector;
    }

    public RParam getReturnParam() {
        return returnParam;
    }

    public List<RParam> getParameters() {
        return parameters;
    }

    public NObject getObject() {
        return object;
    }

    public CtClass getCclass() {
        return cclass;
    }

    public boolean needsReturn() {
        return needsReturn;
    }

    protected void setModifiers() throws CannotCompileException {
        method.setModifiers(method.getModifiers() & ~Modifier.ABSTRACT | Modifier.NATIVE);
    }

    protected void addMethodAnnotation() {

    }

    protected void makeNativeMethod() {
        method = makeMethod(selector.getJavaExecutable().getName(), returnParam, parameters, nparam, nreturn, cclass);
    }

    public void buildNative() throws CannotCompileException {
        makeNativeMethod();
        setModifiers();
        annotateParams(method, parameters, false);
        annotateReturn(method, returnParam, false);
        addMethodAnnotation();
        cclass.addMethod((CtMethod) method);
    }

    protected void annotateParams(CtBehavior method, List<RParam> params, boolean isMapping) {
        if (!params.isEmpty()) {
            int actualParamIndex = 0;
            for (int i = 0; i < params.size(); i++) {
                String ann = params.get(i).annotation();
                if ((isMapping ? params.get(i).reference() : params.get(i)) != null) {
                    if (!ann.isEmpty())
                        addAnnotation(method, actualParamIndex, ann, params.get(i).annotationParams());
                    actualParamIndex++;
                }
            }
        }
    }

    protected void annotateReturn(CtBehavior method, RParam param, boolean isMapping) {
        String ann = param.annotation();
        if (!ann.isEmpty())
            addAnnotation(method, ann, param.annotationParams());
    }

    protected String mapSignature() {
        StringBuilder signature = new StringBuilder(mapReturn()).append(" ").append(javaSignature()).append("(");
        String prepend = "";
        for (RParam parameter : parameters)
            if (parameter.reference() != null) {
                signature.append(prepend).append(parameter.getJavaType()).append(" ").append(parameter.reference());
                prepend = ", ";
            }
        signature.append(")");
        return signature.toString();
    }

    protected String mapReturn() {
        return returnParam.getJavaType();
    }

    protected String javaSignature() {
        return getSelector().getJavaExecutable().getName();
    }

    protected String conversions() {
        StringBuilder conversions = new StringBuilder();
        for (RParam parameter : parameters)
            if (!parameter.conversion().isEmpty()) conversions.append(parameter.conversion()).append("\n");
        return conversions.toString();
    }

    protected String nativeCall() {
        StringBuilder nativeCall = new StringBuilder(nativeSignature()).append("(");
        String prepend = "";
        for (RParam parameter : parameters)
            if (parameter.convRef() != null) {
                nativeCall.append(prepend).append(parameter.convRef());
                prepend = ", ";
            }
        nativeCall.append(")");
        return nativeCall.toString();
    }

    protected String nativeSignature() {
        return method.getName();
    }

    protected CtBehavior mapping;

    public void buildNativeMapping() throws CannotCompileException {
        mapping = CtNewMethod.make(mapMethod(), cclass);
        setMappingModifiers();
        annotateReturn(mapping, returnParam, true);
        annotateParams(mapping, parameters, true);
        addMappingAnnotation();
        cclass.addMethod((CtMethod) mapping);
    }


    protected String mapMethod() {
        return mapSignature() + "{\n" + conversions() + (needsReturn() ? "return " : "") + nativeCall() + ";\n}";
    }

    protected void setMappingModifiers() {
        mapping.setModifiers(method.getModifiers() & ~Modifier.NATIVE);
    }

    protected void addMappingAnnotation() {

    }

    public CtMethod getNativeMapping() {
        return null;
    }
}
