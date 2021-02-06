/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.resolver;

import org.crossmobile.backend.avian.NativeAvian;
import org.crossmobile.bridge.Native;

public class AvianBridgeResolver {

    /**
     * Test if runtime is on Avian. When this class is loaded it will throw an exception if NativeAvian is missing.
     *
     * @return true if run under Avian
     * @throws Exception if it isn't run under Avian
     */
    public static boolean isActive() throws Exception {
        return true;
    }

    public static Native resolve() {
        return new NativeAvian();
    }
}
