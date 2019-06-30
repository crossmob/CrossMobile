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
package org.crossmobile.utils;

import org.crossmobile.utils.launcher.Flavour;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.crossmobile.utils.ParamsCommon.*;

public class Pom {

    private final XMLWalker pomWalker;
    private final File pomFile;
    public static final String CROSSMOBILE_GROUP_ID = "org.crossmobile";
    public static final String CROSSMOBILE_THEME_ID = "cmtheme-bright";
    public static final String CROSSMOBILE_PARENT_ID = "cmproject";
    public static final String CROSSMOBILE_PARENT_ID_DEBUG = "cmproject-debug";

    public Pom(File pomFile) {
        this.pomFile = pomFile;
        pomWalker = XMLWalker.load(pomFile);

    }

    public boolean isValid() {
        return Nullable.of(pomWalker).def(false).set(root -> root.setMeta(false).
                execIf(w -> w.pathExists("/project/parent"), parent -> parent.last().execIf(
                        c -> CROSSMOBILE_GROUP_ID.equals(parent.tag(0).nodeExists("groupID") ? parent.last().text() : null)
                                && (CROSSMOBILE_PARENT_ID.equals(parent.toTag(0).nodeExists("artifactId") ? parent.last().text() : null)
                                || CROSSMOBILE_PARENT_ID_DEBUG.equals(parent.toTag(0).nodeExists("artifactId") ? parent.last().text() : null)),
                        c -> root.setMeta(true))).meta())
                .get(Boolean.class);
    }

    public String parentVersion() {
        return pomWalker.pathExists("/project/parent/version") ? pomWalker.path("/project/parent/version").text() : "";
    }

    public void setParentProject(String version) {
        if (pomWalker.pathExists("/project/parent")) {
            if (pomWalker.pathExists("/project/parent/version"))
                pomWalker.path("/project/parent/version").setText(version);
            if (!pomWalker.pathExists("/project/parent/relativePath"))
                pomWalker.path("/project/parent").add("relativePath");
        }
    }

    public String getArtifactId() {
        return pomWalker.path("/project/artifactId").text();
    }

    public static List<Dependency> unpackDependencies(String dependenciesProp) {
        List<Dependency> dependencies = new ArrayList<>();
        if (!dependenciesProp.isEmpty())
            for (String depPacked : dependenciesProp.split(";")) {
                String[] dep_array = depPacked.split(":");
                if (dep_array.length == 5) {
                    Dependency dep = Dependency.find(dep_array[0], dep_array[1], dep_array[2], dep_array[3], dep_array[4]);
                    if (dep != null)
                        dependencies.add(dep);
                }
            }
        return dependencies;
    }

    public static String packDependencies(Collection<Dependency> list) {
        StringBuilder builder = new StringBuilder();
        for (Dependency dep : list)
            builder.append(dep.groupId).append(":")
                    .append(dep.artifactId).append(":")
                    .append(dep.version == null ? " " : dep.version).append(":")
                    .append(dep.classifier == null ? " " : dep.classifier).append(":")
                    .append(dep.scope == null ? " " : dep.scope).append(";");
        return builder.length() > 0 ? builder.substring(0, builder.length() - 1) : "";
    }

    private Collection<Dependency> getDependencies() {
        Collection<Dependency> deps = new ArrayList<>();
        AtomicBoolean foundTheme = new AtomicBoolean();
        pomWalker.path("/project/dependencies").nodes("dependency",
                w -> w.execIf(c -> c.nodeExists("groupId")
                                && c.nodeExists("artifactId")
                                && (c.node("artifactId").text().startsWith("cmplugin")
                                || c.parent().node("artifactId").text().startsWith("cmtheme")),
                        a -> {
                            Dependency current = Dependency.find(a.tag().node("groupId").text(),
                                    a.toTag().node("artifactId").text(),
                                    a.toTag().nodeExists("version") ? a.node("version").text() : null,
                                    a.toTag().nodeExists("classifier") ? a.node("classifier").text() : null,
                                    a.toTag().nodeExists("scope") ? a.node("scope").text() : null);
                            if (current != null) {
                                deps.add(current);
                                if (current.theme)
                                    foundTheme.set(true);
                            }
                        }));
        if (!foundTheme.get())
            deps.add(Dependency.getSystemTheme(null));
        return deps;
    }

