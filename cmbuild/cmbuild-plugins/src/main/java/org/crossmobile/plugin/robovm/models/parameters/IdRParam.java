package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;

public class IdRParam extends RParam {
    public IdRParam(NParam nParam, Class<?> parrameter, NType type) {
        super(nParam, parrameter, type);
    }


    @Override
    public String getNative() {
        return "NSObject";
    }
}
