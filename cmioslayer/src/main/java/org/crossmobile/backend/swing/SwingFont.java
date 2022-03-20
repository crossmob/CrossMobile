/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bridge.GraphicsBridge.FontInfo;
import org.crossmobile.bridge.Native;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Map;

import static java.awt.font.TextAttribute.*;

public class SwingFont implements NativeFont {

    final Font font;
    private final String name;
    private final float ascent;
    private final float descent;
    private final float leading;
    private final double capHeight;
    private final double xHeight;

    @SuppressWarnings("UseSpecificCatch")
    static SwingFont getFont(String fontName, float size) {
        SwingGraphicsBridge graphicsBridge = (SwingGraphicsBridge) Native.graphics();
        graphicsBridge.loadFonts();
        FontInfo fontInfo = graphicsBridge.getFontInfo(fontName);
        Map<AttributedCharacterIterator.Attribute, Object> attributes = new HashMap<>();
        attributes.put(FAMILY, fontInfo.family);
        attributes.put(WEIGHT, fontInfo.bold ? WEIGHT_BOLD : WEIGHT_REGULAR);
        attributes.put(POSTURE, fontInfo.italic ? POSTURE_OBLIQUE : POSTURE_REGULAR);
        attributes.put(SIZE, size);
        return new SwingFont(new Font(attributes), fontName);
    }

    SwingFont(Font font) {
        this(font, font.getPSName());
    }

    SwingFont(Font font, String postscriptName) {
        this.font = font;
        this.name = postscriptName;
        FontRenderContext fc = SwingGraphicsBridge.getDefaultGraphics().getFontRenderContext();
        TextLayout layout = new TextLayout("M", font, fc);
        ascent = layout.getAscent();
        descent = -layout.getDescent();
        leading = layout.getBaseline();
        capHeight = -layout.getBounds().getY();
        layout = new TextLayout("x", font, fc);
        xHeight = -layout.getBounds().getY();
    }

    CGSize stringSize(String text) {
        if (text == null || text.trim().isEmpty() || font == null)
            return new CGSize(0, 0);
        else {
            Graphics2D g = SwingGraphicsBridge.getDefaultGraphics();
            Rectangle2D bounds = g.getFontMetrics(font).getStringBounds(text, g);
            return new CGSize((float) bounds.getWidth(), (float) bounds.getHeight());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFamily() {
        return font.getFamily();
    }

    @Override
    public double getSize() {
        return font.getSize2D();
    }

    @Override
    public double getAscent() {
        return ascent;
    }

    @Override
    public double getDescent() {
        return descent;
    }

    @Override
    public double getLeading() {
        return leading;
    }

    @Override
    public double getCapHeight() {
        return capHeight;
    }

    @Override
    public double getXHeight() {
        return xHeight;
    }
}