    public boolean updatePropertiesFromPom(Properties properties) {
        try {
            StringBuilder name = new StringBuilder();
            pomWalker.
                    path("/project").
                    execIf(w -> w.nodeExists("artifactId"), w -> properties.put(ARTIFACT_ID.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("groupId"), w -> properties.put(GROUP_ID.tag().name, w.last().text() + "." + name.toString())).
                    execIf(w -> w.nodeExists("version"), w -> properties.put(BUNDLE_VERSION.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("name"), w -> properties.put(DISPLAY_NAME.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("properties"), w -> w.node("properties").nodes(p -> properties.put(p.name(), p.last().text())));
            properties.put(CM_PLUGINS.tag().name, packDependencies(getDependencies()));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private XMLWalker dependenciesForProfile(String profile) {
        if (!profileExists(profile))
            return pomWalker.path("/project/profiles").add("profile").add("id").setText(profile).parent()
                    .add("dependencies");
        else
            return pomWalker.path("/project/profiles").nodes("profile",
                    p -> p.execIf(w -> w.nodeWithTextExists("id", profile),
                            w -> w.execIf(n -> !n.nodeExists("dependencies"),
                                    n -> n.add("dependencies").parent()).node("dependencies").tag()
                    )
            ).toTag();

    }

    private boolean profileExists(String profile) {
        final boolean[] exists = new boolean[1];
        exists[0] = false;
        pomWalker.path("/project").execIf(w -> !w.nodeExists("profiles"),
                w -> w.add("profiles").parent())
                .node("profiles").execIf(w -> w.nodeExists("profile"),
                w -> w.filterNodes("profile",
                        p -> exists[0] = true, p -> p.nodeWithTextExists("id", profile)));

        return exists[0];
    }

    private void updateTheme(Dependency theme, String version) {
        pomWalker.path("/project/dependencies").tag().nodes("dependency",
                d -> d.execIf(n -> n.node("artifactId").text().contains("cmtheme"),
                        XMLWalker::remove
                )
        ).toTag().add("dependency")
                .add("groupId").setText(theme.groupId).parent()
                .add("artifactId").setText(theme.artifactId).parent()
                .add("version").setText(theme.version);
    }

    public Pom updatePomFromProperties(ParamSet paramset, Properties properties) {
        pomWalker.
                path("/project").tag().
                toTag().execIf(w -> !w.nodeExists("groupId"), w -> w.add("groupId")).node("groupId").setText(properties.getProperty(GROUP_ID.tag().name)).
                toTag().execIf(w -> !w.nodeExists("artifactId"), w -> w.add("artifactId")).node("artifactId").setText(properties.getProperty(ARTIFACT_ID.tag().name)).
                toTag().execIf(w -> !w.nodeExists("version"), w -> w.add("version")).node("version").setText(properties.getProperty(BUNDLE_VERSION.tag().name)).
                toTag().execIf(w -> !w.nodeExists("name"), w -> w.add("name")).node("name").setText(properties.getProperty(DISPLAY_NAME.tag().name)).
                toTag().execIf(w -> !w.nodeExists("properties"), w -> w.add("properties")).
                node("properties").tag("properties");

        injectDependencies(unpackDependencies(properties.getProperty(CM_PLUGINS.tag().name)), properties.getProperty(BUNDLE_VERSION.tag().name));

        for (Param param : paramset.build()) {
            String newValue = properties.getProperty(param.name, "");
            if (newValue.isEmpty() || newValue.equals(param.deflt))
                pomWalker.toTag("properties").execIf(w -> w.nodeExists(param.name), w -> w.node(param.name).remove());
            else
                pomWalker.toTag("properties").execIf(w -> !w.nodeExists(param.name), w -> w.add(param.name)).node(param.name).setText(newValue);
        }
        // Update Maven repository from http to https
        pomWalker.path("/project").execIf(w -> w.nodeExists("repositories"), w -> {
            w.node("repositories").filterNodes("repository", r -> {
                if (r.nodeExists("url") && r.node("url").text().toLowerCase().startsWith("http://mvn.crossmobile.org/"))
                    r.setText("https://mvn.crossmobile.org/content/repositories/crossmobile/");
            });
        });
        return this;
    }

    private void injectDependencies(List<Dependency> dependencies, String version) {
        updateDependencies(pomWalker.path("/project/dependencies"), dependencies, null);
        for (Flavour flavour : Flavour.values())
            updateDependencies(dependenciesForProfile(flavour.getProfileName()), dependencies, flavour.getProfileName());
        dependencies.stream().filter(t -> t.theme).findFirst().ifPresent(theme -> updateTheme(theme, version));
    }

    private void updateDependencies(XMLWalker walker, List<Dependency> dependencies, String profile) {
        walker.tag()
                .execIf(n -> n.nodeExists("dependency"),
                        n -> n.nodes("dependency",
                                d -> d.execIf(w -> w.node("artifactId").text().startsWith("cmplugin-"), w -> w.remove())));
        dependencies.stream().filter(dependency -> dependency.cmplugin && !dependency.theme)
                .forEach(d -> walker.toTag()
                        .add("dependency")
                        .add("groupId").setText(d.groupId).parent()
                        .add("artifactId").setText(d.artifactId(profile)).parent()
                        .execIf(c -> d.version != null, c -> c.add("version").setText(d.version).parent())
                        .add("scope").setText(profile == null ? "provided" : "runtime")
                );
    }

    public void save() {
        pomWalker.store(pomFile, true);
    }
}
