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
