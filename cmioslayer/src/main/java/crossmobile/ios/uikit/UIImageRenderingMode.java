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
 * UIImageResizingMode class defines different types of rendering the color of
 * an image.
 */
@CMEnum
public final class UIImageRenderingMode {

    /**
     * Automatically select the color of the image
     */
    public static final int Automatic = 0;
    /**
     * Use only original colors
     */
    public static final int AlwaysOriginal = 1;
    /**
     * Use only tinted colors
     */
    public static final int AlwaysTemplate = 2;

    private UIImageRenderingMode() {
    }
}
