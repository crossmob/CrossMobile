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


public class XibClassEnd extends Objects {

    @Override
    protected void addSupported() {

    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        out.append(I2).append("@Override").append(NEWLINE);
        out.append(I2).append("public UIViewController instantiateViewControllerWithIdentifier(String identifier) {").append(NEWLINE);
        out.append(I3).append("switch (identifier){").append(NEWLINE);
        for (String id : VCIDENT.keySet()) {
            out.append(I4).append("case \"").append(id).append("\":").append(NEWLINE);
            out.append(I5).append("return ").append("new ").append(VCIDENT.get(id)).append("();").append(NEWLINE);
        }
        out.append(I3).append("}").append(NEWLINE);
        out.append(I3).append("return null;").append(NEWLINE);
        out.append(I2).append("}").append(NEWLINE);
        out.append(I1).append("}").append(NEWLINE);
        VCIDENT.clear();
        return out.toString();
    }
}
