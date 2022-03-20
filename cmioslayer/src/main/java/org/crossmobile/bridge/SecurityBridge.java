/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.touchid.LAContext;
import crossmobile.rt.StrongReference;
import org.robovm.objc.block.VoidBlock2;

public interface SecurityBridge {

    boolean supportsFingerprint(StrongReference<NSError> error);

    void requestFingerprint(VoidBlock2<Boolean, NSError> callback, LAContext context);
}
