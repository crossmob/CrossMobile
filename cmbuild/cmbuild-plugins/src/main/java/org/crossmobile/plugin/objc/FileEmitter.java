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
import org.crossmobile.plugin.utils.Statics;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;

import static org.crossmobile.utils.NamingUtils.toObjC;
import static org.crossmobile.utils.NamingUtils.*;

public abstract class FileEmitter {

    protected final NObject obj;

    public FileEmitter(NObject obj) {
        this.obj = obj;
    }

    public void emitInfo(Streamer out) throws IOException {
        out.append(Statics.COPYRIGHT);
        out.append("// ").append(toObjC(obj.getType())).append(" ").append(getFileType()).append("\n\n");
    }

    public void emitEnd(Streamer out, boolean extraSpace) throws IOException {
        out.append("@end\n");
        if (extraSpace)
            out.append("\n");
    }

    public abstract String getFileType();

    protected String simpleName() {
        return getClassNameSimple(obj.getType());
    }

    protected String fullName() {
        return fullName(obj.getType());
    }

    protected String fullName(Class cls) {
        return toObjC(getClassNameFull(cls));
    }

}
