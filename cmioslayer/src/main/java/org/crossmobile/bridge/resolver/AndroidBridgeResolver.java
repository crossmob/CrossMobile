/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.resolver;

import org.crossmobile.backend.android.NativeAndroid;
import org.crossmobile.bridge.Native;

public class AndroidBridgeResolver {

    public static Native resolve() {
        return new NativeAndroid();
    }
}
