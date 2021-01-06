/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
