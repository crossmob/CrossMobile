/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.images;

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.Log;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;

public class MetaImage {
    public final BufferedImage image;
    public final File file;
    public final int size;
    public final boolean resizable;

    // to mask:
    //        g.setComposite(AlphaComposite.DstIn); // otherwise SRC_IN

    MetaImage(int size) {
        image = null;
        file = null;
        resizable = false;
        this.size = size;
    }

    MetaImage(File imageFile) throws IOException {
        this(ImageIO.read(imageFile), imageFile, true);
    }

    MetaImage(InputStream is) throws IOException {
        this(ImageIO.read(is), null, true);
    }

    MetaImage(BufferedImage image) {
        this(image, null, true);
    }

    private MetaImage(BufferedImage image, File file, boolean resizable) {
        this.image = normalizeImage(image);
        this.size = image != null ? image.getWidth() : 0;
        this.file = file;
        this.resizable = resizable;
    }

    MetaImage resize(int size) {
        if (size == this.size)
            return this;
        if (image == null)
            return new MetaImage(size);
        BufferedImage result = makeImage(image, size, 0, 0, true);
        return new MetaImage(result, null, false);
    }

    public boolean save(File output) {
        if (image == null)
            return false;
        try {
            //noinspection ResultOfMethodCallIgnored
            output.getParentFile().mkdirs();
            ImageIO.write(image, "PNG", output);
            return true;
        } catch (IOException e) {
            Log.error("Unable to write image at " + output.getAbsolutePath());
        }
        return false;
    }

    private static BufferedImage normalizeImage(BufferedImage input) {
        if (input == null)
            return null;
        int width = input.getWidth();
        int height = input.getHeight();
        if (width > height)
            return makeImage(input, height, -(width - height) / 2, 0, false);
        else if (width < height)
            return makeImage(input, height, 0, -(height - width) / 2, false);
        else
            return input;
    }

    private static BufferedImage makeImage(BufferedImage input, int newSize, int dx, int dy, boolean fit) {
        BufferedImage destination = new BufferedImage(newSize, newSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = make(destination);
        if (fit)
            g.drawImage(input, dx, dy, newSize, newSize, null);
        else
            g.drawImage(input, dx, dy, null);
        g.dispose();
        return destination;
    }

    public boolean isValid() {
        return image != null;
    }

    public MetaImage withBackground(MetaImage background) {
        if (!isValid() || !background.isValid())
            BaseUtils.throwException(new InvalidObjectException("Image is not valid"));
        BufferedImage destination = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = make(destination);
        g.drawImage(background.image, (size - background.size) / 2, (size - background.size) / 2, null);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return new MetaImage(destination, null, false);
    }

    public MetaImage withCanvas(int canvasSize) {
        if (!isValid())
            return size == canvasSize ? this : new MetaImage(canvasSize);
        BufferedImage destination = new BufferedImage(canvasSize, canvasSize, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = make(destination);
        g.drawImage(image, (canvasSize - size) / 2, (canvasSize - size) / 2, null);
        g.dispose();
        return new MetaImage(destination, null, false);
    }

    private static Graphics2D make(BufferedImage image) {
        Graphics2D g2 = image.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        return g2;
    }

    public MetaImage asAlpha() {
        if (!isValid())
            return this;
        BufferedImage destination = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = make(destination);
        g.drawImage(image, 0, 0, null);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 1));
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size, size);
        g.dispose();
        return new MetaImage(destination, null, false);
    }
}
