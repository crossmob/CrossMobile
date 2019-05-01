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

import org.crossmobile.bind.io.AbstractNetworkBridge;
import org.crossmobile.bind.io.NativeCookieManager;
import org.crossmobile.bridge.Native;

import java.awt.*;
import java.io.File;
import java.net.URI;

public class DesktopNetworkBridge extends AbstractNetworkBridge {

    public DesktopNetworkBridge() {
    }

    @Override
    @SuppressWarnings({"UseSpecificCatch"})
    public boolean openURL(String url) {
        Desktop desktop = Desktop.getDesktop();
        try {
            URI uri = URI.create(url);
            if (url.startsWith("mailto:"))
                desktop.mail(uri);
            else
                desktop.browse(uri);
        } catch (Exception ex) {
            try {
                desktop.open(new File(url));
            } catch (Exception ex1) {
                Native.system().error("Unable to open URL " + url, ex);
                return false;
            }
        }
        return true;
    }

    @Override
    public NativeCookieManager initNativeManager() {
        // Use platform's default cookie manager
        return null;
    }

}
