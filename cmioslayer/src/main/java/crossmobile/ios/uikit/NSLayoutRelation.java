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
 * NSLayoutRelation class defines equality relation between the initial and the
 * modified attribute of a constraint.
 */
@CMEnum
public final class NSLayoutRelation {

    /**
     * The initial attribute has to be less than or equal to modified one.
     */
    public static final int LessThanOrEqual = -1;

    /**
     * The attributes are equal.
     */
    public static final int RelationEqual = 0;

    /**
     * The initial attribute has to be greater than or equal to modified one.
     */
    public static final int GreaterThanOrEqual = 1;

    private NSLayoutRelation() {
    }
}
