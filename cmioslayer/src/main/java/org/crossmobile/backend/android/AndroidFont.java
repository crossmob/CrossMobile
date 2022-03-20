/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.res.XmlResourceParser;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import org.crossmobile.bind.graphics.NativeFont;
import org.crossmobile.bridge.GraphicsBridge.FontInfo;
import org.crossmobile.bridge.Native;
import org.robovm.objc.block.Block0;
import org.xmlpull.v1.XmlPullParser;

import java.util.*;

public class AndroidFont implements NativeFont {

    private static final Paint ascentCalculator = new Paint();
    private static Map<String, AndroidFontInfo> font_map;

    private final AndroidFontInfo info;
    private final String name;
    final Typeface typeface;
    final float size;
    private final float ascent;
    private final float descent;
    private final float leading;
    private final float capHeight;
    private final float xHeight;

    AndroidFont(String name, float size) {
        info = getFont(name);
        this.size = size;
        this.name = name;
        this.typeface = info.typefaceRef.invoke();
        synchronized (ascentCalculator) {
            ascentCalculator.setTypeface(typeface);
            ascentCalculator.setTextSize(size);
            Paint.FontMetrics fontMetrics = ascentCalculator.getFontMetrics();
            ascent = -fontMetrics.ascent;
            descent = -fontMetrics.descent;
            leading = fontMetrics.leading; // maybe should be negative?
            Rect rect = new Rect();
            ascentCalculator.getTextBounds("M", 0, 1, rect);
            capHeight = -rect.top;
            ascentCalculator.getTextBounds("x", 0, 1, rect);
            xHeight = -rect.top;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFamily() {
        return info.family;
    }

    @Override
    public double getSize() {
        return size;
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

    @SuppressWarnings("UseSpecificCatch")
    private static Map<String, AndroidFontInfo> fonts() {
        if (font_map != null)
            return font_map;
        font_map = new LinkedHashMap<>();
        font_map.put("SansSerifRegular", new AndroidFontInfo("Sans Serif", false, false, Typeface.SANS_SERIF));
        font_map.put("SansSerifItalic", new AndroidFontInfo("Sans Serif", false, true, Typeface.SANS_SERIF));
        font_map.put("SansSerifBold", new AndroidFontInfo("Sans Serif", true, false, Typeface.SANS_SERIF));
        font_map.put("SansSerifBoldItalic", new AndroidFontInfo("Sans Serif", true, true, Typeface.SANS_SERIF));
        font_map.put("Serif", new AndroidFontInfo("Serif", false, false, Typeface.SERIF));
        font_map.put("Monospace", new AndroidFontInfo("Monospace", false, false, Typeface.MONOSPACE));

        XmlResourceParser parser = MainActivity.current.getResources().getXml(AndroidFileBridge.getResourceID("xml", "fontlist"));
        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    if (parser.getName().equals("font")) {
                        String psname = parser.getAttributeValue(null, "psname");
                        String family = parser.getAttributeValue(null, "family");
                        String file = parser.getAttributeValue(null, "file");
                        boolean bold = parser.getAttributeBooleanValue(null, "bold", false);
                        boolean italic = parser.getAttributeBooleanValue(null, "italic", false);
                        font_map.put(psname, new AndroidFontInfo(family, bold, italic, file));
                    }
                }
                eventType = parser.next();
            }
            parser.close();
        } catch (Exception ignored) {
        }
        return font_map;
    }

    private static AndroidFontInfo getFont(String name) {
        Map<String, AndroidFontInfo> fonts = fonts();
        AndroidFontInfo androidInfo = fonts.get(name);
        if (androidInfo != null)
            return androidInfo;
        FontInfo genericInfo = Native.graphics().constructFontInfo(name);
        for (String fontName : fonts.keySet()) {
            androidInfo = fonts.get(fontName);
            if (androidInfo.equals(genericInfo))
                return androidInfo;
        }
        return new AndroidFontInfo(genericInfo);
    }

    static List<String> families() {
        TreeSet<String> families = new TreeSet<>();
        for (AndroidFontInfo info : fonts().values())
            families.add(info.family);
        return new ArrayList<>(families);
    }

    static List<String> fontsOfFamily(String family) {
        List<String> result = new ArrayList<>();
        Map<String, AndroidFontInfo> fonts = fonts();
        for (String fontName : fonts.keySet()) {
            AndroidFontInfo info = fonts.get(fontName);
            if (family.equals(info.family))
                result.add(fontName);
        }
        return result;
    }

    private static class AndroidFontInfo extends FontInfo {

        private final Block0<Typeface> typefaceRef;

        private AndroidFontInfo(String family, boolean bold, boolean italic, Typeface typeface) {
            super(family, bold, italic);
            typefaceRef = () -> Typeface.create(typeface, (bold ? Typeface.BOLD : 0) | (italic ? Typeface.ITALIC : 0));
        }

        private AndroidFontInfo(String family, boolean bold, boolean italic, String path) {
            super(family, bold, italic);
            typefaceRef = () -> Typeface.createFromAsset(MainActivity.current.getAssets(), path);
        }

        private AndroidFontInfo(FontInfo info) {
            super(info.family, info.bold, info.italic);
            typefaceRef = () -> Typeface.create(family, (bold ? Typeface.BOLD : 0) | (italic ? Typeface.ITALIC : 0));
        }

        private boolean equals(FontInfo info) {
            if (info == null)
                return false;
            return this.family.equals(info.family) && this.bold == info.bold && this.italic == info.italic;
        }
    }
}
