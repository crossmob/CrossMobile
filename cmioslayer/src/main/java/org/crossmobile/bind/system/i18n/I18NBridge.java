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
