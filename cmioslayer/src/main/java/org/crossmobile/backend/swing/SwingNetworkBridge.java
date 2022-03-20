/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import org.crossmobile.bind.io.AbstractNetworkBridge;
import org.crossmobile.bind.io.NativeCookieManager;
import org.crossmobile.bridge.Native;

import java.awt.Desktop;
import java.io.File;
import java.net.URI;

public class SwingNetworkBridge extends AbstractNetworkBridge {

    public SwingNetworkBridge() {
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
