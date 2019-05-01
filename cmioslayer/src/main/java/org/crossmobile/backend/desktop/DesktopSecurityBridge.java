/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
