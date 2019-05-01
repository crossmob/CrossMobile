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
 * ACFacebookAudience class defines different options related to Facebook
 * account's privacy.
 */
@CMEnum
public final class ACFacebookAudience {

    /**
     * Visible to everyone.
     */
    public static final String Everyone = "everyone";

    /**
     * Visible only to friends.
     */
    public static final String Friends = "friends";

    /**
     * Visible only to the user.
     */
    public static final String OnlyMe = "me";

    private ACFacebookAudience() {
    }
}
