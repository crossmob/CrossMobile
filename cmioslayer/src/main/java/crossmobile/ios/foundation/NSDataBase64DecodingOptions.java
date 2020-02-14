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
