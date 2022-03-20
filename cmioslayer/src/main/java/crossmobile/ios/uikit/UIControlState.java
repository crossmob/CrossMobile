/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIControlState class defines different types of states for a UIControl
 * concerning the appearance and the ability to interact.
 */
@CMEnum
public final class UIControlState {

    /**
     * The default state of a control.
     */
    public static final int Normal = 0;

    /**
     * TThe control element is highlighted state after a touch
     */
    public static final int Highlighted = 1;

    /**
     * The control element is in disabled state.
     */
    public static final int Disabled = 2;

    /**
     * The control element is in selected state.
     */
    public static final int Selected = 4;

    /**
     * The control element is in application reversed state.
     */
    public static final int ApplicationReserved = 0x00FF0000;

    /**
     * The control element is in reversed state.
     */
    public static final int Reserved = 0xFF000000;
    //
    final static int MASK = Highlighted | Disabled | Selected;
    final static byte NOGHOST = -1;

    private UIControlState() {
    }
}
