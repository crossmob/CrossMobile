/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.gamekit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * GKSessionMode class defines different options concerning the session mode.
 */
@CMEnum
public final class GKSessionMode {

    /**
     * The session is acting as a server.
     */
    public static final int Server = 0;

    /**
     * The session is acting as a client.
     */
    public static final int Client = 1;

    /**
     * The session is acting as a peer.
     */
    public static final int Peer = 2;

    private GKSessionMode() {
    }
}
