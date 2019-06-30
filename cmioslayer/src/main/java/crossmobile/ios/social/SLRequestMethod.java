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
package crossmobile.ios.social;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * SLRequestMethod class defines different types of HTTP request methods.
 */
@CMEnum
public final class SLRequestMethod {

    /**
     * Used in order to get data from the server and only the URL with headers
     * are sent to the server.
     */
    public static final int GET = 0;

    /**
     * Used in order to send data to the server such as to upload a file, or
     * submit a completed form.
     */
    public static final int POST = 1;

    /**
     * Deletes the identified resource.
     */
    public static final int DELETE = 2;

    private SLRequestMethod() {
    }
}
