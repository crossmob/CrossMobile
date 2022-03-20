/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIEventSubtype class defines the subtype of an event.
 */
@CMEnum
public final class UIEventSubtype {

    /**
     * The event has no subtype.
     */
    public static final int None = 0;

    /**
     * The event is a subtype of Motion type and is related to device shaking.
     */
    public static final int MotionShake = 1;

    /**
     * The event is a remote control event.
     */
    public static final int RemoteControl = 2;

    /**
     * The event is a subtype of RemoteControl type and is related to audio or
     * video playing.
     */
    public static final int RemoteControlPlay = 100;

    /**
     * The event is a subtype of RemoteControl type and is related to audio or
     * video pausing.
     */
    public static final int RemoteControlPause = 101;

    /**
     * The event is a subtype of RemoteControl type and is related to audio or
     * video stopping.
     */
    public static final int RemoteControlStop = 102;

    /**
     * The event is a subtype of RemoteControl type and is related to switching
     * between stopping and playing audio or video.
     */
    public static final int RemoteControlTogglePlayPause = 103;

    /**
     * The event is a subtype of RemoteControl type and is related to next audio
     * or video track playing.
     */
    public static final int RemoteControlNextTrack = 104;

    /**
     * The event is a subtype of RemoteControl type and is related to previous
     * audio or video track playing.
     */
    public static final int RemoteControlPreviousTrack = 105;

    /**
     * The event is a subtype of RemoteControl type and is related to start
     * searching backward audio or video tracks.
     */
    public static final int RemoteControlBeginSeekingBackward = 106;

    /**
     * The event is a subtype of RemoteControl type and is related to stop
     * searching backward audio or video tracks.
     */
    public static final int RemoteControlEndSeekingBackward = 107;

    /**
     * The event is a subtype of RemoteControl type and is related to start
     * searching forward audio or video tracks.
     */
    public static final int RemoteControlBeginSeekingForward = 108;

    /**
     * The event is a subtype of RemoteControl type and is related to stop
     * searching forward audio or video tracks.
     */
    public static final int RemoteControlEndSeekingForward = 109;

    private UIEventSubtype() {
    }

}
