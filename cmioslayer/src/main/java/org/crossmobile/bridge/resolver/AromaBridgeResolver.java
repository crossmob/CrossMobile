/*
 * (c) 2021 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.resolver;

import org.crossmobile.backend.aroma.NativeAroma;
import org.crossmobile.bridge.Native;

public class AromaBridgeResolver {

    /**
     * Test if runtime is on Aroma. When this class is loaded it will throw an exception if NativeAroma is missing.
     *
     * @return true if run under Aroma
     * @throws Exception if it isn't run under Aroma
     */
    public static boolean isActive() throws Exception {
        return !System.getProperty("avian.version", "").isEmpty();
    }

    public static Native resolve() {
        return new NativeAroma();
    }
}
