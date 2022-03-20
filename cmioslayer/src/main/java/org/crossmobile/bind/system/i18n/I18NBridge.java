/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system.i18n;

import crossmobile.ios.foundation.NSBundle;
import org.crossmobile.bind.system.i18n.I18NSelf.NumberTest;

public class I18NBridge {

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
