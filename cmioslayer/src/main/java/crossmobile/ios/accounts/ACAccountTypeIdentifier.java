/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
