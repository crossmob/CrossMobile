/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.accounts;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * ACFacebook class defines different dictionary keys related to requests for
 * Facebook accounts.
 */
@CMEnum
public final class ACFacebook {

    /**
     * The Facebook id of the application on the website.
     */
    public static final String AppIdKey = "ACFacebookAppIdKey";

    /**
     * The id for request permissions.
     */
    public static final String PermissionsKey = "ACFacebookPermissionsKey";

    /**
     * The id for posting request permissions.
     */
    public static final String AudienceKey = "ACFacebookAudienceKey";

    private ACFacebook() {
    }
}
