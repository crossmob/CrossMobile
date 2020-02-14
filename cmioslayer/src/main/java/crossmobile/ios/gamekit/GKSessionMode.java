/*
 * (c) 2020 by Panayotis Katsaloulis
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
