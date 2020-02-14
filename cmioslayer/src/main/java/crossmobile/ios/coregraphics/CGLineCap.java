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
package crossmobile.ios.coregraphics;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * CGLineCap class defines different styles of ending points of lines.
 */
@CMEnum
public final class CGLineCap {

    /**
     * The line's tail is squared-cut.
     */
    public static final int Butt = 0;

    /**
     * The line's tail is rounded.
     */
    public static final int Round = 1;

    /**
     * The line's tail is squared.
     */
    public static final int Square = 2;

    private CGLineCap() {
    }
}
