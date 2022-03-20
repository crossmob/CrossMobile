/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UILayoutConstraintAxis class defines which axis is being constrained
 * concerning flow layouts.
 */
@CMEnum
public final class UILayoutConstraintAxis {

    /**
     * This constraint is applied to the horizontal axis.
     */
    public final static int Horizontal = 0;

    /**
     * This constraint is applied to the vertical axis.
     */
    public final static int Vertical = 1;

    private UILayoutConstraintAxis() {
    }
}
