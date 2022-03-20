/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class CNContactFormatter extends NSObject {

    private CNContactFormatterStyle style;

    @CMSelector("+ (NSString *)stringFromContact:(CNContact *)contact \n"
            + "                          style:(CNContactFormatterStyle)style;")
    public static String stringFromContact(CNContact contact, int style) {
        return contact.toString();

    }

}
