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
public class CNContactRelation extends NSObject {

    private String name;

    public static final String CNLabelContactRelationFather = "";
    public static final String CNLabelContactRelationMother = "";
    public static final String CNLabelContactRelationParent = "";
    public static final String CNLabelContactRelationBrother = "";
    public static final String CNLabelContactRelationSister = "";
    public static final String CNLabelContactRelationChild = "";
    public static final String CNLabelContactRelationFriend = "";
    public static final String CNLabelContactRelationSpouse = "";
    public static final String CNLabelContactRelationPartner = "";
    public static final String CNLabelContactRelationAssistant = "";
    public static final String CNLabelContactRelationManager = "";

    //Na exetastei 
    @CMConstructor("- (instancetype)initWithName:(NSString *)name;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public CNContactRelation(String name) {
        super();
        this.name = name;

    }
}
