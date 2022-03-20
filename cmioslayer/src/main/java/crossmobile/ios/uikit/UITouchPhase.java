/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITouchPhase class defines the phase of a UITouch object.
 */
@CMEnum
public final class UITouchPhase {

    /**
     * A finger touched the screen.
     */
    public static final int Began = 0;

    /**
     * A finger that has touched the screen moved.
     */
    public static final int Moved = 1;

    /**
     * A finger that has touched the screen stays motionless.
     */
    public static final int Stationary = 2;

    /**
     * A finger that has touched the screen was just lifted from the screen.
     */
    public static final int Ended = 3;

    /**
     * The screen touched the ear or chick and the system recognized it and
     * stopped tracking this touch object.
     */
    public static final int Cancelled = 4;

    private UITouchPhase() {
    }
}
