/*
 * (c) 2019 by Panayotis Katsaloulis
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

public class I18NTest {

    // It needs to be on it's own class, for obfuscating rasons
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
}
