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
