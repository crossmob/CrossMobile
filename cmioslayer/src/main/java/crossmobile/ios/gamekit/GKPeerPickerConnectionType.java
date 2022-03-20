/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.gamekit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * GKPeerPickerConnectionType class defines different types of network
 * connections.
 */
@CMEnum
public final class GKPeerPickerConnectionType {

    /**
     * Internet connection.
     */
    public static final int Online = 1;

    /**
     * Bluetooth connection.
     */
    public static final int Nearby = 2;

    private GKPeerPickerConnectionType() {
    }
}
