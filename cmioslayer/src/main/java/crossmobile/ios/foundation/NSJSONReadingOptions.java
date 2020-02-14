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
 * NSJSONReadingOptions class defines different options to use when Foundation
 * instances are created from JSON data.
 */
@CMEnum
public final class NSJSONReadingOptions {

    /**
     * The objects created are mutable containers.
     */
    public static final int MutableContainers = 1;

    /**
     * Leaf string of the JSON object graph are NSMutable Strings.
     */
    public static final int MutableLeaves = 2;

    /**
     * Top level objects that are not NSArray or NSDictionary instances are
     * allowed.
     */
    public static final int AllowFragments = 4;

    private NSJSONReadingOptions() {
    }
}
