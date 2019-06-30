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
package org.crossmobile.bridge;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static org.crossmobile.bind.system.SystemUtilities.closeR;

public interface FileBridge {

    InputStream getFileStream(String file) throws IOException;

    default void deleteRecursive(File f) {
        if (f.exists()) {
            File[] list = f.listFiles();
            if (list != null)
                for (File c : list)
                    deleteRecursive(c);
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
