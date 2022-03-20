/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.coregraphics.CGAffineTransform;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.backend.desktop.ResourceResolver;
import org.crossmobile.backend.desktop.cgeo.CDrawable;
import org.crossmobile.bind.graphics.*;
import org.crossmobile.bind.io.AbstractFileBridge;
import org.crossmobile.bridge.Native;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.*;

import static crossmobile.ios.uikit.UIDeviceOrientation.*;

public class SwingGraphicsBridge extends DesktopGraphicsBridge<Graphics2D, AffineTransform> {

    public static JEmulatorFrame frame;
    public static JEmulatorPanel component;
    public static Graphics2D defaultGraphics;

    private Map<String, FontInfo> psFontNames;
    private String backChar;

    @Override
    public DrawableMetrics newMetrics() {
        return new SwingDrawableMetrics();
    }

    @Override
    public SwingGraphicsContext newGraphicsContext(Graphics2D graphics, boolean isLive) {
        return new SwingGraphicsContext(graphics == null ? getDefaultGraphics() : graphics, isLive);
    }

    @Override
    public CGAffineTransform nativeToTarget(AffineTransform from, CGAffineTransform to) {
        if (to == null)
            to = new CGAffineTransform(from.getScaleX(),
                    from.getShearY(),
                    from.getShearX(),
                    from.getScaleY(),
                    from.getTranslateX(),
                    from.getTranslateY());
        else {
            to.setA(from.getScaleX());
            to.setB(from.getShearY());
            to.setC(from.getShearX());
            to.setD(from.getScaleY());
            to.setTx(from.getTranslateX());
            to.setTy(from.getTranslateY());
        }
        return to;
    }

    @Override
    public AffineTransform targetToNative(CGAffineTransform from, AffineTransform to) {
        if (to == null)
            to = new AffineTransform(from.getA(), from.getB(), from.getC(), from.getD(), from.getTx(), from.getTy());
        else
            to.setTransform(from.getA(), from.getB(), from.getC(), from.getD(), from.getTx(), from.getTy());
        return to;
    }

    @Override
    protected void requestRepaint() {
        component.repaint();
    }

    @Override
    public NativeFont getFont(String fontName, double size) {
        return SwingFont.getFont(fontName, (float) size);
    }

    @Override
    public NativePath newNativePath() {
        return new SwingNativePath();
    }

    @Override
    public Graphics2D createCanvas(NativeBitmap bitmap) {
        return ((SwingBitmap) bitmap).img.createGraphics();
    }

    @Override
    protected void resizeWindow(int width, int height) {
        JEmulatorPanel panel = SwingGraphicsBridge.component;
        Dimension wants = new Dimension(width, height);
        panel.getSize();
        if (!panel.getSize().equals(wants)) {
            setComponentSize(panel, wants);
            frame.remove(panel);
            frame.add(panel, BorderLayout.CENTER);
            frame.pack();
        }
        Native.widget().resignFocus();
    }

    public static void setComponentSize(SizableComponent c, Dimension d) {
        c.setPreferredSize(d);
        c.setMaximumSize(d);
        c.setMinimumSize(d);
        c.setSize(d);
    }

    @Override
    public void destroyCanvas(Graphics2D canvas) {
        canvas.dispose();
    }

    @Override
    public void draw(CDrawable drawable, GraphicsContext<?> cxt, int orientation) {
        Graphics2D g = ((SwingGraphicsContext) cxt).g2;
        if ((drawable.orientation & orientation) != 0) {
            AffineTransform t = null;
            if (drawable.autorotate && orientation != Portrait) {
                t = g.getTransform();
                g.rotate(
                        orientation == PortraitUpsideDown ? Math.PI : (orientation == LandscapeLeft ? Math.PI / 2 : Math.PI * 3 / 2),
                        drawable.virtualX() + (drawable.virtualWidth() / 2d), drawable.virtualY() + (drawable.virtualHeight() / 2d));
            }
            g.drawImage(((SwingBitmap) drawable.getImage()).img, drawable.hardwareX(), drawable.hardwareY(), drawable.hardwareWidth(), drawable.hardwareHeight(), null);
            if (t != null)
                g.setTransform(t);
        }
    }

    public static Graphics2D getDefaultGraphics() {
        if (defaultGraphics == null)
            return (Graphics2D) component.getGraphics();
        return defaultGraphics;
    }

    @Override
    public int colorHSBAtoRGBA(double h, double s, double b, double a) {
        return (Color.HSBtoRGB((float) h, (float) s, (float) b) & 0xFFFFFF) | ((int) (a * 0xFF) << 24);
    }

    @Override
    public double[] colorRGBAtoHSVA(int color) {
        float[] hsb = new float[3];
        Color.RGBtoHSB((color >>> 16) & 0xFF, (color >>> 8) & 0xFF, color & 0xFF, hsb);
        return new double[]{hsb[0], hsb[1], hsb[2], ((color >>> 24) & 0xFF) / 255d};
    }

    @Override
    public String getBackChar() {
        if (backChar == null)
            if (new Font(Native.graphics().themeManager().fonts().fontName(), Font.PLAIN, Native.graphics().themeManager().fonts().labelSize()).canDisplay(Theme.Font.BACKCHAR.charAt(0)))
                backChar = Theme.Font.BACKCHAR;
            else
                backChar = "<";
        return backChar;
    }


    @SuppressWarnings("UseSpecificCatch")
    public void loadFonts() {
        if (psFontNames != null)
            return;
        psFontNames = new HashMap<>();
        for (String fontName : ResourceResolver.getFontNames())
            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, ((AbstractFileBridge) Native.file()).getApplicationFileStream(fontName));
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
                psFontNames.put(font.getPSName(), new FontInfo(font.getFamily(), font.isBold(), font.isItalic()));
            } catch (Exception ex) {
                Native.system().error("Unable to load font " + fontName + ", reason: " + ex.toString(), null);
            }
    }

    public FontInfo getFontInfo(String name) {
        FontInfo info = psFontNames.get(name);
        if (info == null)
            psFontNames.put(name, info = constructFontInfo(name));
        return info;
    }

    @Override
    public java.util.List<String> listFontFamilies() {
        loadFonts();
        return Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
    }

    @Override
    public java.util.List<String> listFont(String familyName) {
        loadFonts();
        List<String> fonts = new ArrayList<>();
        for (Font f : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts())
            if (f.getFamily().equals(familyName))
                fonts.add(f.getPSName());
        return fonts;
    }

    public interface SizableComponent {

        void setPreferredSize(Dimension size);

        void setMaximumSize(Dimension size);

        void setMinimumSize(Dimension size);

        void setSize(Dimension size);

        void setLocation(int i, int i0);
    }

}
