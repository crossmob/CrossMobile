/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIEventType class defines the type of an event.
 */
@CMEnum
public final class UIEventType {

    /**
     * The event is a touch event.
     */
    public static final int Touches = 0;

    /**
     * The event movement event.
     */
    public static final int Motion = 1;

    /**
     * The event is related to a remote control event.
     */
    public static final int RemoteControl = 2;

    private UIEventType() {
    }

}
