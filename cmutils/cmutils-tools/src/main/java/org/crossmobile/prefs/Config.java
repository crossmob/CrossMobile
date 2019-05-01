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
package org.crossmobile.prefs;

import static org.crossmobile.bridge.system.MaterialsCommon.MATERIALS_TAG;

public class Config {

    /**
     * Should finish with path, to denote the contents of this location. Use
     * instead of File.separator, since this could be a (multi-platform)
     * property.
     */
    public final static String MATERIALS_PATH = "src/main/" + MATERIALS_TAG + "/"; // Should finish with path, to denote the contents of this location.
    public final static String ICONS = "src/main/icons/"; // Should finish with path, to denote the contents of this location.
    public static String[] EXCEPTIONS = new String[]{"cross_screensize"};
}
