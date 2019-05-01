package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;

public class StaticRefRParam extends RParam {
    public StaticRefRParam(NParam nParam, Class<?> parrameter, NType type) {
        super(nParam, parrameter, type);
    }

    @Override
    public String convRef() {
        return "this";
    }

    @Override
    public boolean needsConvert() {
        return true;
    }

    @Override
    public String reference() {
        return null;
    }

    @Override
    public String getJavaType() {
        return getType().getType().getName();
    }
}
