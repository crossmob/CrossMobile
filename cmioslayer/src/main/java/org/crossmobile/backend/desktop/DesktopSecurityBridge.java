/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.touchid.LAContext;
import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.SecurityBridge;
import org.robovm.objc.block.VoidBlock2;

public class DesktopSecurityBridge implements SecurityBridge {

    @Override
    public boolean supportsFingerprint(StrongReference<NSError> error) {
        return false;
    }

    @Override
    public void requestFingerprint(VoidBlock2<Boolean, NSError> callback, LAContext context) {
        Native.system().notImplemented();
    }

}
