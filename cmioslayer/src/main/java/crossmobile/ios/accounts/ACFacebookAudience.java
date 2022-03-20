/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
