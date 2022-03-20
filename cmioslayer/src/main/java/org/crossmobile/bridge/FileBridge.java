/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.crossmobile.bind.system.SystemUtilities.closeR;
import static org.crossmobile.bridge.system.BaseUtils.listFiles;

public interface FileBridge {

    InputStream getFileStream(String file) throws IOException;

    default void deleteRecursive(File f) {
        if (f.exists()) {
            for (File c : listFiles(f))
                deleteRecursive(c);
            //noinspection ResultOfMethodCallIgnored
            f.delete();
        }
    }

    default void copyStreamAndClose(InputStream in, OutputStream out, int bufferSize) {
        try {
            byte[] buffer = new byte[bufferSize];
            int howMany;
            while ((howMany = in.read(buffer)) > 0)
                out.write(buffer, 0, howMany);
        } catch (IOException ex) {
            Native.system().error("Unable to copy stream", ex);
        } finally {
            closeR(in);
            closeR(out);
        }
    }

    String getTemporaryLocation();

    default boolean isTemporaryLocation(String filename) {
        return filename != null && filename.startsWith(getTemporaryLocation());
    }

    String getRandomLocation();

    String getSystemCacheLocation();

    String getHomeLocation();

    /**
     * @return Should have "/"
     */
    String getSystemPrefix();

    /**
     * @return Should not have "/"
     */
    String getApplicationPrefix();

    /*
     * Only full path files and application files. Not System files.
     */
    boolean fileExists(String path);
}
