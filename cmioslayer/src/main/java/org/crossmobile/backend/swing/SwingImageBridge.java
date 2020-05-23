/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import org.crossmobile.backend.desktop.DesktopImageBridge;
import org.crossmobile.bind.graphics.NativeBitmap;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SwingImageBridge extends DesktopImageBridge {

    @Override
    protected NativeBitmap bufferedToNative(BufferedImage img) {
        return img == null ? null : new SwingBitmap(img);
    }

    @Override

    protected BufferedImage nativeToBuffered(NativeBitmap bitmap) {
        return bitmap == null ? null : ((SwingBitmap) bitmap).img;
    }

    @Override
    public NativeBitmap create(int width, int height) {
        return new SwingBitmap(GFXCONF.createCompatibleImage(width, height, Transparency.TRANSLUCENT));
    }
}
