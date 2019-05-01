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

import org.crossmobile.bridge.ann.CMEnum;

/**
 * ACAccountTypeIdentifier class defines different types of social media
 * accounts.
 */
@CMEnum
public final class ACAccountTypeIdentifier {

    /**
     * Facebook account.
     */
    public static final String Facebook = "com.apple.facebook";

    /**
     * Twitter account.
     */
    public static final String Twitter = "com.apple.twitter";

    /**
     * Sina Weibo account.
     */
    public static final String SinaWeibo = "com.apple.sinaweibo";

    private ACAccountTypeIdentifier() {
    }
}
