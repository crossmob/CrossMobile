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
