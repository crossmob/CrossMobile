package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;

import static org.crossmobile.plugin.bro.JavaTransformer.BYTE_PTR;
import static org.crossmobile.plugin.bro.JavaTransformer.STRUCT;

public class StringArrayRParam extends RParam {
    public StringArrayRParam(NParam nParam, Class<?> parameter, NType type) {
        super(nParam, parameter, type);
    }

    @Override
    public String getNative() {
        return BYTE_PTR + "$BytePtrPtr";
    }

    @Override
    public String convRef() {
        return reference() + "$conv";
    }

    @Override
    public String conversion() {
        return "        " + getNative() + " " + convRef() + " = null;\n" +
                "        if (" + reference() + ".length > 0) {\n" +
                "            " + convRef() + " = (" + getNative() + ")" + STRUCT + ".allocate(" + getNative() + ".class, " + reference() + ".length);\n" +
                "            for (int i = 0; i < " + reference() + ".length; i++) {\n" +
                "                // TODO: Encoding?\n" +
                "                " + BYTE_PTR + " arg = " + BYTE_PTR + ".toBytePtrAsciiZ(" + reference() + "[i]);\n" +
                "                ((" + getNative() + ") " + convRef() + ".next((long)i)).set(arg);\n" +
                "            }\n" +
                "        }";
    }
}
