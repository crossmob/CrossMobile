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
package org.crossmobile.backend.android;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import org.crossmobile.bind.io.AbstractFileBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import static org.crossmobile.bind.system.SystemUtilities.URIEncode;
import static org.crossmobile.bind.system.SystemUtilities.closeR;

@CMLib(depends = @CMLibDepends(groupId = "androidx.core", pluginName = "core", version = "1.0.2", isCMPlugin = false))
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
        Class clazz;
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

        if (new File(path).exists())
            return true;

        if (path.startsWith(getApplicationPrefix())) {
            InputStream is = null;
            try {
                is = getApplicationFileStream(path.substring(getApplicationPrefix().length() + 1)); // remove '/' character
                return true;
            } catch (IOException ignore) {
            } finally {
                closeR(is);
            }
        }

        try {
            // URIEncode is needed here not before
            if (path.startsWith(getApplicationPrefix()))
                path = Native.file().getApplicationPrefix() + "/" + URIEncode(path.substring(getApplicationPrefix().length() + 1));
            else
                path = URIEncode(path);
            return new File(new URI(path)).exists();
        } catch (Exception ex) {
        }
        return false;
    }

    public static Uri getExternalUri(Uri fileUri) {
        return getExternalUri(new File(fileUri.getPath()));
    }

    public static Uri getExternalUri(File file) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.N
                ? Uri.fromFile(file)
                : FileProvider.getUriForFile(MainActivity.current, AndroidPermissions.current().getAuthority(), file);
    }
}
