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
package org.crossmobile.gui.codehound.source;

import org.crossmobile.utils.ProjectException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class SourceDocument {

    private final static String[] BLACKLIST = {"import", "package", "//"};
    //
    private final List<String> lines = new ArrayList<>();
    private final String filename;
    private final String classname;
    private final String fulltext;

    SourceDocument(File file, String classname) throws ProjectException {
        this.filename = file.getPath();
        this.classname = classname;

        StringBuilder full = new StringBuilder();
        BufferedReader in = null;
        String line;
        try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
            next_line:
            while ((line = in.readLine()) != null) {
                line = line.trim();
                for (String current : BLACKLIST)
                    if (line.startsWith(current))
                        continue next_line;
                lines.add(line);
                full.append(line);
            }
            fulltext = full.toString().replaceAll("[\\t\\n\\r\\f ]", "");
        } catch (IOException ex) {
            throw new ProjectException("Error while parsing source file " + file.getPath(), ex);
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException ex) {
                }
        }
    }

    void parse(Set<SourcePattern> list) {
        for (SourcePattern p : list)
            if (p.shouldMatchPerLine()) {
                for (int i = 0; i < lines.size(); i++)
                    if (p.match(filename, classname, lines.get(i), i + 1))
                        return;
            } else
                p.match(filename, classname, fulltext, -1);
    }
}
