/*
 * (c) 2022 by Panayotis Katsaloulis
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

    /**
     * Test if runtime is on Android. When this class is loaded it might throw an exception if NativeAndroid is missing.
     *
     * @return true if run under Android, or false otherwise
     * @throws Exception might be thrown if it isn't run under Android
     */
    public static boolean isActive() throws Exception {
        return System.getProperty("java.vm.specification.vendor", "").toLowerCase().contains("android")
                || System.getProperty("java.vm.vendor.url", "").toLowerCase().contains("android")
                || System.getProperty("java.vendor.url", "").toLowerCase().contains("android")
                || System.getProperty("java.vm.name", "").toLowerCase().contains("dalvik")
                || System.getProperty("java.specification.name", "").toLowerCase().contains("dalvik")
                || System.getProperty("java.vm.specification.name", "").toLowerCase().contains("dalvik");
    }
}
