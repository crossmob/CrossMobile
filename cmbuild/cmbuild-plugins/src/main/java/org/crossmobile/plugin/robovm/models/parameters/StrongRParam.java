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
import org.crossmobile.plugin.robovm.ClassBuilder;
import org.crossmobile.utils.Log;

public class StrongRParam extends RParam {
    private final String nativeS;

    public StrongRParam(NParam nParam, Class<?> parrameter, NType type) {
        super(nParam, parrameter, type);
        if (!ClassBuilder.wp.contains(parrameter.getName()))
            Log.error("Water Park does not contain : " + parrameter.getName());
        nativeS = ClassBuilder.wp.get(super.getNative() + "$" + getType().getType().getSimpleName() + "Ptr").getName();
    }

    @Override
    public String getNative() {
        return nativeS;
    }


    @Override
    public String conversion() {
        return getNative() + " " + reference() + "$strong = new " + getNative() + "();\n" + reference() + "$strong.set(" + reference() + ".get());";
    }

    @Override
    public String convRef() {
        return reference() + "$strong";
    }
}
