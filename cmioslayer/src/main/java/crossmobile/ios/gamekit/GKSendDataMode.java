/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.gamekit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * GKSendDataMode class defines different options concerning the reliability of
 * data transmission to other peers.
 */
@CMEnum
public final class GKSendDataMode {

    /**
     * Data is sent consecutively until it is received successfully by the
     * receivers.
     */
    public static final int Reliable = 0;

    /**
     * Data is sent once regardless any error occurrence.
     */
    public static final int Unreliable = 1;

    private GKSendDataMode() {
    }
}
