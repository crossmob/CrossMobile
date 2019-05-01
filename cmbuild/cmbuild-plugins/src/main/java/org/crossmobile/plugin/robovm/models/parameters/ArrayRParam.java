package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;

public class ArrayRParam extends RParam {
    public ArrayRParam(NParam nParam, Class<?> parameter, NType type) {
        super(nParam, parameter, type);
    }

    @Override
    public boolean needsConvert() {
        return true;
    }

    @Override
    public String convRef() {
        return reference() + "$conv";
    }

    @Override
    public String conversion() {
        return "         if (" + reference() + " == null) {\n" +
                "            throw new NullPointerException(\"" + reference() + "\");\n" +
                "        }\n" +
                "        " + getNative() + " " + convRef() + " = Struct.allocate(" + getNative() + ", " + reference() + ".length);\n" +
                "        " + convRef() + ".update(" + reference() + ");\n" +
                "        addRects(" + convRef() + ", " + reference() + ".length);";
    }

    @Override
    public String getNative() {
        return getJava().getComponentType().getCanonicalName();
    }
}
