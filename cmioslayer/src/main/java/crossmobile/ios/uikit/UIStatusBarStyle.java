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
 * UIStatusBarStyle class defines the style of the status bar.
 */
@CMEnum
public final class UIStatusBarStyle {

    /**
     * The status bar has the default dark style used mainly with light
     * backgrounds.
     */
    public static final int Default = 0;

    /**
     * The status bar has light style used mainly with dark backgrounds.
     */
    public static final int LightContent = 1;

    private UIStatusBarStyle() {
    }
}
