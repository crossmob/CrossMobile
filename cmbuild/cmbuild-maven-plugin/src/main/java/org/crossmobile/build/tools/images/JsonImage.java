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
package org.crossmobile.build.tools.images;

import java.io.File;

public class JsonImage {
    private final String idiom;
    private final String scale;
    private final String size;
    private String filename = "";

    private JsonImage(String... attribute) {
        this.idiom = (attribute[0] == null) ? "" : attribute[0];
        this.size = (attribute[1] == null) ? "" : attribute[1];
        this.scale = (attribute[2] == null) ? "" : attribute[2];
    }

    public JsonImage(File icon) {
        this(icon.getName().toLowerCase().substring(5, icon.getName().length() - ".png".length()).split("_"));
        filename = icon.getName();
    }

    public boolean isSet() {
        return !filename.equals("");
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("  ").append("{").append("\n");
        if (!idiom.equals(""))
            out.append("    ").append("\"idiom\"").append(" : ").append("\"").append(idiom).append("\"").append(",\n");
        if (!filename.equals(""))
            out.append("    ").append("\"filename\"").append(" : ").append("\"").append(filename).append("\"").append(",\n");
        if (!size.equals(""))
            out.append("    ").append("\"size\"").append(" : ").append("\"").append(size).append("\"").append(",\n");
        if (!scale.equals(""))
            out.append("    ").append("\"scale\"").append(" : ").append("\"").append(scale).append("\"").append(",\n");
        out.delete(out.length() - 2, out.length() - 1);
        out.append("  ").append("}");
        return out.toString();
    }
}
