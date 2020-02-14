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
 * UIUserInterfaceIdiom class defines the type of user interface that should
 * be designed for the device.
 */
@CMEnum
public final class UIUserInterfaceIdiom {

    /**
     * The user interface should be designed for iPhone.
     */
    public static final int Phone = 0;

    /**
     * The user interface should be designed for iPad.
     */
    public static final int Pad = 1;

    private UIUserInterfaceIdiom() {
    }
}
