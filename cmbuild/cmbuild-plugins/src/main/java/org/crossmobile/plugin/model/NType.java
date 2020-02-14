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

import java.util.Collection;
import java.util.HashSet;

public class NType {

    private final Collection<NType> genericTypes = new HashSet<>();
    private final String nativeType;
    private final Class<?> type;
    private VarargType vararg;
    private boolean constant;
    private int references;
    private String convFunction = "";
    private String sizeResolver = "";
    private NSelector block;

    public NType(String nativeType, Class<?> javaType) {
        if (nativeType.startsWith("const"))
            nativeType = nativeType.substring(5);
        nativeType = nativeType.trim();
        this.nativeType = nativeType;
        this.type = javaType;
    }

    public Class<?> getType() {
        return type;
    }

    public String getNativeType() {
        return nativeType;
    }

    public String getSafeNativeType() {
        String ntype = getNativeType();
        return ntype.equals("instancetype") ? "id" : ntype.replaceAll("<.*>", "");
    }

    public void addGenericType(NType genericType) {
        this.genericTypes.add(genericType);
    }

    public Collection<NType> getGenericTypes() {
        return genericTypes;
    }

    public boolean isPrimitive() {
        return type.isPrimitive();
    }

    public void setVarArgType(VarargType vararg) {
        this.vararg = vararg;
    }

    public VarargType getVarargType() {
        return vararg;
    }

    public void setBlock(NSelector block) {
        this.block = block;
    }

    public NSelector getBlock() {
        return block;
    }

    public void setReferences(int references) {
        this.references = references;
    }

    public int countReferences() {
        return references;
    }

    public void setConstant(boolean constant) {
        this.constant = constant;
    }

    public boolean isConstant() {
        return constant;
    }

    public void setConverterFunction(String convFunction) {
        if (convFunction == null)
            convFunction = "";
        this.convFunction = convFunction;
    }

    public String getConverterFunction() {
        return convFunction;
    }

    public void setSizeResolver(String sizeResolver) {
        if (sizeResolver == null)
            sizeResolver = "";
        this.sizeResolver = sizeResolver;
    }

    public String getSizeResolver() {
        return sizeResolver;
    }

}
