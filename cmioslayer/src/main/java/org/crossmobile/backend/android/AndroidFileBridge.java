/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import org.crossmobile.bind.io.AbstractFileBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import static org.crossmobile.bind.system.SystemUtilities.URIEncode;

@CMLib(depends = @CMLibDepends(groupId = "androidx.core", pluginName = "core", version = "1.3.0"))
public class AndroidFileBridge extends AbstractFileBridge {

    private static String homepath;
    static final String APPLICATION_PREFIX = "file:///android_asset";

    @Override
    protected String getHomePath() {
        if (homepath == null) {
            File hpFile = MainActivity.current.getExternalFilesDir(null);
//            hpFile = AndroidGraphicsBridge.context.getFilesDir();
            if (hpFile == null) {
                Native.lifecycle().quit("An external storage device is required to start this application.\nPlease append the storage device and start again", null);
                return null;
            }
            homepath = hpFile.getAbsolutePath();
        }
        return homepath;
    }

    @SuppressWarnings("UseSpecificCatch")
    public static int getResourceID(String type, String item) {
        Class<?> clazz;
        Context cxt = MainActivity.current;
        if (cxt == null)
            return errorIfFatal("Resource can not be loaded, because context is not yet initialized");

        String resourceDir = cxt.getPackageName() + ".R$" + type;
        try {
            clazz = Class.forName(resourceDir);
        } catch (ClassNotFoundException ex) {
            return errorIfFatal("Resource directory not found " + type + " for class " + resourceDir);
        }

        try {
            return ((Integer) clazz.getField(item).get(null));
        } catch (Exception ex) {
            return errorIfFatal("Resource item not found " + type + "/" + item + " for class " + resourceDir);
        }
    }

    private static int errorIfFatal(String error) {
        AndroidSystemBridge.printError("*** FATAL ERROR *** " + error, null);
        return 0;
    }

    @Override
    public String getApplicationPrefix() {
        return APPLICATION_PREFIX;
    }

    @Override
    public String getSystemPrefix() {
        return "android.assets://";
    }

    @Override
    public InputStream getApplicationFileStream(String file) throws IOException {
        return MainActivity.current.getAssets().open(file);
    }

    @Override
    @SuppressWarnings("UseSpecificCatch")
    public boolean fileExists(String path) {
        if (path == null)
            return false;
        // Full file path
        if (new File(path).exists())
            return true;
        // Not under assets folder -- we don't support this
        if (!path.startsWith(APPLICATION_PREFIX))
            return false;
        // File is the root of the assets folder
        if (path.equals(APPLICATION_PREFIX))
            return true;
        // Clean path from assets folder
        path = path.substring(APPLICATION_PREFIX.length() + 1);
        // File is still the root of the assets folder
        if (path.isEmpty())
            return true;
        // Path refers to a file
        try (InputStream ignored = getApplicationFileStream(path)) {
            return true;
        } catch (IOException ignored) {
        }
        // Path refers to a folder (with content)
        try {
            if (MainActivity.current.getAssets().list(path).length > 0)
                return true;
        } catch (Exception ignored) {
        }
        // Last resort: try the URIEncode method
        try {
            return new File(new URI(APPLICATION_PREFIX + "/" + URIEncode(path))).exists();
        } catch (Exception ignored) {
        }
        return false;
    }

    public static Uri getExternalUri(Uri fileUri) {
        return getExternalUri(new File(fileUri.getPath()));
    }

    public static Uri getExternalUri(File file) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.N
                ? Uri.fromFile(file)
                : CMFileProvider.getUriForFile(MainActivity.current, AndroidPermissions.current().getAuthority(), file);
    }
}
