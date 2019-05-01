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
