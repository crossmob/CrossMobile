/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;

@CMClass
public class CNPhoneNumber extends NSObject {

    private String stringValue;

    @CMConstructor("- (instancetype)initWithStringValue:(NSString *)string;")
    public CNPhoneNumber(String value) {
        this.stringValue = value;
    }
}
