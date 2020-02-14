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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SourcePattern {

    private final String name;
    private final String[] patterns;
    private final boolean perLineMatch;
    private final Map<String, FileHit> files;

    SourcePattern(String name, String... patterns) {
        this(name, true, patterns);
    }

    SourcePattern(String name, boolean perLineMatch, String... patterns) {
        this.name = name;
        this.perLineMatch = perLineMatch;
        this.patterns = patterns;
        files = new LinkedHashMap<>();
    }

    protected SourcePattern duplicate() {
        return new SourcePattern(name, perLineMatch, patterns);
    }

    boolean shouldMatchPerLine() {
        return perLineMatch;
    }

    boolean match(String path, String classname, String text, int lineID) {
        for (String pattern : patterns) {
            int col = text.indexOf(pattern);
            if (col >= 0) {
                FileHit hit = files.get(path);
                if (hit == null) {
                    hit = new FileHit(path, classname);
                    files.put(path, hit);
                }
                hit.add(new LocationHit(text, lineID, col));
                return true;
            }
        }
        return false;
    }

    boolean isFound() {
        return !files.isEmpty();
    }

    public String getName() {
        return name;
    }

    public List<FileHit> getFileHits() {
        return new ArrayList<>(files.values());
    }

    public void dump() {
        System.out.println("Permission " + name);
        for (FileHit hit : files.values())
            hit.dump();
    }
}
