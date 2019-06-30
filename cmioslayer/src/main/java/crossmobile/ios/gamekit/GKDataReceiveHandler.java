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

import crossmobile.ios.foundation.NSData;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMTarget;

/**
 * GKDataReceiveHandler interface specifies the handler that is called when data
 * that is sent from other peers is received during a session.
 */
@CMTarget
public interface GKDataReceiveHandler {

    /**
     * It is used when data that is sent by other peers within the specified session is received.
     *
     * @param data    That data that is received.
     * @param peer    The sender of the data.
     * @param session The current session.
     * @param context The session context.
     */
    @CMSelector("- (void) receiveData:(NSData *) data fromPeer:(NSString *) peer inSession: (GKSession *) session context:(void *) context ;")
    public abstract void receiveData(NSData data, String peer, GKSession session, Object context);
}
