/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIControlEvents class defines different types of events that can be related to
 * a control element.
 */
@CMEnum
public final class UIControlEvents {

    /**
     * The user touches down the element.
     */
    public static final int TouchDown = 1;

    /**
     * The user repeatedly touches down the element.
     */
    public static final int TouchDownRepeat = 1 << 1;

    /**
     * The user is dragging a finger inside the element.
     */
    public static final int TouchDragInside = 1 << 2;

    /**
     * The user is dragging a finger outside the element.
     */
    public static final int TouchDragOutside = 1 << 3;

    /**
     * The user is dragging a finger within the element.
     */
    public static final int TouchDragEnter = 1 << 4;

    /**
     * The user is dragging a finger outside the element.
     */
    public static final int TouchDragExit = 1 << 5;

    /**
     * The user touches up the element.
     */
    public static final int TouchUpInside = 1 << 6;

    /**
     * The user touches up outside the element.
     */
    public static final int TouchUpOutside = 1 << 7;

    /**
     * The system cancels current touches.
     */
    public static final int TouchCancel = 1 << 8;

    /**
     * There is a value change.
     */
    public static final int ValueChanged = 1 << 12;

    /**
     * The user started editing.
     */
    public static final int EditingDidBegin = 1 << 16;

    /**
     * The user made an editing change.
     */
    public static final int EditingChanged = 1 << 17;

    /**
     * The user stopped editing as touched outside the text field element.
     */
    public static final int EditingDidEnd = 1 << 18;

    /**
     * The editing finished as the user touched the back button.
     */
    public static final int EditingDidEndOnExit = 1 << 19;

    /**
     * The control element is related to all types of events.
     */
    public static final int AllTouchEvents = 0x00000FFF;

    /**
     * The text field element is related to all editing types.
     */
    public static final int AllEditingEvents = 0x000F0000;

    /**
     * The element is related to set of control events relevant to the
     * application.
     */
    public static final int ApplicationReserved = 0x0F000000;

    /**
     * The element is related to set of system control events.
     */
    public static final int SystemReserved = 0xF0000000;

    /**
     * The element is related to all events.
     */
    public static final int AllEvents = 0xFFFFFFFF;

    private UIControlEvents() {
    }
}
