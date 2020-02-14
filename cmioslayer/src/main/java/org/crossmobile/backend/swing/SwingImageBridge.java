/*
 * (c) 2020 by Panayotis Katsaloulis
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
