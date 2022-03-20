/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
    @SuppressWarnings("deprecation")
    @CMSelector("- (void) receiveData:(NSData *) data fromPeer:(NSString *) peer inSession: (GKSession *) session context:(void *) context ;")
    void receiveData(NSData data, String peer, GKSession session, Object context);
}
