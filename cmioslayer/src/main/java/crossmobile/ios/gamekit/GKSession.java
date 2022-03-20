/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.gamekit;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSObject;
import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.List;

/**
 * GKSession class defines an object that provides Bluetooth or Wi-fi connection
 * to other devices.
 */
@CMClass
@Deprecated
public class GKSession extends NSObject {

    private GKSessionDelegate delegate;
    private boolean available = false;
    private final String displayName;
    private String peerID;
    private final String sessionID;
    private final int sessionMode;
    private double disconnectTimeout;

    /**
     * Constructs a GKSession object with the specified values.
     *
     * @param sessionID     The id of the GKSession.
     * @param displayName   The name of the GKSession.
     * @param GKSessionMode The mode of the GKSession.
     * @see crossmobile.ios.gamekit.GKSessionMode
     */
    @Deprecated
    @CMConstructor("- (id)initWithSessionID:(NSString *)sessionID \n"
            + "            displayName:(NSString *)name \n"
            + "            sessionMode:(GKSessionMode)mode;")
    public GKSession(String sessionID, String displayName, int GKSessionMode) {
        this.sessionID = sessionID;
        this.displayName = displayName;
        this.sessionMode = GKSessionMode;
    }

    /**
     * Returns the delegate of this GKSession.
     *
     * @return The delegate of this GKSession.
     */
    @Deprecated
    @CMGetter("@property(assign) id<GKSessionDelegate> delegate;")
    public GKSessionDelegate delegate() {
        return delegate;
    }

    /**
     * Sets the specified delegate for this GKSession.
     *
     * @param delegate The delegate of this GKSession.
     */
    @Deprecated
    @CMSetter("@property(assign) id<GKSessionDelegate> delegate;")
    public void setDelegate(GKSessionDelegate delegate) {
        this.delegate = delegate;
    }

    /**
     * Returns a Boolean that shows whether this GKSession is available to
     * connect to new peers.
     *
     * @return TRUE then this GKSession is available to connect to new peers.
     */
    @Deprecated
    @CMGetter("@property(getter=isAvailable) BOOL available;")
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets a Boolean that defines whether this GKSession is available to
     * connect to new peers.
     *
     * @param available TRUE then this GKSession will be available to connect to
     *                  new peers.
     */
    @Deprecated
    @CMSetter("@property(getter=isAvailable) BOOL available;")
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Returns the delay time until this GKSession quits a peer that does not
     * respond.
     *
     * @return The delay time until this GKSession quits a peer that does not
     * respond.
     */
    @Deprecated
    @CMGetter("@property(assign) NSTimeInterval disconnectTimeout;")
    public double disconnectTimeout() {
        return disconnectTimeout;
    }

    /**
     * Sets the delay time until this GKSession quits a peer that does not
     * respond.
     *
     * @param disconnectTimeout The delay time until this GKSession quits a peer
     *                          that does not respond.
     */
    @Deprecated
    @CMSetter("@property(assign) NSTimeInterval disconnectTimeout;")
    public void setDisconnectTimeout(double disconnectTimeout) {
        this.disconnectTimeout = disconnectTimeout;
    }

    /**
     * Returns the name of the user.
     *
     * @return The name of the user.
     */
    @Deprecated
    @CMGetter("@property(readonly) NSString *displayName;")
    public String displayName() {
        return displayName;
    }

    /**
     * Returns the id of this GKSession.
     *
     * @return The id of this GKSession.
     */
    @Deprecated
    @CMGetter("@property(readonly) NSString *peerID;")
    public String peerID() {
        return peerID;
    }

    /**
     * Returns an id used for approving peers.
     *
     * @return An id used for approving peers.
     */
    @Deprecated
    @CMGetter("@property(readonly) NSString *sessionID;")
    public String sessionID() {
        return sessionID;
    }

    /**
     * Returns the mode of the session.
     *
     * @return The mode of the session.
     */
    @Deprecated
    @CMGetter("@property(readonly) GKSessionMode sessionMode;")
    public int sessionMode() {
        return sessionMode;
    }

