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
package org.crossmobile.backend.android;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import org.crossmobile.bind.io.AbstractFileBridge;
import org.crossmobile.bridge.Native;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import static org.crossmobile.backend.android.AndroidPermissions.getAuthority;
import static org.crossmobile.bind.system.SystemUtilities.URIEncode;
import static org.crossmobile.bind.system.SystemUtilities.closeR;

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
        if (cxt == null) {
            System.err.println("Resource can not be loaded, because context is not yet initialized");
            return 0;
        }

        try {
            clazz = Class.forName(cxt.getPackageName() + ".R$" + type);
        } catch (ClassNotFoundException ex) {
            System.err.println("Resource directory not found: " + type);
            return 0;
        }

        try {
            return ((Integer) clazz.getField(item).get(null));
        } catch (Exception ex) {
            System.err.println("Resource item not found: " + type + "/" + item);
            return 0;
        }
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
                : FileProvider.getUriForFile(MainActivity.current, getAuthority(), file);
    }
}
