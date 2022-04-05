/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.Version;
import org.crossmobile.utils.func.Opt;
import org.crossmobile.utils.launcher.Flavour;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.crossmobile.utils.ParamsCommon.*;

public final class Pom {

    private final XMLWalker pomWalker;
    private final File pomFile;
    private boolean isPlugin;

    public static final String SHADOW = GROUP_ID + ".ca.";
    public static final String CROSSMOBILE_THEME_ID = "cmtheme-bright";
    private static final String CROSSMOBILE_PROJECT_ID = "cmproject";
    private static final String CROSSMOBILE_PLUGIN_ID = "cmplugin";

    private Pom(File pomFile) {
        this.pomFile = pomFile;
        pomWalker = XMLWalker.load(pomFile);
        isPlugin = pomWalker != null
                && pomWalker.pathExists("/project/parent/artifactId")
                && CROSSMOBILE_PLUGIN_ID.equals(pomWalker.path("/project/parent/artifactId").text());
    }

    public static Pom read(File pomFile) {
        Pom pom = new Pom(pomFile);
        if (pom.pomWalker == null)
            return null;
        if (!pom.pomWalker.pathExists("/project/parent/groupId") || !Version.GROUPID.equals(pom.pomWalker.path("/project/parent/groupId").text()))
            return null;
        if (!pom.pomWalker.pathExists("/project/parent/artifactId"))
            return null;
        String parentArtifact = pom.pomWalker.path("/project/parent/artifactId").text();
        if (CROSSMOBILE_PROJECT_ID.equals(parentArtifact)) {
            pom.isPlugin = false;
        } else if (CROSSMOBILE_PLUGIN_ID.equals(parentArtifact)) {
            pom.isPlugin = true;
        } else
            return null;
        return pom;
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
                if (dep_array.length == 6) {
                    Dependency dep = PluginRegistry.find(dep_array[0], dep_array[1], dep_array[2], dep_array[3], dep_array[4], dep_array[5]);
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
                    .append(dep.scope == null ? " " : dep.scope).append(":")
                    .append(dep.packaging == null ? " " : dep.packaging).append(";");
        return builder.length() > 0 ? builder.substring(0, builder.length() - 1) : "";
    }

    private Collection<Dependency> getShadowDependencies() {
        Collection<Dependency> deps = new ArrayList<>();
        if (pomWalker.pathExists("/project/dependencies"))
            pomWalker.path("/project/dependencies").nodes("dependency", w -> {
                w.tag();
                deps.add(PluginRegistry.find(
                        w.toTag().nodeExists("groupId") ? w.node("groupId").text() : "",
                        w.toTag().nodeExists("artifactId") ? w.node("artifactId").text() : "",
                        w.toTag().nodeExists("version") ? w.node("version").text() : "",
                        w.toTag().nodeExists("classifier") ? w.node("classifier").text() : "",
                        w.toTag().nodeExists("scope") ? w.node("scope").text() : "",
                        w.toTag().nodeExists("packaging") ? w.node("packaging").text() : ""));
            });
        return deps;
    }

    private Collection<Dependency> getCrossMobileDependencies() {
        Collection<Dependency> deps = new ArrayList<>();
        AtomicBoolean foundTheme = new AtomicBoolean();
        pomWalker.path("/project/dependencies").nodes("dependency",
                w -> w.execIf(c -> c.nodeExists("groupId")
                                && c.nodeExists("artifactId")
                                && (c.node("artifactId").text().startsWith("cmplugin")
                                || c.parent().node("artifactId").text().startsWith("cmtheme")),
                        a -> {
                            Dependency current = PluginRegistry.find(a.tag().node("groupId").text(),
                                    a.toTag().node("artifactId").text(),
                                    a.toTag().nodeExists("version") ? a.node("version").text() : null,
                                    a.toTag().nodeExists("classifier") ? a.node("classifier").text() : null,
                                    a.toTag().nodeExists("scope") ? a.node("scope").text() : null,
                                    a.toTag().nodeExists("packaging") ? a.node("packaging").text() : "");
                            if (current != null) {
                                deps.add(current);
                                if (current.theme)
                                    foundTheme.set(true);
                            }
                        }));
        if (!foundTheme.get())
            deps.add(PluginRegistry.getDefaultTheme());
        return deps;
    }

    public String getNameFromPom() {
        return pomWalker.pathExists("/project/name")
                ? pomWalker.path("/project/name").text()
                : "Unknown" + (isPlugin ? "Plugin" : "Project");
    }

    public void updatePropertiesFromPom(Properties properties) throws ProjectException {
        try {
            pomWalker.
                    path("/project").
                    execIf(w -> w.nodeExists("artifactId"), w -> properties.put(ARTIFACT_ID.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("groupId"), w -> properties.put(GROUP_ID.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("version"), w -> properties.put(BUNDLE_VERSION.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("name"), w -> properties.put(DISPLAY_NAME.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("description"), w -> properties.put(CM_DESCRIPTION.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("url"), w -> properties.put(CM_URL.tag().name, w.last().text())).
                    execIf(w -> w.pathExists("organization/name"), w -> properties.put(CM_VENDOR.tag().name, w.last().text())).
                    execIf(w -> w.nodeExists("properties"), w -> w.node("properties").nodes(p -> properties.put(p.name(), p.last().text())));
            if (!pomWalker.pathExists("/project/groupId"))
                properties.put(GROUP_ID.tag().name, pomWalker.path("/project/parent/groupId").text());
            if (isPlugin)
                properties.put(CM_PLUGINS.tag().name, packDependencies(getShadowDependencies()));
            else
                properties.put(CM_PLUGINS.tag().name, packDependencies(getCrossMobileDependencies()));
        } catch (Exception ex) {
            throw new ProjectException(ex.toString(), ex);
        }
    }

    public boolean isPlugin() {
        return isPlugin;
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
        AtomicBoolean exists = new AtomicBoolean(false);
        pomWalker.path("/project").execIf(w -> !w.nodeExists("profiles"),
                        w -> w.add("profiles").parent())
                .node("profiles").execIf(w -> w.nodeExists("profile"),
                        w -> w.filterNodes("profile",
                                p -> exists.set(true), p -> p.nodeWithTextExists("id", profile)));

        return exists.get();
    }

    private void updateTheme(Dependency theme) {
        pomWalker.path("/project/dependencies").tag().nodes("dependency",
                        d -> d.execIf(n -> n.node("artifactId").text().contains("cmtheme"),
                                XMLWalker::remove
                        )
                ).toTag().add("dependency")
                .add("groupId").setText(theme.groupId).parent()
                .add("artifactId").setText(theme.artifactId).parent()
                .add("version").setText(theme.version.equals(Version.VERSION) ? "${crossmobile.version}" : theme.version);
    }

    private void cleanupParam(Properties properties, ParamsCommon param, String pomparam, String tag) {
        Opt.of(properties.getProperty(param.tag().name)).filter(p -> !p.trim().isEmpty())
                .ifMissing(() -> pomWalker.toTag(tag).execIf(w -> w.nodeExists(pomparam), w -> w.node(pomparam).remove()))
                .ifExists(p -> pomWalker.toTag(tag).execIf(w -> !w.nodeExists(pomparam), w -> w.add(pomparam)).node(pomparam).setText(p));
    }

    public void updatePomFromProperties(ParamSet paramset, Properties properties, boolean isPlugin) {
        pomWalker.
                path("/project").tag("project").
                toTag("project").execIf(w -> !w.nodeExists("groupId"), w -> w.add("groupId")).node("groupId").setText(properties.getProperty(GROUP_ID.tag().name)).
                toTag("project").execIf(w -> !w.nodeExists("artifactId"), w -> w.add("artifactId")).node("artifactId").setText(properties.getProperty(ARTIFACT_ID.tag().name)).
                toTag("project").execIf(w -> !w.nodeExists("version"), w -> w.add("version")).node("version").setText(properties.getProperty(BUNDLE_VERSION.tag().name)).
                toTag("project").execIf(w -> !w.nodeExists("properties"), w -> w.add("properties")).
                node("properties").tag("properties").
                toTag("project").execIf(w -> !w.nodeExists("organization"), w -> w.add("organization")).node("organization").tag("vendor");
        cleanupParam(properties, DISPLAY_NAME, "name", "project");
        cleanupParam(properties, CM_DESCRIPTION, "description", "project");
        cleanupParam(properties, CM_URL, "url", "project");
        cleanupParam(properties, CM_VENDOR, "name", "vendor");
        if (Version.GROUPID.equals(pomWalker.path("/project/groupId").text()))
            pomWalker.path("/project/groupId").remove();
        if (pomWalker.pathExists("/project/organization"))
            pomWalker.path("/project/organization").execIf(xmlWalker -> !xmlWalker.nodeExists(), XMLWalker::remove);

        if (isPlugin)
            injectShadowDependencies(unpackDependencies(properties.getProperty(CM_PLUGINS.tag().name)));
        else
            injectCrossMobileDependencies(unpackDependencies(properties.getProperty(CM_PLUGINS.tag().name)));

        for (Param param : paramset.build()) {
            String newValue = properties.getProperty(param.name, "");
            if (newValue.isEmpty() || newValue.equals(param.deflt))
                pomWalker.toTag("properties").execIf(w -> w.nodeExists(param.name), w -> w.node(param.name).remove());
            else
                pomWalker.toTag("properties").execIf(w -> !w.nodeExists(param.name), w -> w.add(param.name)).node(param.name).setText(newValue);
        }
        pomWalker.toTag("properties").execIf(xmlWalker -> !xmlWalker.nodeExists(), XMLWalker::remove);

        // Update Maven repository from http to https
        pomWalker.path("/project").execIf(w -> w.nodeExists("repositories"), w ->
                w.node("repositories").filterNodes("repository", r -> {
                    if (r.nodeExists("url") && r.node("url").text().toLowerCase().startsWith("http://mvn.crossmobile.org/"))
                        r.setText("https://mvn.crossmobile.org/content/repositories/crossmobile/");
                }));
    }

    private void injectShadowDependencies(List<Dependency> shadowDependencies) {
        updateDependencies(pomWalker.path("/project/dependencies"),
                shadowDependencies.stream().filter(d -> d.groupId.startsWith(SHADOW)),
                null, true,
                w -> w.node("groupId").text().startsWith(SHADOW));
    }

    private void injectCrossMobileDependencies(List<Dependency> dependencies) {
        Predicate<XMLWalker> deletePredicate = w -> w.node("artifactId").text().startsWith("cmplugin-");
        Predicate<Dependency> insertPredicate = dependency -> dependency.cmplugin && !dependency.theme;

        /* Remove obsolete desktop profile, if (obsolete) uwp profile exists */
        AtomicBoolean foundUWP = new AtomicBoolean(false);
        if (pomWalker.pathExists("/project/profiles"))
            pomWalker.path("/project/profiles").nodes("profile", prof -> foundUWP.set(foundUWP.get() || prof.nodeWithTextExists("id", "uwp")));
        if (foundUWP.get())
            pomWalker.path("/project/profiles").nodes("profile", prof -> {
                if (prof.nodeWithTextExists("id", "uwp") || prof.nodeWithTextExists("id", "desktop"))
                    prof.remove();
            });

        updateDependencies(pomWalker.path("/project/dependencies"), dependencies.stream().filter(insertPredicate),
                null, false, deletePredicate);
        for (Flavour flavour : Flavour.values())
            updateDependencies(dependenciesForProfile(flavour.getProfileName()), dependencies.stream().filter(insertPredicate),
                    flavour.getProfileName(), false, deletePredicate);
        dependencies.stream().filter(t -> t.theme).findFirst().ifPresent(this::updateTheme);
    }

    private void updateDependenciesNode(XMLWalker parentNode, String node, String value) {
        if (value == null || value.trim().isEmpty()) {
            if (parentNode.nodeExists(node))
                parentNode.node(node).remove();
        } else {
            if (!parentNode.nodeExists(node))
                parentNode.add(node).parent();
            parentNode.node(node).setText(value);
        }
    }

    private void updateDependencies(XMLWalker walker, Stream<Dependency> dependencies, String profile, boolean plugin, Predicate<XMLWalker> deletePredicate) {
        walker.tag("deproot")
                .execIf(n -> n.nodeExists("dependency"),
                        n -> n.nodes("dependency", d -> d.execIf(deletePredicate, XMLWalker::remove)));
        dependencies.forEach(d -> {
                    walker.toTag("deproot").add("dependency").tag("dep");
                    updateDependenciesNode(walker.toTag("dep"), "groupId", d.groupId);
                    updateDependenciesNode(walker.toTag("dep"), "artifactId", plugin ? d.artifactId : d.profileArtifactId(profile));
                    updateDependenciesNode(walker.toTag("dep"), "version", d.version.equals(Version.VERSION) ? "${crossmobile.version}" : d.version);
                    updateDependenciesNode(walker.toTag("dep"), "classifier", d.classifier);
                    updateDependenciesNode(walker.toTag("dep"), "packaging", d.packaging == null || d.packaging.equals("jar") ? null : d.packaging);
                    updateDependenciesNode(walker.toTag("dep"), "scope", plugin ? d.scope : profile == null ? "provided" : "runtime");
                }
        );
    }

    private File getTemp() {
        return new File(pomFile.getAbsolutePath() + ".new");
    }

    public void saveTemp() {
        pomWalker.store(getTemp(), true);
    }

    public void putInPlace() {
        FileUtils.move(getTemp(), pomFile, null);
    }
}
