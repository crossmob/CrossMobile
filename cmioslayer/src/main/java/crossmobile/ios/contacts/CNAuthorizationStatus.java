/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class CNAuthorizationStatus {

    public static final int NotDetermined = 0;
    public static final int Restricted = 1;
    public static final int Denied = 2;
    public static final int Authorized = 3;

    private CNAuthorizationStatus() {
    }
}
