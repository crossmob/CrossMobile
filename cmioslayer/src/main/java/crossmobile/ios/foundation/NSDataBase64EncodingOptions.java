/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSDataBase64EncodingOptions class defines encoding options used for encoding
 * NSData objects with Base-64.
 */
@CMEnum
public final class NSDataBase64EncodingOptions {

    /**
     * The maximum length of a line is 64 characters and then a line ending
     * character is inserted.
     */
    public static final int _64CharacterLineLength = 1;

    /**
     * The maximum length of a line is 76 characters and then a line ending
     * character is inserted.
     */
    public static final int _76CharacterLineLength = 1 << 1;

    /**
     * There is a carriage return in the line ending.
     */
    public static final int EndLineWithCarriageReturn = 1 << 4;

    /**
     * There is a line feed in the line ending.
     */
    public static final int EndLineWithLineFeed = 1 << 5;

    private NSDataBase64EncodingOptions() {
    }

}
