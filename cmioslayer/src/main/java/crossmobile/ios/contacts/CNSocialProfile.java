/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
