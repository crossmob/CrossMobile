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
