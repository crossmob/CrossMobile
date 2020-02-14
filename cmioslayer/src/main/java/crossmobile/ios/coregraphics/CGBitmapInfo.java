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
package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGBitmapInfo class defines different bitmap encodings concerning the
 * CGBitmapContext objects.
 */
@CMEnum
public final class CGBitmapInfo {

    /**
     * The image has an alpha channel.
     */
    public static final int AlphaInfoMask = 0x1F;

    /**
     * Bitmap's components are floating point values.
     */
    public static final int FloatComponents = (1 << 8);

    /**
     * The byte ordering.
     */
    public static final int ByteOrderMask = 0x7000;

    /**
     * The default byte order.
     */
    public static final int ByteOrderDefault = (0 << 12);

    /**
     * 16-bit little endian.
     */
    public static final int ByteOrder16Little = (1 << 12);

    /**
     * 32-bit little endian.
     */
    public static final int ByteOrder32Little = (2 << 12);

    /**
     * 16-bit, big endian.
     */
    public static final int ByteOrder16Big = (3 << 12);

    /**
     * 32-bit big endian.
     */
    public static final int ByteOrder32Big = (4 << 12);

    private CGBitmapInfo() {
    }
}
