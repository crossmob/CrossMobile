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
package org.crossmobile.gui.codehound.source;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SourcePatternFactory {

    private final static SourcePattern MAIN_PATTERN = new SourcePattern("Main", false, "publicstaticvoidmain", "staticpublicvoidmain");

    public static Set<SourcePattern> getMainClassPattern() {
        return new HashSet<>(Arrays.asList(MAIN_PATTERN.duplicate()));
    }

}
