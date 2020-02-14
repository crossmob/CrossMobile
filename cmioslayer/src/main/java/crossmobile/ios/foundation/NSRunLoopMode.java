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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSRunLoopMode class defines different loop modes for the NSRunLoop.
 */
@CMEnum
public final class NSRunLoopMode {

    /**
     * The default loop mode for handling input sources.
     */
    public static final String Default = "NSDefaultRunLoopMode";

    /**
     * The loop mode for objects that belong to the common modes set.
     */
    public static final String Common = "NSRunLoopCommonModes";

    private NSRunLoopMode() {
    }

}
