/*
 * (c) 2019 by Panayotis Katsaloulis
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
