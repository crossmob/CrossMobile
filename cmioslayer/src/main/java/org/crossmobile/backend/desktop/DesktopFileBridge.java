/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import org.crossmobile.bind.io.AbstractFileBridge;
import org.crossmobile.bridge.Native;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.crossmobile.bridge.system.RuntimeCommons.CROSSMOBILE_PROPERTIES;
import static org.crossmobile.bridge.system.RuntimeCommons.MATERIALS_TAG;

public class DesktopFileBridge extends AbstractFileBridge {

    public static final String APPRESOURCE = "/org/crossmobile/" + MATERIALS_TAG + "/app/";
    private static final String SYSRESOURCE = "/org/crossmobile/" + MATERIALS_TAG + "/sys/";
    private static final String APP_SIG = CROSSMOBILE_PROPERTIES;
    private static final String SYS_SIG = "empty.png";

    private static String homepath;
    private static String apref;
    private static String spref;

    @Override
    protected String getHomePath() {
        if (homepath == null) {
            switch (OperatingSystem.current) {
                case MacOSX:
                    homepath = System.getProperty("user.home") + "/Library/Application Support/CrossMobile/Applications/";
                    break;
                case Windows:
                    homepath = System.getenv("APPDATA") + "\\CrossMobile\\Applications\\";
                    break;
                default:
                    homepath = System.getProperty("user.home") + "/.local/share/crossmobile/applications/";
            }
            homepath += Native.system().bundleID();
        }
        return homepath;
    }

    @Override
    public InputStream getApplicationFileStream(String file) throws IOException {
        return getClass().getResourceAsStream(APPRESOURCE + file);
    }

    public InputStream getSystemFileStream(String file) throws IOException {
        return getClass().getResourceAsStream(SYSRESOURCE + file);
    }

    @Override
    public String getApplicationPrefix() {
        if (apref == null)
            try {
                apref = getClass().getResource(APPRESOURCE + APP_SIG).toString();
                apref = apref.substring(0, apref.length() - APP_SIG.length() - 1);
            } catch (Exception ex) {
                apref = "crossmobile.app://";
            }
        return apref;
    }

    @Override
    public String getSystemPrefix() {
        if (spref == null)
            try {
                spref = getClass().getResource(SYSRESOURCE + SYS_SIG).toString();
                spref = spref.substring(0, spref.length() - SYS_SIG.length());
            } catch (Exception ex) {
                spref = "crossmobile.sys://";
            }
        return spref;
    }

    @Override
    public boolean fileExists(String path) {
        if (path == null)
            return false;
        else if (path.startsWith(File.separator))
            return new File(path).exists();
        else if (path.startsWith(getApplicationPrefix()))
            return path.equals(getApplicationPrefix()) ||
                    getClass().getResource(APPRESOURCE + path.substring(apref.length() + 1)) != null;
        else if (path.startsWith(getSystemPrefix()))
            return getClass().getResource(SYSRESOURCE + path.substring(spref.length() + 1)) != null;
        return new File(path).exists();
    }
}
