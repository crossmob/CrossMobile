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
