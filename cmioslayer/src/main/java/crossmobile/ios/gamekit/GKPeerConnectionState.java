/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.gamekit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * GKPeerConnectionState class defines different states concerning peers of a
 * session.
 */
@CMEnum
public final class GKPeerConnectionState {

    /**
     * The peer is not connected but is available.
     */
    public static final int Available = 0;

    /**
     * The peer is unavailable.
     */
    public static final int Unavailable = 1;

    /**
     * The peer is connected to the session.
     */
    public static final int Connected = 2;

    /**
     * The peer is disconnected from the session.
     */
    public static final int Disconnected = 3;

    /**
     * The peer is attempting to connect to the session.
     */
    public static final int Connecting = 4;

    private GKPeerConnectionState() {
    }
}
