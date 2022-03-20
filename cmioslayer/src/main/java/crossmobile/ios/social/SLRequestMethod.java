/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
