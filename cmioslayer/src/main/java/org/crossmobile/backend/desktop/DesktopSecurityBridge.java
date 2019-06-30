/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
        Native.lifecycle().notImplemented();
    }

}
