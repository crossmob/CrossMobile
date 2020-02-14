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

import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class ObjectEmitter {

    private final NObject obj;

    public ObjectEmitter(NObject obj) {
        this.obj = obj;
    }

    public void emit(Streamer header, Streamer body, Streamer swift, boolean asImportHeaders, String... imports) throws IOException {
        emit(header, body, swift, null, asImportHeaders, imports);
    }

    public void emit(Streamer header, Streamer body, Streamer swift, String[] filter, boolean asImportHeaders, String... imports) throws IOException {
        new HeaderEmitter(obj, asImportHeaders, imports).emit(header);
        if (!obj.getType().isInterface() && body != null)
            new BodyEmitter(obj).emit(body, swift, filter);
    }

}
