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
