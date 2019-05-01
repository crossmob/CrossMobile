package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;

public class RefRParam extends RParam {
    public RefRParam(NParam nParam, Class<?> parameter, NType type) {
        super(nParam, parameter, type);
    }

    @Override
    public String getNative() {
        return getJavaType();
    }


}
