package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;

public class InstanceRParam extends RParam {
    public InstanceRParam(NParam nParam, Class<?> parrameter, NType type) {
        super(nParam, parrameter, type);
    }

    @Override
    public boolean needsConvert() {
        return false;
    }

    @Override
    public String getJavaType() {
        return "";
    }

    public String getNative() {
        return long.class.getName();
    }

    @Override
    public String annotation() {
        return "org.robovm.rt.bro.annotation.Pointer";
    }
}
