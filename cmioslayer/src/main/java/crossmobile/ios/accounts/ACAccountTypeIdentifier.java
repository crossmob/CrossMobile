/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
