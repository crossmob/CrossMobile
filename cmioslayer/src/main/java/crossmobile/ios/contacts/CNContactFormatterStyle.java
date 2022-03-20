/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class CNContactFormatterStyle {

    public static final int CNContactFormatterStyleFullName = 0;
    public static final int CNContactFormatterStylePhoneticFullName = 1;

    private CNContactFormatterStyle() {
    }
}