    /**
     * Returns a list with the specified connection state peers.
     *
     * @param GKPeerConnectionState The state for which the peers are requested.
     * @return A list with the specified connection state peers.
     */
    @Deprecated
    @CMSelector("- (NSArray *)peersWithConnectionState:(GKPeerConnectionState)state;")
    public List<String> peersWithConnectionState(int GKPeerConnectionState) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the name of the specified peer.
     *
     * @param peerID The id of the peer for whose name is requested.
     * @return The name of the specified peer.
     */
    @Deprecated
    @CMSelector("- (NSString *)displayNameForPeer:(NSString *)peerID;")
    public String displayNameForPeer(String peerID) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Connects to the specified peer.
     *
     * @param peerID  The peer to which a connection is attempted.
     * @param timeout The amount of time before aborting the connection attempt.
     */
    @Deprecated
    @CMSelector("- (void)connectToPeer:(NSString *)peerID \n"
            + "          withTimeout:(NSTimeInterval)timeout;")
    public void connectToPeer(String peerID, double timeout) {
        Native.system().notImplemented();
    }

    /**
     * Aborts connection attempt to the specified peer.
     *
     * @param peerID The peer to which attempt of connection is aborted.
     */
    @Deprecated
    @CMSelector("- (void)cancelConnectToPeer:(NSString *)peerID;")
    public void cancelConnectToPeer(String peerID) {
        Native.system().notImplemented();
    }

    /**
     * Accepts connection from the specified peer.
     *
     * @param peerID The peer which requests connection.
     * @param error  The error that occurs in case of failure.
     * @return TRUE if the connection was successful.
     */
    @Deprecated
    @CMSelector("- (BOOL)acceptConnectionFromPeer:(NSString *)peerID \n"
            + "                           error:(NSError **)error;")
    public boolean acceptConnectionFromPeer(String peerID, StrongReference<NSError> error) {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Cancels connection by the specified peer.
     *
     * @param peerID The peer whose attempt to connect is canceled.
     */
    @Deprecated
    @CMSelector("- (void)denyConnectionFromPeer:(NSString *)peerID;\n"
            + "")
    public void denyConnectionFromPeer(String peerID) {
        Native.system().notImplemented();
    }

    /**
     * Sets the handler of the data that other peers sent.
     *
     * @param handler The handler of the data that other peers sent.
     * @param context Data to the handler.
     */
    @Deprecated
    @CMSelector("- (void)setDataReceiveHandler:(id)handler \n"
            + "                  withContext:(void *)context;")
    public void setDataReceiveHandler(GKDataReceiveHandler handler, Object context) {
        Native.system().notImplemented();
    }

    /**
     * Sends the specified data to all the connected peers of the list.
     *
     * @param data           The data to be sent.
     * @param peers          The list of the connected peers to which the data is send.
     * @param GKSendDataMode The reliability used during sending the data.
     * @param error          The error that occurs in case of failure.
     * @return TRUE if the data was successfully sent.
     */
    @Deprecated
    @CMSelector("- (BOOL)sendData:(NSData *)data \n"
            + "         toPeers:(NSArray *)peers \n"
            + "    withDataMode:(GKSendDataMode)mode \n"
            + "           error:(NSError **)error;")
    public boolean sendData(NSData data, List<String> peers, int GKSendDataMode, StrongReference<NSError> error) {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Sends the specified data to all the connected peers
     *
     * @param data           The data to be sent.
     * @param GKSendDataMode The reliability used during sending the data.
     * @param error          The error that occurs in case of failure.
     * @return TRUE if the data was successfully sent.
     */
    @Deprecated
    @CMSelector("- (BOOL)sendDataToAllPeers:(NSData *)data \n"
            + "              withDataMode:(GKSendDataMode)mode \n"
            + "                     error:(NSError **)error;")
    public boolean sendDataToAllPeers(NSData data, int GKSendDataMode, StrongReference<NSError> error) {
        Native.system().notImplemented();
        return false;
    }

    /**
     * Disconnects from all connected peers.
     */
    @Deprecated
    @CMSelector("- (void)disconnectFromAllPeers;")
    public void disconnectFromAllPeers() {
        Native.system().notImplemented();
    }

    /**
     * Disconnects the specified connected peer.
     *
     * @param peerID The id of the peer to disconnect.
     */
    @Deprecated
    @CMSelector("- (void)disconnectPeerFromAllPeers:(NSString *)peerID;")
    public void disconnectPeerFromAllPeers(String peerID) {
        Native.system().notImplemented();
    }
}
