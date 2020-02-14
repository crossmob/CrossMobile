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

import crossmobile.ios.coregraphics.CGSize;
import org.crossmobile.backend.desktop.DesktopGraphicsBridge;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;

import java.awt.*;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;
import java.util.Map;

import static java.awt.font.TextAttribute.*;

public class SwingFont implements NativeFont {

    final Font font;
    private final int ascent;
    private final int descent;

    @SuppressWarnings("UseSpecificCatch")
    static SwingFont getFont(String name, float size, boolean bold, boolean italic) {
        if (!Theme.Font.FONTNAME.equals(name))
            DesktopGraphicsBridge.loadFonts();
        Map<AttributedCharacterIterator.Attribute, Object> attributes = new HashMap<>();
        attributes.put(FAMILY, name);
        attributes.put(WEIGHT, bold ? WEIGHT_BOLD : WEIGHT_REGULAR);
        attributes.put(POSTURE, italic ? POSTURE_OBLIQUE : POSTURE_REGULAR);
        attributes.put(SIZE, size);
        return new SwingFont(new Font(attributes));
    }

    SwingFont(Font font) {
        this.font = font;
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
    public String getFamily() {
        return font.getFamily();
    }

    @Override
    public float getSize() {
        return font.getSize2D();
    }

    @Override
    public boolean isBold() {
        return font.isBold();
    }

    @Override
    public boolean isItalic() {
        return font.isItalic();
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
        Native.lifecycle().notImplemented();
        return 0;
    }

}
