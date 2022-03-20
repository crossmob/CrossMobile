/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class CNContainerType {

    public final static int local = 0;
    public final static int exchange = 2;
    public final static int cardDAV = 3;

    private CNContainerType() {
    }
}
