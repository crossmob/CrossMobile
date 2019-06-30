/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.build.tools;

import org.crossmobile.utils.Log;

import java.awt.*;
import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.crossmobile.utils.TextUtils.countCharacter;
import static org.crossmobile.utils.TextUtils.safeXML;

public class FontExtractor {

    public static Map<String, File> findFonts(Collection<File> materials) {
        Map<String, File> fonts = new LinkedHashMap<>();
        for (File entry : materials)
            findFonts(entry, "", fonts);
        if (!fonts.isEmpty())
            Log.info("Project contains " + fonts.size() + (fonts.size() == 1 ? " font" : " fonts"));
        return fonts;
    }

    private static void findFonts(File file, String prefix, Map<String, File> fonts) {
        String filename = prefix + (prefix.isEmpty() ? "" : "/") + file.getName();
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            if (children != null)
                for (File child : children)
                    findFonts(child, filename, fonts);
        } else {
            String fname = file.getName();
            String lname = fname.toLowerCase();
            if (lname.endsWith(".ttf") || lname.endsWith(".otf"))
                fonts.put(filename, file);
        }
    }

    @SuppressWarnings("UseSpecificCatch")
    public static String getFontDataAsResource(Map<String, File> fonts) {
        Map<String, Map<String, FontInfo>> fontlist = new LinkedHashMap<>();
        for (String fontfile : fonts.keySet())
            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, fonts.get(fontfile));
                String family = font.getFamily();
                String fontname = font.getFontName();
                boolean bold = font.isBold();
                boolean italic = font.isItalic();
                Map<String, FontInfo> familygroup = fontlist.get(family);
                if (familygroup == null) {
                    familygroup = new LinkedHashMap<>();
                    fontlist.put(family, familygroup);
                }
                FontInfo obsolete = familygroup.get(fontname);
                FontInfo current = new FontInfo(fontfile, bold, italic);
                if (obsolete != null) {
                    // Keep font closer to root, swap if older is better
                    if (countCharacter(obsolete.location, '/') <= countCharacter(current.location, '/')) {
                        FontInfo swap = current;
                        current = obsolete;
                        obsolete = swap;
                    }
                    Log.warning("Font located at " + obsolete.location
                            + (current.bold == obsolete.bold && current.italic == obsolete.italic ? "" : " with diferent weights")
                            + " has been already registered at " + current.location + ". Ignoring.");
                }
                familygroup.put(fontname, current);
            } catch (Exception ex) {
                Log.error("Unable to parse font file " + fonts.get(fontfile), ex);
            }

        StringBuilder out = new StringBuilder();
        out.append("<fontlist>\n");
        for (String family : fontlist.keySet()) {
            Map<String, FontInfo> familygroup = fontlist.get(family);
            for (String fontname : familygroup.keySet()) {
                FontInfo info = familygroup.get(fontname);
                out.append("  <font file=\"").append(safeXML(info.location)).
                        append("\" family=\"").append(safeXML(family)).
                        append("\" name=\"").append(safeXML(fontname)).
                        append("\" bold=\"").append(info.bold ? "true" : "false").
                        append("\" italic=\"").append(info.italic ? "true" : "false").
                        append("\"/>\n");
            }
        }
        out.append("</fontlist>\n");
        return out.toString();
    }

    private static class FontInfo {

        private final String location;
        private final boolean bold;
        private final boolean italic;

        public FontInfo(String location, boolean bold, boolean italic) {
            this.location = location;
            this.bold = bold;
            this.italic = italic;
        }
    }
}
