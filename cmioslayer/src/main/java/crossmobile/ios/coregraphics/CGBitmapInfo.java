/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
