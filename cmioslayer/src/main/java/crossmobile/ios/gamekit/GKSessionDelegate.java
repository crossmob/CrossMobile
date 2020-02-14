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

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMParamMod;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * GKSessionDelegate interface is the delegate that cooperates with the
 * GKSession objects.
 */
@CMClass
public interface GKSessionDelegate {

    /**
     * It is used when GKSession in case of an error.
     *
     * @param p1 The GKSession that corresponds to this delegate.
     * @param p2 The error that occurred.
     */
    @CMSelector("- (void)session:(GKSession *)session \n"
            + "didFailWithError:(NSError *)error;")
    void didFailWithError(GKSession p1, NSError p2);

    /**
     * It is used when a peer changes state.
     *
     * @param p1 The GKSession that corresponds to this delegate.
     * @param p2 The peer that changed state.
     * @param p3 The new state of the peer.
     */
    @CMSelector("- (void)session:(GKSession *)session\n"
            + "           peer:(NSString *)peerID\n"
            + " didChangeState:(GKPeerConnectionState)state")
    void peerDidChangeState(GKSession p1, String p2, @CMParamMod(concatName = true) int p3);

    /**
     * It is used when a remote peer request connection to the GKSession.
     *
     * @param p1 The GKSession that corresponds to this delegate.
     * @param p2 The remote peer that requests connection.
     */
    @CMSelector("- (void)session:(GKSession *)session \n"
            + "didReceiveConnectionRequestFromPeer:(NSString *)peerID;")
    void didReceiveConnectionRequestFromPeer(GKSession p1, String p2);

    /**
     * It is after a failure to connect to another peer. failed.
     *
     * @param p1 The GKSession that corresponds to this delegate.
     * @param p2 The peer to which connection attempt failed.
     * @param p3 The error that occurred.
     */
    @CMSelector("- (void)session:(GKSession *)session \n"
            + "connectionWithPeerFailed:(NSString *)peerID \n"
            + "      withError:(NSError *)error;")
    void connectionWithPeerFailed(GKSession p1, String p2, NSError p3);
}
