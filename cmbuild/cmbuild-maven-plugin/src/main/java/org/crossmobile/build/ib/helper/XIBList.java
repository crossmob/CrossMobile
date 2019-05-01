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
 * You should have received attr copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.i18n.IBParserMeta;
import org.crossmobile.build.utils.Templates;

public class XIBList extends Element {
    public XIBList(IBParserMeta meta) {
        super(meta);
    }

    @Override
    protected void addSupported() {
        addSupportedChild(Elements.Objects);
        addSupportedChild(Elements.XibClassStart);
        addSupportedChild(Elements.XibClassEnd);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        out.append(Templates.AUTOGEN_TEMPLATE);
        out.append("package org.crossmobile.sys;").append(NEWLINE);
        out.append(NEWLINE);
        out.append("import crossmobile.ios.uikit.*;").append(NEWLINE);
        out.append("import crossmobile.ios.foundation.*;").append(NEWLINE);
        out.append("import crossmobile.ios.coregraphics.*;").append(NEWLINE);
        out.append("import java.util.*;").append(NEWLINE);
        out.append(NEWLINE);
        out.append("public class IBObjects {").append(NEWLINE);

        for (Objects item : parts(Elements.Objects))
            if (!item.filenameIsSet())
                out.append(item.toCode());
        for (Objects item : parts(Elements.Objects))
            if (item.filenameIsSet())
                out.append(item.toCode());
        out.append("}").append(NEWLINE);
        return out.toString();
    }

    public int countItems() {
        return parts(Elements.Objects).size();
    }


}
