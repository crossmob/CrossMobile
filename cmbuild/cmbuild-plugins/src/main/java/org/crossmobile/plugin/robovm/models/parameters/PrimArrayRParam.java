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

public class PrimArrayRParam extends RParam {
    public PrimArrayRParam(NParam nParam, Class<?> parameter, NType type) {
        super(nParam, parameter, type);
    }


    @Override
    public String getNativeReturn() {
        if(getType().getType().equals(double[].class))
            return "org.robovm.rt.bro.ptr.MachineSizedFloatPtr";
        if(getType().getType().equals(float[].class))
            return "org.robovm.rt.bro.ptr.MachineSizedFloatPtr";
        if(getType().getType().equals(int[].class))
            return "org.robovm.rt.bro.ptr.IntPtr";
        if(getType().getType().equals(long[].class))
            return "org.robovm.rt.bro.ptr.LongPtr";
        Log.error("No Pointer class set for " + getType().getType().getSimpleName());
        return "org.robovm.rt.bro.ptr.Ptr";
    }
}
