/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
