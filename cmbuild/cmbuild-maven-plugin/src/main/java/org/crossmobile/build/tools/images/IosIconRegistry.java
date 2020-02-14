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
package org.crossmobile.build.tools.images;

import org.crossmobile.bridge.system.BaseUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IosIconRegistry {
    private static final String TYPE = "images";

    public static void exec(File path) {
        List<JsonImage> jsonImages = new ArrayList<>();
        for (File icon : Objects.requireNonNull(path.listFiles((dir, name) -> name.startsWith("icon") && name.endsWith(".png"))))
            jsonImages.add(new JsonImage(icon));

        try {
            Writer fileWriter = new OutputStreamWriter(new FileOutputStream(new File(path, "Contents.json")), StandardCharsets.UTF_8);
            fileWriter.write(getJson(jsonImages));
            fileWriter.flush();
        } catch (IOException ex) {
            BaseUtils.throwException(ex);
        }
    }

    private static String getJson(List<JsonImage> jsonImages) {
        StringBuilder out = new StringBuilder();
        out.append("{").append("\n")
                .append("  \"").append(TYPE).append("\" : [").append("\n");
        for (JsonImage s : jsonImages)
            if (s.isSet())
                out.append(s.toString()).append(",").append("\n");
        out.delete(out.length() - 2, out.length() - 1);
        out.append("  ],").append("\n")
                .append("  \"info\" : {").append("\n")
                .append("    \"version\" : 1,").append("\n")
                .append("    \"author\" : \"xcode\"").append("\n")
                .append("  }").append("\n")
                .append("}").append("\n");
        return out.toString();
    }

    private static class JsonImage {
        private final String idiom;
        private final String scale;
        private final String size;
        private String filename = "";

        private JsonImage(File icon) {
            String[] attribute = icon.getName().toLowerCase().substring(5, icon.getName().length() - ".png".length()).split("_");
            this.idiom = (attribute[0] == null) ? "" : attribute[0];
            this.size = (attribute[1] == null) ? "" : attribute[1];
            this.scale = (attribute[2] == null) ? "" : attribute[2];
            filename = icon.getName();
        }

        private boolean isSet() {
            return !filename.equals("");
        }

        @Override
        public String toString() {
            StringBuilder out = new StringBuilder();
            out.append("  ").append("{").append("\n");
            if (!idiom.equals(""))
                out.append("    ").append("\"idiom\"").append(" : ").append("\"").append(idiom).append("\"").append(",\n");
            if (!filename.equals(""))
                out.append("    ").append("\"filename\"").append(" : ").append("\"").append(filename).append("\"").append(",\n");
            if (!size.equals(""))
                out.append("    ").append("\"size\"").append(" : ").append("\"").append(size).append("\"").append(",\n");
            if (!scale.equals(""))
                out.append("    ").append("\"scale\"").append(" : ").append("\"").append(scale).append("\"").append(",\n");
            out.delete(out.length() - 2, out.length() - 1);
            out.append("  ").append("}");
            return out.toString();
        }
    }
}
