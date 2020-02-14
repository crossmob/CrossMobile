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
package org.crossmobile.plugin.objc;

import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;

import static org.crossmobile.utils.CollectionUtils.forEach;

public class SelectorEmitterBlock extends SelectorEmitterReverse {

    public SelectorEmitterBlock(NSelector selector, String blockvar) {
        super(selector, blockvar, null);
    }

    @Override
    protected void emitDefinition(Streamer out) throws IOException {
        forEach(selector.getParams()).onHead(p -> out.append("(")).
                onTail(p -> out.append(", ")).
                onAny(p -> out.append(p.getNType().getNativeType()).append(" ").append(p.getVarname())).
                onLast(p -> out.append(") ")).
                go();
    }

    @Override
    protected void emitOpenBracket(Streamer out) throws IOException {
        out.append("{\n").tab();
    }

    @Override
    protected void emitCloseBracket(Streamer out) throws IOException {
        out.untab().append("}");
    }

}
