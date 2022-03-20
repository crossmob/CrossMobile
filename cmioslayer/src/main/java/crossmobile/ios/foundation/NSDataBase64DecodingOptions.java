/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSDataBase64DecodingOptions class defines decoding options used for NSData
 * objects that are Base-64 encoded.
 */
@CMEnum
public final class NSDataBase64DecodingOptions {

    /**
     * Unknown non Base-64 and line ending characters are ignored.
     */
    public static final int IgnoreUnknownCharacters = 1;

    private NSDataBase64DecodingOptions() {
    }

}
