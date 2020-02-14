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
