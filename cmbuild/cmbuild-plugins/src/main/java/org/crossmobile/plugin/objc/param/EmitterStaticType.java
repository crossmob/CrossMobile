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
import org.crossmobile.plugin.model.NType;
import org.crossmobile.plugin.model.StaticMappingType;

class EmitterStaticType extends Emitter {

    private final boolean nativeType;

    EmitterStaticType(NParam param, boolean forward) {
        this(param.getNType(), param.getVarname(), param.getStaticMapping() == StaticMappingType.NATIVE, forward);
    }

    EmitterStaticType(NType type, String paramName, boolean nativeType, boolean forward) {
        super("", nativeType ? "self" : paramName, type, false, forward);
        this.nativeType = nativeType;
    }

    @Override
    public String getInstanceName() {
        return nativeType
                ? super.getInstanceName()
                : "(" + givenVar() + " == JAVA_NULL ? nil : " + givenVar() + ")";
    }

    @Override
    public boolean isParameterHidden() {
        return !nativeType;
    }

}
