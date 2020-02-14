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
package org.crossmobile.plugin.objc.param;

import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.plugin.objc.ReverseImportRegistry;
import org.crossmobile.plugin.objc.SelectorEmitterBlock;
import org.crossmobile.plugin.reg.ObjectRegistry;
import org.crossmobile.plugin.utils.Streamer;
import org.crossmobile.plugin.utils.Texters;

import java.io.IOException;

class EmitterBlock extends Emitter {

    private final NSelector block;
    private final ReverseImportRegistry handleRegistry;
    private final Class<?> containerObject;
    private final String containerSelector;

    EmitterBlock(NParam param, ReverseImportRegistry handleRegistry, boolean forward) {
        this(param.getName(), param.getVarname(), param.getNType(), handleRegistry,
                param.getContainer().getContainer().getType(),
                Texters.getSelectorSignature(param.getContainer()),
                forward);
    }

    EmitterBlock(String varName, NType type, boolean forward) {
        this("", varName, type, null, null, null, forward);
    }

    private EmitterBlock(String paramName, String varName, NType type, ReverseImportRegistry handleRegistry, Class<?> containerObject, String containerSelector, boolean forward) {
        super(paramName, varName, type, true, forward);
        this.handleRegistry = handleRegistry;
        this.containerObject = containerObject;
        this.containerSelector = containerSelector;
        if (type.getBlock() == null) {
            NObject nobj = ObjectRegistry.retrieve(type.getType());
            this.block = nobj == null || nobj.getSelectors().isEmpty() ? null : nobj.getSelectors().iterator().next();
        } else
            this.block = type.getBlock();
    }

    @Override
    protected String embedForward() {
        if (block == null)
            return "";
        Streamer out = Streamer.asString();
        try {
            new SelectorEmitterBlock(block, givenVar()).emitImplementation(out);
            return "(" + givenVar() + " == JAVA_NULL ? nil : ^" + out + ")";
        } catch (IOException ex) {
            return "";
        }
    }

    @Override
    protected String initReverse() {
        String randomClass = handleRegistry.requestRandomClass(containerObject, containerSelector, block);
        return randomClass + "* " + paramVar() + " = [[" + randomClass + " alloc] initWithCMBlock:" + givenVar() + "];\n";
    }

    @Override
    protected String destroyReverse() {
        return "[" + paramVar() + " release];\n";
    }
}
