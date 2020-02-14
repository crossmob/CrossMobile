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
 * UIStackViewDistribution class defines different layout styles for the views
 * within the stack view, in the direction of the axis of the stack.
 */
@CMEnum
public final class UIStackViewDistribution {

    /**
     * The views increase their size in order to fill the available size in the
     * direction of the stack view axis.
     */
    public final static int Fill = 0;

    /**
     * The views increase their size in order to fill the available size in the
     * direction of the stack view axis. The views finally have the same size in
     * this direction.
     */
    public final static int FillEqually = 1;

    /**
     * The views increase their size proportionally in order to fill the
     * available size in the direction of the stack view axis.
     */
    public final static int FillProportionally = 2;

    /**
     * The views are moved within the stack so that they fill the available
     * space in the direction of the stack axis and is finally achieved equal
     * distance between successive views.
     */
    public final static int EqualSpacing = 3;

    /**
     * The views are moved within the stack in the direction of the stack view
     * axis so that is achieved equal distance between the line
     * symmetry(vertical to stack view axis) of successive views.
     */
    public final static int EqualCentering = 4;

    private UIStackViewDistribution() {
    }

}
