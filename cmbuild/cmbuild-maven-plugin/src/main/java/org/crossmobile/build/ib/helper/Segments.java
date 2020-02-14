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
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Elements;

public class Segments extends RealElement {

    @Override
    protected void addSupported() {
        addSupportedChild(Elements.Segment);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder("Arrays.asList(new Object[]{");
        String comma = "";
        for (Segment segment : parts(Elements.Segment)) {
            out.append(comma).append(NEWLINE).append(I5).append(segment.toCode());
            comma = ",";
        }
        out.append(NEWLINE).append(I4).append("})");
        return out.toString();
    }
}
