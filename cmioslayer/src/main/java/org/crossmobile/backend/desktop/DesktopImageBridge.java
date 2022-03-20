/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.coregraphics.CGImage;
import org.crossmobile.bind.graphics.AbstractImageBridge;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.robovm.objc.block.VoidBlock1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public abstract class DesktopImageBridge extends AbstractImageBridge {

    protected abstract NativeBitmap loadFromStreamAndClose(InputStream in);

    @Override
    public NativeBitmap retrieve(String filename) {
        if (filename == null)
            throw new NullPointerException("File name could not be null");
        File file = new File(filename);
        if (file.exists() && file.isFile())
            try {
                return loadFromStreamAndClose(new FileInputStream(file));
            } catch (IOException ex) {
                return null;
            }
        else
            try {
                return loadFromStreamAndClose(new URL(filename).openStream());
            } catch (IOException ex) {
                return null;
            }
    }

    @Override
    public boolean supportsCamera(ImageSource source) {
        return true;
    }

    @Override
    public void requestCamera(VoidBlock1<CGImage> resultImg) {
        requestPhotoAlbum(resultImg);
    }

}
