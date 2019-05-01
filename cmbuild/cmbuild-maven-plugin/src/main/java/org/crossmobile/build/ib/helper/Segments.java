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
