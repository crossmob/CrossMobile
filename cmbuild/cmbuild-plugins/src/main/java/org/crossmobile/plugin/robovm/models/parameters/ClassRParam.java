package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;

import static org.crossmobile.plugin.bro.JavaTransformer.OBJC_CLS;

public class ClassRParam extends RParam {
    public ClassRParam(NParam nParam, Class<?> parrameter, NType type) {
        super(nParam, parrameter, type);
    }

    @Override
    public String convRef() {
        return reference() + "$conv";
    }

    @Override
    public boolean needsConvert() {
        return true;
    }

    @Override
    public String conversion() {
        return "         String " + convRef() + " = null;\n" +
                "        if (" + reference() + " != null) {\n" +
                "            " + convRef() + " = " + OBJC_CLS + ".getByType(" + reference() + ").getName();\n" +
                "        }";
    }
}
