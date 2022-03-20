/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.resolver;

import org.crossmobile.backend.swing.NativeSwing;
import org.crossmobile.bridge.Native;

public class SwingBridgeResolver {

    public static Native resolve() {
        return new NativeSwing();
    }
}
