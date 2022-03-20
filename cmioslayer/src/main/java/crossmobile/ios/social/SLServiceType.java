/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.social;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * SLServiceType class defines different values concerning the social service
 * type.
 */
@CMEnum
public final class SLServiceType {

    /**
     * The value that corresponds to Facebook social network.
     */
    public static final String Facebook = "com.apple.social.facebook";

    /**
     * The value that corresponds to Twitter social network.
     */
    public static final String Twitter = "com.apple.social.twitter";

    /**
     * The value that corresponds to Sina Weibo social network.
     */
    public static final String SinaWeibo = "com.apple.social.sinaweibo";

    private SLServiceType() {
    }
}
