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
