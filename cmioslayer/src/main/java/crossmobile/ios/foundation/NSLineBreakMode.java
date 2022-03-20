/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSLineBreakMode class defines different line break styles to apply when a
 * line is longer its container.
 */
@CMEnum
public final class NSLineBreakMode {

    /**
     * The line is wrapped so that words are displayed unaltered.
     */
    public static final int ByWordWrapping = 0;

    /**
     * The line wrapped before the first character that doesn't fit.
     */
    public static final int ByCharWrapping = 1;

    /**
     * Draws line only within the text container.
     */
    public static final int ByClipping = 2;

    /**
     * The end of the line is displayed.
     */
    public static final int ByTruncatingHead = 3;

    /**
     * The beginning of the line is displayed.
     */
    public static final int ByTruncatingTail = 4;

    /**
     * The beginning and the end of the line is displayed.
     */
    public static final int ByTruncatingMiddle = 5;

    private NSLineBreakMode() {
    }
}
