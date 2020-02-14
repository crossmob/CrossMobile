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
package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.utils.Log;

import static org.crossmobile.plugin.bro.JavaTransformer.POINTER_ANN;

public class PointerRParam extends RParam {
    public PointerRParam(NParam nParam, Class<?> parrameter, NType type) {
        super(nParam, parrameter, type);
    }

    @Override
    public String getNative() {
        if(getJava().equals(char[].class))
            return long.class.getCanonicalName();
        if(getJava().equals(byte[].class))
            return long.class.getCanonicalName();
        Log.error("Could not find correct native type for PointerRParam "+reference()+" with type : "+getJava().getCanonicalName() + " and native : " + getType().getNativeType());
        return super.getNative();
    }

    @Override
    public String annotation() {
        return POINTER_ANN;
    }
}
