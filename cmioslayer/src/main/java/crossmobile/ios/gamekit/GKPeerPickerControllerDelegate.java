/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package crossmobile.ios.gamekit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * GKPeerPickerControllerDelegate interface is the delegate that cooperates with
 * GKPeerPickerController objects.
 */
@CMClass
public interface GKPeerPickerControllerDelegate {

    /**
     * It is used when the user selects a connection type.
     *
     * @param p1 The GKPeerPickerController that corresponds to this delegate.
     * @param p2 The connection type that the user selected.
     */
    @CMSelector("- (void)peerPickerController:(GKPeerPickerController *)picker \n"
            + "     didSelectConnectionType:(GKPeerPickerConnectionType)type;")
    default void didSelectConnectionType(GKPeerPickerController p1, int p2) {
    }

    /**
     * It is used in order to return the session of the specified connection
     * type.
     *
     * @param p1 The GKPeerPickerController that corresponds to this delegate.
     * @param p2 The connection type for which the session is requested.
     * @return The session of the specified connection type.
     */
    @CMSelector("- (GKSession *)peerPickerController:(GKPeerPickerController *)picker \n"
            + "           sessionForConnectionType:(GKPeerPickerConnectionType)type;")
    default GKSession sessionForConnectionType(GKPeerPickerController p1, int p2) {
        return null;
    }

    /**
     * It is used after a peer is connected to the session.
     *
     * @param p1 The GKPeerPickerController that corresponds to this delegate.
     * @param p2 The id of the peer that is connected.
     * @param p3 The session to which the peer is connected.
     */
    @CMSelector("- (void)peerPickerController:(GKPeerPickerController *)picker \n"
            + "              didConnectPeer:(NSString *)peerID \n"
            + "                   toSession:(GKSession *)session;")
    default void didConnectPeer(GKPeerPickerController p1, String p2, GKSession p3) {
    }

    /**
     * It is used after user's cancellation of connection attempt.
     *
     * @param p1 The GKPeerPickerController that corresponds to this delegate.
     */
    @CMSelector("- (void)peerPickerControllerDidCancel:(GKPeerPickerController *)picker;")
    default void didCancel(GKPeerPickerController p1) {
    }
}
