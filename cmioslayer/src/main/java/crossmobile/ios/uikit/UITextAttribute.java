/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITextAttribute class defines different types of attributes for text objects.
 */
@CMEnum
public final class UITextAttribute {

    /**
     * The font of a text object.
     */
    public static final String Font = "Font";

    /**
     * The color of the text.
     */
    public static final String TextColor = "TextColor";

    /**
     * The color of the shadow for the text.
     */
    public static final String TextShadowColor = "TextShadowColor";

    /**
     * The offset used for the text shadow.
     */
    public static final String TextShadowOffset = "TextShadowOffset";

    private UITextAttribute() {
    }

}
