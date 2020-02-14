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
package org.crossmobile.backend.android;

import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.graphics.Typeface;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.xmlpull.v1.XmlPullParser;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AndroidFont implements NativeFont {

    private static final Paint fill = new Paint();
    private static Map<String, Map<String, FontInfo>> font_map;

    private final String family;
    public final Typeface typeface;
    public final float size;
    private final int ascent;
    private final int descent;

    AndroidFont(String family, float size, boolean bold, boolean italic) {
        Map<String, FontInfo> fontfamily = null;
        Typeface tf = null;
        FontInfo maybe = null;
        if (!Theme.Font.FONTNAME.equals(family) && (fontfamily = fonts().get(family)) != null) {
            tf = null;
            for (FontInfo font : fontfamily.values())
                if (font.bold == bold && font.italic == italic) {
                    tf = font.getTypeface();
                    break;
                } else if (italic && font.italic)
                    // at least italic
                    maybe = font;
                else if (bold && font.bold && maybe == null)
                    // at least bold, if no font found up to now
                    maybe = font;
            if (tf == null)
                if (maybe != null)
                    tf = maybe.getTypeface();
                else
                    tf = fontfamily.get(fontfamily.keySet().iterator().next()).getTypeface();
        }
        if (tf == null)
            tf = Typeface.create(family, (bold ? Typeface.BOLD : 0) | (italic ? Typeface.ITALIC : 0));

        typeface = tf;
        this.family = family;
        this.size = size;
        synchronized (fill) {
            fill.setTypeface(typeface);
            fill.setTextSize(size);
            ascent = Math.round(fill.ascent());
            descent = Math.round(fill.descent());
        }
    }

    @Override
    public String getFamily() {
        return family;
    }

    @Override
    public float getSize() {
        return size;
    }

    @Override
    public boolean isBold() {
        return typeface.isBold();
    }

    @Override
    public boolean isItalic() {
        return typeface.isItalic();
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

    @SuppressWarnings("UseSpecificCatch")
    private static Map<String, Map<String, FontInfo>> fonts() {
        if (font_map != null)
            return font_map;

        font_map = new LinkedHashMap<>();

        Map<String, FontInfo> family = new LinkedHashMap<>();
        family.put("Sans Serif Regular", new FontInfo(false, false, Typeface.SANS_SERIF));
        family.put("Sans Serif Italic", new FontInfo(false, true, Typeface.SANS_SERIF));
        family.put("Sans Serif Bold", new FontInfo(true, false, Typeface.SANS_SERIF));
        family.put("Sans Serif Bold Italic", new FontInfo(true, true, Typeface.SANS_SERIF));
        font_map.put("Sans Serif", family);

        family = new LinkedHashMap<>();
        family.put("Serif", new FontInfo(false, false, Typeface.SERIF));
        font_map.put("Serif", family);

        family = new LinkedHashMap<>();
        family.put("Monospace", new FontInfo(false, false, Typeface.MONOSPACE));
        font_map.put("Monospace", family);

        XmlResourceParser parser = MainActivity.current.getResources().getXml(AndroidFileBridge.getResourceID("xml", "fontlist"));
        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (parser.getName().equals("font")) {
                            String file = parser.getAttributeValue(null, "file");
                            String familyname = parser.getAttributeValue(null, "family");
                            String name = parser.getAttributeValue(null, "name");
                            boolean bold = parser.getAttributeBooleanValue(null, "bold", false);
                            boolean italic = parser.getAttributeBooleanValue(null, "italic", false);
                            family = font_map.get(familyname);
                            if (family == null) {
                                family = new LinkedHashMap<>();
                                font_map.put(familyname, family);
                            }
                            family.put(name, new FontInfo(bold, italic, file));
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
            parser.close();
        } catch (Exception e) {
        }
        return font_map;
    }

    static List<String> families() {
        return new ArrayList<>(fonts().keySet());
    }

    static List<String> fontsOfFamily(String family) {
        Map<String, FontInfo> fontfamily = fonts().get(family);
        return fontfamily == null ? null : new ArrayList<>(fontfamily.keySet());
    }

    private static class FontInfo {

        private final boolean bold;
        private final boolean italic;
        private final Typeface tf;
        private final String path;
        private WeakReference<Typeface> cache;

        private FontInfo(boolean bold, boolean italic, Typeface typeface) {
            this(bold, italic, typeface, null);
        }

        private FontInfo(boolean bold, boolean italic, String path) {
            this(bold, italic, null, path);
        }

        private FontInfo(boolean bold, boolean italic, Typeface typeface, String path) {
            this.bold = bold;
            this.italic = italic;
            this.tf = typeface;
            this.path = path;
        }

        Typeface getTypeface() {
            if (tf != null) {
                if (!bold && !italic)
                    return tf;
                Typeface ctf = cache == null ? null : cache.get();
                if (ctf != null)
                    return ctf;
                ctf = Typeface.create(tf, (bold ? Typeface.BOLD : 0) | (italic ? Typeface.ITALIC : 0));
                cache = new WeakReference<>(ctf);
                return ctf;
            } else if (path != null) {
                Typeface ctf = cache == null ? null : cache.get();
                if (ctf != null)
                    return ctf;
                ctf = Typeface.createFromAsset(MainActivity.current.getAssets(), path);
                cache = new WeakReference<>(ctf);
                return ctf;
            } else
                return null;
        }
    }
}
