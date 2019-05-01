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
package crossmobile.ios.accounts;

import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * ACAccountCredential class defines an object that represents the information
 * related to user authentication.
 */
@CMClass
public class ACAccountCredential extends NSObject {

    private String oauthToken;

    /**
     * Initializes an ACAccountCredential object with the specified client
     * application tokens.
     *
     * @param token  The client application’s token.
     * @param secret The client application’s secret token.
     */
    @CMConstructor("- (instancetype)initWithOAuthToken:(NSString *)token \n"
            + "                       tokenSecret:(NSString *)secret;")
    public ACAccountCredential(String token, String secret) {
    }

    /**
     * Initializes an ACAccountCredential object with the specified client
     * application tokens and expiry date.
     *
     * @param token        The client application’s token.
     * @param refreshToken The client application’s refresh token.
     * @param expiryDate   The expiry date.
     */
    @CMConstructor("- (instancetype)initWithOAuth2Token:(NSString *)token \n"
            + "                       refreshToken:(NSString *)refreshToken \n"
            + "                         expiryDate:(NSDate *)expiryDate;")
    public ACAccountCredential(String token, String refreshToken, NSDate expiryDate) {
    }

    /**
     * Returns a token that is used for the credential.
     *
     * @return A token that is used for the credential.
     */
    @CMGetter("@property(copy, nonatomic) NSString *oauthToken;")
    public String oauthToken() {
        return oauthToken;
    }

    /**
     * Sets the token that is used for the credential.
     *
     * @param oauthToken The token that is used for the credential.
     */
    @CMSetter("@property(copy, nonatomic) NSString *oauthToken;")
    public void setOauthToken(String oauthToken) {
        this.oauthToken = oauthToken;
    }
}
