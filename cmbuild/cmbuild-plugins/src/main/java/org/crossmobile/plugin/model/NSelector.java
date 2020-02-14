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
package org.crossmobile.plugin.model;

import java.lang.reflect.Executable;
import java.lang.reflect.Modifier;
import java.util.*;

import static org.crossmobile.plugin.reg.TypeRegistry.getJavaBoxed;
import static org.crossmobile.plugin.reg.TypeRegistry.isBlockParameterSupported;
import static org.crossmobile.utils.CollectionUtils.forEach;
import static org.crossmobile.utils.NamingUtils.execSignature;
import static org.crossmobile.utils.NamingUtils.toObjC;
import static org.crossmobile.utils.ReflectionUtils.appearsInParent;

public class NSelector extends NParsable implements Comparable<NSelector> {

    /* Function info */
    private NType returnType;
    private String name;
    private final List<NParam> params = new ArrayList<>();
    private Executable java;
    private Class javaReturn;
    private boolean constructor;
    private boolean fakeConstructor;
    private MethodType methodType = MethodType.SELECTOR;

    /* Selector info */
    private NObject container;
    private NProperty property;
    private boolean asStatic;
    private String swiftMethod = "";
    private NStructField structRef;

    /* Function info */
    public void setConstructor(boolean constructor) {
        this.constructor = constructor;
    }

    public boolean isConstructor() {
        return constructor;
    }

    public void setReturnType(NType returnType) {
        this.returnType = returnType;
    }

    public NType getReturnType() {
        return returnType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getObjCSignature() {
        StringBuilder out = new StringBuilder();
        out.append(name);
        forEach(params)
                .onFront(n -> out.append(n.getName()).append(":"))
                .go();
        return out.toString();
    }

    private String getJavaSignature() {
        return execSignature(java, false);
    }

    public void addParam(NParam param) {
        if (param.getNType().getType().equals(void.class))
            return;
        params.add(param);
        param.setContainer(this);
    }

    public List<NParam> getParams() {
        return params;
    }

    public Collection<String> getDependencies() {
        return getDependencies(false);
    }

    private Collection<String> getDependencies(boolean forceBoxed) {
        Set<String> deps = new HashSet<>();
        addType(deps, javaReturn, returnType.getType(), forceBoxed);
        for (NParam param : params) {
            addType(deps, param.getJavaParameter() == null ? param.getNType().getType() : param.getJavaParameter().getType(), param.getNType().getType(), forceBoxed);
            if (param.getNType().getBlock() != null)
                deps.addAll(param.getNType().getBlock().getDependencies(true));
        }
        return deps;
    }

    private void addType(Set<String> deps, Class javaType, Class nativeType, boolean forceBoxed) {
        if (javaType.equals(void.class))
            return;
        if (forceBoxed)
            javaType = getJavaBoxed(nativeType);
        if (!javaType.isPrimitive() && !javaType.isArray())
            deps.add(toObjC(javaType));
    }

    public void setJavaExecutable(Executable javaMethod, Class javaReturn) {
        this.java = javaMethod;
        this.javaReturn = javaReturn;
    }

    public Executable getJavaExecutable() {
        return java;
    }

    public Class getJavaReturn() {
        return javaReturn;
    }

    public void setMethodType(MethodType methodType) {
        Objects.requireNonNull(methodType);
        this.methodType = methodType;
    }

    public MethodType getMethodType() {
        return methodType;
    }

    /* Selector info */
    public void setContainer(NObject container) {
        this.container = container;
    }

    public NObject getContainer() {
        return container;
    }

    public void setStatic(boolean asStatic) {
        this.asStatic = asStatic;
    }

    public boolean isStatic() {
        return asStatic;
    }

    public boolean needsOverrideBindings() {
        return !asStatic && !isConstructor() && !Modifier.isFinal(java.getModifiers()) && !Modifier.isStatic(java.getModifiers())
                && isBlockParameterSupported(this);
    }

    public void setProperty(NProperty property) {
        this.property = property;
    }

    public NProperty getProperty() {
        return property;
    }

    public boolean isSetter() {
        return property != null && getName().startsWith("set");
    }

    public boolean isGetter() {
        return property != null && !getName().startsWith("set");
    }

    @Override
    public int compareTo(NSelector other) {
        if (Modifier.isStatic(this.java.getModifiers()) != Modifier.isStatic(other.java.getModifiers()))
            return Modifier.isStatic(this.java.getModifiers()) ? -1 : 1;
        if (this.isConstructor() != other.isConstructor())
            return this.isConstructor() ? -1 : 1;
        if (this.property != null && other.property != null) {
            if (this.property.getName().equals(other.property.getName())) {
                if (this.isSetter() == other.isSetter())
                    return getJavaSignature().compareTo(other.getJavaSignature());
                return this.isSetter() ? -1 : 1;
            }
            return this.property.getName().compareTo(other.property.getName());
        } else if (this.property != null)
            return -1;
        else if (other.property != null)
            return 1;
        return getJavaSignature().compareTo(other.getJavaSignature());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.getJavaExecutable());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final NSelector other = (NSelector) obj;
        if (!this.java.getName().equals(other.java.getName()))
            return false;
        return getJavaSignature().equals(other.getJavaSignature());
    }

    public String getFamily() {
        return isGetter() ? "getter" : (isSetter() ? "setter" : (isConstructor() ? "constructor" : methodType.name().toLowerCase()));
    }

    public boolean isInherited() {
        return appearsInParent(java) != java.getDeclaringClass();
    }

    public void removeLastParam() {
        if (!params.isEmpty())
            params.remove(params.size() - 1);
    }

    public void setFakeConstructor(boolean fakeConstructor) {
        this.fakeConstructor = fakeConstructor;
    }

    /**
     * A static method that works as constructor: usually this appears ONLY in NSString
     */
    public boolean isFakeConstructor() {
        return fakeConstructor;
    }

    public void setSwiftMethod(String swiftMethod) {
        this.swiftMethod = swiftMethod;
    }

    /**
     * The Swift method used as a bridge between a varargs argument and a va_list argument. The va_list
     * argument name of this method <b>should</b> be va_array.
     */
    public String getSwiftMethod() {
        return swiftMethod;
    }

    @Override
    public String toString() {
        return getJavaSignature();
    }

    /**
     * In case this is a struct reference method, set here the corresponding references
     *
     * @param structRef
     */
    public void setStructRef(NStructField structRef) {
        this.structRef = structRef;
    }

    public NStructField getStructRef() {
        return structRef;
    }
}
