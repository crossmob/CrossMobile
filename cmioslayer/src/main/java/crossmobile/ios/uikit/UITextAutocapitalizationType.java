/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITextAutocapitalizationType class defines different types of
 * auto-capitalization for text objects.
 */
@CMEnum
public final class UITextAutocapitalizationType {

    /**
     * Do not capitalize automatically.
     */
    public static final int None = 0;

    /**
     * Automatically capitalize only the first letter of each word.
     */
    public static final int Words = 1;

    /**
     * Automatically capitalize the first letter of the first word of the
     * sentence.
     */
    public static final int Sentences = 2;

    /**
     * Automatically capitalize all the letters.
     */
    public static final int AllCharacters = 3;

    private UITextAutocapitalizationType() {
    }
}
