/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class CNContactProperty extends NSObject {

    private CNContact contact;
    private String key;
    private NSObject value;
    private String label;
    private String identifier;

    @CMGetter("@property(readonly, copy, nonatomic) CNContact *contact;")
    public CNContact contact() {
        return contact;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *key;")
    public String key() {
        return key;
    }

    @CMGetter("@property(readonly, nonatomic) id value;")
    public NSObject value() {
        return value;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *label;")
    public String label() {
        return label;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

}
