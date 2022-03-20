/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.util.Collection;
import java.util.TreeSet;

public class AndroidInjections {
    private final TreeSet<String> appSection = new TreeSet<>();
    private final TreeSet<String> gradleExt = new TreeSet<>();
    private final TreeSet<String> gradleBuildDep = new TreeSet<>();

    public AndroidInjections() {
    }

    public AndroidInjections(String jsonData) {
        if (jsonData == null || jsonData.isEmpty())
            return;
        JsonObject root = Json.parse(jsonData).asObject();
        fromArray(root.get("appSection"), appSection);
        fromArray(root.get("gradleExt"), gradleExt);
        fromArray(root.get("gradleBuildDep"), gradleBuildDep);
    }


    public void add(String[] appSection, String[] gradleExt, String[] gradleBuildDep) {
        addEntry(appSection, this.appSection);
        addEntry(gradleExt, this.gradleExt);
        addEntry(gradleBuildDep, this.gradleBuildDep);
    }

    private void addEntry(String[] given, TreeSet<String> list) {
        if (given != null && given.length > 0)
            for (String item : given)
                if (item != null && !item.trim().isEmpty())
                    list.add(item.trim());
    }

    public boolean isEmpty() {
        return appSection.isEmpty() && gradleExt.isEmpty() && gradleBuildDep.isEmpty();
    }

    public String getAppSection() {
        return appSection.isEmpty() ? "" : getSection(appSection, "        ");
    }

    public String getGradleExt() {
        return gradleExt.isEmpty() ? "" : getSection(gradleExt, "");
    }

    public String getGradleBuildDep() {
        return gradleBuildDep.isEmpty() ? "" : getSection(gradleBuildDep, "        ");
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "";
        JsonObject root = new JsonObject();
        if (!appSection.isEmpty())
            root.add("appSection", toArray(appSection));
        if (!gradleExt.isEmpty())
            root.add("gradleExt", toArray(gradleExt));
        if (!gradleBuildDep.isEmpty())
            root.add("gradleBuildDep", toArray(gradleBuildDep));
        return root.toString();
    }

    private JsonArray toArray(Collection<String> data) {
        JsonArray array = new JsonArray();
        for (String item : data)
            array.add(item);
        return array;
    }

    private void fromArray(JsonValue data, Collection<String> target) {
        if (data != null && data.isArray())
            for (JsonValue item : data.asArray())
                target.add(item.asString());
    }

    private String getSection(Collection<String> data, String prefix) {
        StringBuilder out = new StringBuilder();
        for (String item : data) {
            out.append(prefix);
            out.append(item);
            out.append("\n");
        }
        return out.toString();
    }
}
