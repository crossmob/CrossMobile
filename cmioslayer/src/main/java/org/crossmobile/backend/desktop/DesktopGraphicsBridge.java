/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import org.crossmobile.backend.desktop.cgeo.CDrawable;
import org.crossmobile.bind.graphics.AbstractGraphicsBridge;
import org.crossmobile.bind.graphics.GraphicsBridgeConstants;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.io.AbstractFileBridge;
import org.crossmobile.bridge.Native;

import java.awt.*;
import java.util.*;
import java.util.List;

public abstract class DesktopGraphicsBridge<CANVAS, NTVP, TRANSF> extends AbstractGraphicsBridge<CANVAS, NTVP, TRANSF> {

    private Map<String, FontInfo> psFontNames;

    private String backChar;

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
    public void setOrientation(int orientation) {
        Native.graphics().metrics().setOrientationMetrics(orientation);
        resizeWindow();
        Native.graphics().relayoutMainView();
    }

    public abstract void resizeWindow();

    public static void rotateDevice(boolean clockwise) {
        int orientation = Native.graphics().metrics().getOrientation();
        for (int i = 0; i < 4; i++) {
            orientation += clockwise ? 1 : -1;
            if (orientation > 4)
                orientation = 1;
            if (orientation < 1)
                orientation = 4;
            if (GraphicsBridgeConstants.shouldAcceptOrientation(orientation)) {
                Native.graphics().setOrientation(orientation);
                return;
            }
        }
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

    public abstract void draw(CDrawable drawable, GraphicsContext<?> cxt, int orientation);

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
    public List<String> listFontFamilies() {
        loadFonts();
        return Arrays.asList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
    }

    @Override
    public List<String> listFont(String familyName) {
        loadFonts();
        List<String> fonts = new ArrayList<>();
        for (Font f : GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts())
            if (f.getFamily().equals(familyName))
                fonts.add(f.getPSName());
        return fonts;
    }
}
