package org.crossmobile.build.tools.images;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContentsJson {
    private static final String TYPE = "images";

    public static void exec(File path) {
        List<JsonImage> jsonImages = new ArrayList<>();
        for (File icon : Objects.requireNonNull(path.listFiles((dir, name) -> name.startsWith("icon") && name.endsWith(".png"))))
            jsonImages.add(new JsonImage(icon));
        createJSon(path, jsonImages);
    }


    private static boolean createJSon(File path, List<JsonImage> jsonImages) {
        try {
            Writer fileWriter = new OutputStreamWriter(new FileOutputStream(new File(path, "Contents.json")), StandardCharsets.UTF_8);
            fileWriter.write(getJson(jsonImages));
            fileWriter.flush();
        } catch (IOException ex) {
            return false;
        }
        return true;
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

}
