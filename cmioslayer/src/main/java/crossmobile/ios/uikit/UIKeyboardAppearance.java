/*
 * (c) 2019 by Panayotis Katsaloulis
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
 * UIKeyboardAppearance specifies the appearance of a keyboard.
 */
@CMEnum
public final class UIKeyboardAppearance {

    /**
     * The default appearance.
     */
    public static final int Default = 0;

    /**
     * The appearance suitable for an alert panel.
     */
    public static final int Alert = 1;

    private UIKeyboardAppearance() {
    }
}
