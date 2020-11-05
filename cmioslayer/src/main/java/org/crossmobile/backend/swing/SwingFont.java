/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.swing;

import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bridge.GraphicsBridge.FontInfo;
import org.crossmobile.bridge.Native;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Map;

import static java.awt.font.TextAttribute.*;

public class SwingFont implements NativeFont {

    final Font font;
    private final String name;
    private final int ascent;
    private final int descent;

    @SuppressWarnings("UseSpecificCatch")
    static SwingFont getFont(String fontName, float size) {
        DesktopGraphicsBridge<?, ?, ?> graphicsBridge = (DesktopGraphicsBridge<?, ?, ?>) Native.graphics();
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
        FontMetrics metrics = SwingGraphicsBridge.component.getFontMetrics(font);
        this.ascent = metrics.getAscent();
        this.descent = metrics.getDescent();
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
    public float getSize() {
        return font.getSize2D();
    }

    @Override
    public int getAscent() {
        return ascent;
    }

    @Override
    public int getDescent() {
        return descent;
    }

    @Override
    public int getUnitsPerEm() {
        Native.system().notImplemented();
        return 0;
    }
}
