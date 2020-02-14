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
