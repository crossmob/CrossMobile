/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.coregraphics;

import crossmobile.ios.foundation.CFType;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMFunction;
import org.crossmobile.bridge.ann.CMReference;

import java.io.IOException;
import java.io.InputStream;

/**
 * CGDataProvider class defines an object that is responsible for providing
 * graphics data to Quartz functions.
 */
@CMReference
public class CGDataProvider extends CFType {

    private final InputStream in;

    private CGDataProvider(InputStream in) {
        this.in = in;
    }

    /**
     * Returns the CGDataProvider for the specified path.
     *
     * @param path The path of the requested CGDataProvider.
     * @return The CGDataProvider of the specified path.
     */
    @CMFunction(" CGDataProviderRef CGDataProviderCreateWithFilename ( const char *filename ); ")
    public static CGDataProvider createWithFilename(String path) {
        CGDataProvider dp;
        try {
            return new CGDataProvider(Native.file().getFileStream(path));
        } catch (IOException ex) {
            Native.system().error("Unable to retrieve data provider " + path, ex);
        }
        return null;
    }
}
