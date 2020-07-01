/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.uikit.UIAlertView;
import org.crossmobile.bridge.SystemBridge;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static org.crossmobile.bind.system.i18n.I18NSelf.ℑ;


public abstract class DesktopSystemBridge implements SystemBridge {

    private static final PrintWriter error = new PrintWriter(new OutputStreamWriter(System.err, StandardCharsets.UTF_8));

    @Override
    public void error(String message, Throwable th) {
        if (message != null)
            error.println(message);
        if (th != null)
            th.printStackTrace(error);
        error.flush();
    }

    @Override
    public void debug(String message, Throwable th) {
        if (Debug)
            error(message, th);
    }

    @Override
    public String version() {
        return "1";
    }

    @Override
    public String model() {
        return "Desktop";
    }

    @Override
    public void setKeyboardVisibility(boolean status) {
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean launchPhoneCall(String phone) {
        new UIAlertView(ℑ("Unsupported protocol"), ℑ("Unable to use phone service") + "\n" + ℑ("Number:") + phone, null, ℑ("Acknowledge")).show();
        return false;
    }
}
