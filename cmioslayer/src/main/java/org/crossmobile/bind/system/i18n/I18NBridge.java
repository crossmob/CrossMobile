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
package org.crossmobile.bind.system.i18n;

import crossmobile.ios.foundation.NSBundle;
import org.crossmobile.bind.system.i18n.I18NSelf.NumberTest;

public class I18NBridge {

    public static final boolean I18N_SUPPORT;

    static {
        boolean check = false;
        try {
            I18N.ping();
            check = true;
        } catch (NoClassDefFoundError ignore) {
        }
        I18N_SUPPORT = check;
    }

    public static String localizedString(NSBundle bundle, String key, String table) {
        return I18N.localizedString(bundle, key, table);
    }

    public static String retrieveFormat(String format, NumberTest few, NumberTest many, Object[] args) {
        I18N.StringsDict retrieved = I18N.StringsDict.retrieve(format);
        if (retrieved != null)
            format = retrieved.getFormat(few, many, args);
        return format;
    }
}
