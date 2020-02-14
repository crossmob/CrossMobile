/*
 * (c) 2020 by Panayotis Katsaloulis
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
