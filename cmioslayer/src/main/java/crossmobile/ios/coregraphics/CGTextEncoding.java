/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGTextEncoding class different types of text encodings for fonds.
 */
@CMEnum
public final class CGTextEncoding {

    /**
     * Built-in font encoding.
     */
    public static final int FontSpecific = 0;

    /**
     * Mac Roman encoding.
     */
    public static final int MacRoman = 1;

    private CGTextEncoding() {
    }
}
