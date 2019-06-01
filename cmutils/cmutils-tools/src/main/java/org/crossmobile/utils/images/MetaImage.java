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

    MetaImage(int size) {
        image = null;
        file = null;
        resizable = false;
        this.size = size;
    }

    public MetaImage(File imageFile) throws IOException {
        this(ImageIO.read(imageFile), imageFile, true);
    }

    public MetaImage(InputStream is) throws IOException {
        this(ImageIO.read(is), null, true);
    }

    private MetaImage(BufferedImage image, File file, boolean resizable) {
        this.image = normalizeImage(image);
        size = image != null ? image.getWidth() : 0;
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

    MetaImage crop(MetaImage crop) {
        if (image == null)
            return this;
        if (crop.isInvalid())
            BaseUtils.throwException(new InvalidObjectException("Selected crop image is not valid"));
        return new MetaImage(cropImage(image, crop.image), null, true);
    }

    public boolean save(File output) {
        if (image == null)
            return false;
        try {
            output.getParentFile().mkdirs();
            ImageIO.write(image, "PNG", output);
            return true;
        } catch (IOException e) {
            Log.error("Unable to write image at " + output.getAbsolutePath());
        }
        return false;
    }

    private static BufferedImage normalizeImage(BufferedImage input) {
        if(input == null)
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
        Graphics2D g2 = destination.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        if (fit)
            g2.drawImage(input, dx, dy, newSize, newSize, null);
        else
            g2.drawImage(input, dx, dy, null);
        g2.dispose();
        return destination;
    }

    private static BufferedImage cropImage(BufferedImage base, BufferedImage shape) {
        int width = base.getWidth();
        int height = base.getHeight();
        BufferedImage out;
        out = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = out.createGraphics();
        g.drawImage(base, 0, 0, null);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        g.setComposite(AlphaComposite.DstIn);
        g.drawImage(shape, 0, 0, width, height, null);
        g.dispose();
        return out;
    }

    public boolean isInvalid() {
        return image == null;
    }
}
