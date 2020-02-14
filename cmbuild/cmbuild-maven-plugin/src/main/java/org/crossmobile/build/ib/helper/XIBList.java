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
 * You should have received attr copy of the GNU General Public License
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
