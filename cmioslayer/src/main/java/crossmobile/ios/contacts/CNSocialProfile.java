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
import org.crossmobile.bridge.ann.CMGetter;

@CMClass
public class CNSocialProfile extends NSObject {

    private CNSocialProfile() {
    }

    public final static String CNSocialProfileURLStringKey = "";
    public final static String CNSocialProfileUsernameKey = "";
    public final static String CNSocialProfileUserIdentifierKey = "";
    public final static String CNSocialProfileServiceKey = "";

    public final static String CNSocialProfileServiceFacebook = "";
    public final static String CNSocialProfileServiceFlickr = "";

    private String service;
    private String urlString;
    private String username;
    private String userIdentifier;

    @CMGetter("@property(readonly, copy, nonatomic) NSString *service;")
    public String service() {
        return service;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *urlString;")
    public String urlString() {
        return urlString;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *userIdentifier;")
    public String userIdentifier() {
        return userIdentifier;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *username;")
    public String username() {
        return username;
    }

    @CMConstructor("- (instancetype)initWithUrlString:(NSString *)urlString \n"
            + "                         username:(NSString *)username \n"
            + "                   userIdentifier:(NSString *)userIdentifier \n"
            + "                          service:(NSString *)service;")
    public CNSocialProfile(String urlString, String username, String userIdentifier, String service) {
        this.service = service;
        this.urlString = urlString;
        this.username = username;
        this.userIdentifier = userIdentifier;

    }

}
