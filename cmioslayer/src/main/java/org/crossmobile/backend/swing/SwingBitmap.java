/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.uikit.UIImageOrientation;
import org.crossmobile.bind.graphics.NativeBitmap;

import java.awt.image.BufferedImage;

public class SwingBitmap implements NativeBitmap {

    final BufferedImage img;

    public SwingBitmap(BufferedImage img) {
        this.img = img;
    }

    @Override
    public int getWidth() {
        return img.getWidth();
    }

    @Override
    public int getHeight() {
        return img.getHeight();
    }

    @Override
    public int getOrientation() {
        return UIImageOrientation.Up;
    }

}
