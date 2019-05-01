/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.plugin.objc;

import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.utils.Statics;
import org.crossmobile.plugin.utils.Streamer;

import java.io.IOException;

import static org.crossmobile.plugin.utils.Texters.toObjC;
import static org.crossmobile.utils.NamingUtils.*;

public abstract class FileEmitter {

    protected final NObject obj;

    public FileEmitter(NObject obj) {
        this.obj = obj;
    }

    public void emitInfo(Streamer out) throws IOException {
        out.append(Statics.COPYRIGHT);
        out.append("// ").append(getClassNameBare(obj.getType())).append(" ").append(getFileType()).append("\n\n");
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
