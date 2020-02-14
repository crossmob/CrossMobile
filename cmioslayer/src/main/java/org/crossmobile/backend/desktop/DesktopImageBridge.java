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
package org.crossmobile.backend.desktop;

import crossmobile.ios.coregraphics.$coregraphics;
import crossmobile.ios.coregraphics.CGImage;
import org.crossmobile.bind.graphics.AbstractImageBridge;
import org.crossmobile.bind.graphics.ImageBridgeConstants.ImageType;
import org.crossmobile.bind.graphics.NativeBitmap;
import org.crossmobile.bridge.Native;
import org.robovm.objc.block.VoidBlock1;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import static org.crossmobile.bind.system.SystemUtilities.closeR;

public abstract class DesktopImageBridge extends AbstractImageBridge {

    public static final String DESKTOPICONS = "/org/crossmobile/backend/desktop/icons/";
    public static final String DESKTOPSKIN = "/org/crossmobile/backend/desktop/skin/";
    protected static final GraphicsConfiguration GFXCONF = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    protected static FileDialog fd;

    protected abstract NativeBitmap bufferedToNative(BufferedImage img);

    protected abstract BufferedImage nativeToBuffered(NativeBitmap bitmap);

    private NativeBitmap loadFromStreamAndClose(InputStream in) {
        if (in == null)
            throw new NullPointerException("Input stream could not be null");
        try {
            in = new BufferedInputStream(in);
            BufferedImage img = ImageIO.read(in);
            if (img != null && !img.getColorModel().equals(GFXCONF.getColorModel())) {
                // Create compatible image for faster performance
                BufferedImage comp = GFXCONF.createCompatibleImage(img.getWidth(), img.getHeight(), img.getTransparency());
                Graphics2D g2d = (Graphics2D) comp.getGraphics();
                g2d.drawImage(img, 0, 0, null);
                g2d.dispose();
                img = comp;
            }
            return bufferedToNative(img);
        } catch (IOException ex) {
            return null;
        } finally {
            closeR(in);
        }
    }

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
    public void fillStreamAndClose(NativeBitmap in, ImageType type, double quality, OutputStream out) throws IOException {
        BufferedImage bi = nativeToBuffered(in);
        if (out == null)
            throw new NullPointerException("Output stream could not be null");
        try {
            if (!ImageIO.write(bi, type.name().toLowerCase(), out))
                throw new IOException("Unable to store image");
        } finally {
            closeR(out);
        }
    }

    @Override
    public NativeBitmap stretch(NativeBitmap in, int top, int right, int bottom, int left, int reqX, int reqY) {
        BufferedImage bi = nativeToBuffered(in);
        int origX = bi.getWidth();
        int origY = bi.getHeight();

        BufferedImage out = GFXCONF.createCompatibleImage(reqX, reqY, bi.getTransparency());
        Graphics2D gfx = out.createGraphics();

        gfx.drawImage(bi, 0, 0, left, top, 0, 0, left, top, null);
        gfx.drawImage(bi, reqX - right, 0, reqX, top, origX - right, 0, origX, top, null);
        gfx.drawImage(bi, 0, reqY - bottom, left, reqY, 0, origY - bottom, left, origY, null);
        gfx.drawImage(bi, reqX - right, reqY - bottom, reqX, reqY, origX - right, origY - bottom, origX, origY, null);

        gfx.drawImage(bi, left, 0, reqX - right, top, left, 0, origX - right, top, null);
        gfx.drawImage(bi, left, reqY - bottom, reqX - right, reqY, left, origY - bottom, origX - right, origY, null);
        gfx.drawImage(bi, 0, top, left, reqY - bottom, 0, top, left, origY - bottom, null);
        gfx.drawImage(bi, reqX - right, top, reqX, reqY - bottom, origX - right, top, origX, origY - bottom, null);

        gfx.drawImage(bi, left, top, reqX - right, reqY - bottom, left, top, origX - right, origY - bottom, null);

        gfx.dispose();
        return bufferedToNative(out);
    }

    @Override
    public NativeBitmap adjustColor(NativeBitmap in, double saturation, double brightness) {
        BufferedImage bi = nativeToBuffered(in);
        if (saturation < 0)
            saturation = 0;
        if (saturation > 1)
            saturation = 1;
        if (brightness < 0)
            brightness = 0;
        int width = bi.getWidth();
        int height = bi.getHeight();
        BufferedImage out = GFXCONF.createCompatibleImage(width, height, bi.getTransparency());
        int red, green, blue, alpha, pixel;
        double average_percent;
        double inv_sat_bright_percent = (1 - saturation) * brightness / 3f;
        double sat_brightness = saturation * brightness;
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                pixel = bi.getRGB(x, y);
                alpha = pixel & 0xFF000000;
                red = (pixel >>> 16) & 0xFF;
                green = (pixel >>> 8) & 0xFF;
                blue = pixel & 0xFF;
                average_percent = (red + green + blue) * inv_sat_bright_percent;
                red = (int) (red * sat_brightness + average_percent);
                green = (int) (green * sat_brightness + average_percent);
                blue = (int) (blue * sat_brightness + average_percent);
                if (red > 255)
                    red = 255;
                if (green > 255)
                    green = 255;
                if (blue > 255)
                    blue = 255;
                out.setRGB(x, y, alpha | (red << 16) | (green << 8) | blue);
            }
        return bufferedToNative(out);
    }

    @Override
    public NativeBitmap masked(NativeBitmap in, int color) {
        BufferedImage bi = nativeToBuffered(in);
        BufferedImage out = GFXCONF.createCompatibleImage(bi.getWidth(), bi.getHeight(), bi.getTransparency());
        Graphics2D g2 = out.createGraphics();
        Native.graphics().newGraphicsContext(g2, false).setAntialias(true);
        g2.drawImage(bi, 0, 0, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_IN, 1));
        g2.setColor(new Color(color, true));
        g2.fillRect(0, 0, bi.getWidth(), bi.getHeight());
        g2.dispose();
        return bufferedToNative(out);
    }

    @Override
    public boolean supportsCamera(ImageSource source) {
        return true;
    }

    @Override
    public void requestCamera(VoidBlock1<CGImage> resultImg) {
        requestPhotoAlbum(resultImg);
    }

    @Override
    public void requestPhotoAlbum(VoidBlock1<CGImage> resultImg) {
        if (resultImg == null)
            return;
        if (fd == null) {
            fd = new FileDialog((Frame) null, "Please select an image", FileDialog.LOAD);
            fd.setDirectory(System.getProperty("user.home"));
            fd.setFilenameFilter((dir, name) -> {
                name = name.toLowerCase();
                return name.endsWith(".png") ||
                        name.endsWith(".jpg") ||
                        name.endsWith(".jpeg") ||
                        name.endsWith(".bmp");
            });
            fd.setMultipleMode(false);
        }
        fd.setFile("*.jpg;*.jpeg;*.png;*.bmp");
        fd.setVisible(true);
        File[] files = fd.getFiles();
        CGImage cgimage = files != null && files.length > 0 ? $coregraphics.cgimage(files[0].getAbsolutePath(), null) : null;
        resultImg.invoke(cgimage);
    }
}
