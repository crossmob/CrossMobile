/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.Version;
import org.crossmobile.backend.desktop.DesktopLocations;
import org.crossmobile.bridge.ann.CMLibParam.ParamContext;
import org.crossmobile.utils.func.Opt;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static org.crossmobile.backend.desktop.ResourceResolver.getResources;
import static org.crossmobile.backend.desktop.ResourceResolver.getSkinFiles;
import static org.crossmobile.utils.CollectionUtils.allValues;
import static org.crossmobile.utils.Pom.CROSSMOBILE_THEME_ID;

public class Dependency implements Comparable<Dependency> {

    private static Map<String, Collection<Dependency>> PLUGINS;
    private static Map<String, Collection<Dependency>> THEMES;
    private static List<DesktopSkin> SKINS;

    private static Dependency DEFAULT_THEME = new Dependency(Version.GROUPID, CROSSMOBILE_THEME_ID, Version.VERSION, null, null, null, null, null, null, null);

    public static Collection<DesktopSkin> getSystemSkins() {
        if (SKINS == null) {
            SKINS = new ArrayList<>();
            for (String name : getSkinFiles()) {
                XMLWalker skin = XMLWalker.load(Dependency.class.getResourceAsStream(DesktopLocations.SKINS + name));
                if (skin != null && skin.pathExists("/chassis/meta")) {
                    skin.path("/chassis/meta");
                    int priority = 100;
                    try {
                        priority = Integer.parseInt(skin.attribute("priority"));
                    } catch (Exception ignored) {
                    }
                    if (priority >= 0)
                        SKINS.add(new DesktopSkin(name.substring(0, name.length() - 4), skin.attribute("info"), skin.attribute("descr"), priority));
                }
            }
            if (SKINS.isEmpty())
                SKINS.add(new DesktopSkin("system", "Default", "Default System application", 0));
            else
                SKINS.sort(comparingInt(o -> o.priority));
        }
        return SKINS;
    }

    private static void initSystemDependencies() {
        if (THEMES != null)
            return;
        THEMES = new TreeMap<>();
        PLUGINS = new TreeMap<>();
        getResources("plugins/baseplugins.xml", inputStream -> Opt.of(XMLWalker.load(inputStream)).ifExists(walker -> walker
                .path("/repositories").nodes("repository", r -> {
                    String repoName = r.attribute("name");
                    r.node("plugins").nodes("plugin", p -> {
                        Collection<DependencyParam> params = new LinkedHashSet<>();
                        p.tag();
                        String groupId = p.toTag().node("groupId").text();
                        String artifactId = p.toTag().node("artifactId").text();
                        p.toTag().filterNodes("param", pr -> {
                            pr.tag("p");
                            String property = pr.nodeExists("property") ? pr.node("property").text().trim() : null;
                            String description = pr.toTag("p").nodeExists("description") ? pr.node("description").text().trim() : null;
                            String paramMeta = pr.toTag("p").nodeExists("meta") ? pr.node("meta").text().trim() : null;
                            ParamContext paramContext = pr.toTag("p").nodeExists("context") ? ParamContext.retrieve(pr.node("context").text()) : null;
                            DependencyParam param = new DependencyParam(groupId + "." + artifactId + "." + property, description, paramMeta, paramContext);
                            params.add(param);
                        });
                        Dependency d = new Dependency(groupId, artifactId,
                                p.toTag().node("version").text(),
                                p.toTag().nodeExists("classifier") ? p.node("classifier").text() : null,
                                p.toTag().nodeExists("packaging") ? p.node("packaging").text() : null,
                                p.toTag().nodeExists("scope") ? p.node("scope").text() : null,
                                p.toTag().node("name").text(),
                                p.toTag().node("description").text(),
                                p.toTag().nodeExists("url") ? p.toTag().node("url").text() : null,
                                params.isEmpty() ? null : Collections.unmodifiableCollection(params));
                        (d.theme ? THEMES : PLUGINS).computeIfAbsent(repoName, k -> new ArrayList<>()).add(d);
                        if (d.artifactId.equals(CROSSMOBILE_THEME_ID))
                            DEFAULT_THEME = d;
                    });
                })));
        if (THEMES.isEmpty())
            THEMES.put("Default Theme", Collections.singletonList(DEFAULT_THEME));
    }

    public static Iterable<Dependency> getSystemPlugins() {
        initSystemDependencies();
        return allValues(PLUGINS);
    }

    public static Iterable<Dependency> getSystemThemes() {
        initSystemDependencies();
        return allValues(THEMES);
    }

    public static Map<String, Collection<Dependency>> getCategorizedSystemPlugins() {
        return PLUGINS;
    }

    public static Map<String, Collection<Dependency>> getCategorizedSystemThemes() {
        return THEMES;
    }

    public static Dependency findSystemDependency(String groupId, String artifactId) {
        if (groupId == null)
            groupId = "org.crossmobile";
        for (Dependency plugin : getSystemPlugins())
            if (plugin.groupId.equals(groupId) && plugin.artifactId.equals(artifactId))
                return plugin;
        for (Dependency theme : getSystemThemes())
            if (theme.groupId.equals(groupId) && theme.artifactId.equals(artifactId))
                return theme;
        return null;
    }

    /**
     * @param theme Could be null to return the default theme
     * @return System theme
     */
    public static Dependency getSystemTheme(String theme) {
        if (theme == null)
            return DEFAULT_THEME;
        for (Dependency systheme : getSystemThemes())
            if (systheme.artifactId.equals(theme))
                return systheme;
        return DEFAULT_THEME;
    }

    public final String groupId;
    public final String artifactId;
    public final String version;
    public final String classifier;
    public final String packaging;
    public final String scope;
    public final String name;
    public final String description;
    public final String url;
    public final boolean cmplugin;
    public final boolean theme;
    private final Collection<DependencyParam> configParams;

    public static Dependency find(String groupId, String artifactId, String version, String classifier, String scope, String packaging) {
        if (groupId == null || groupId.trim().isEmpty()
                || artifactId == null || artifactId.trim().isEmpty())
            return null;
        Dependency system = findSystemDependency(groupId, artifactId);
        return system == null ? new Dependency(groupId, artifactId, version, classifier, packaging, scope, null, null, null, null) : system;
    }

    private Dependency(String groupId, String artifactId, String version, String classifier, String packaging, String scope, String name, String description, String url, Collection<DependencyParam> configParams) {
        // Already checked parameters
        this.groupId = groupId.trim();
        this.artifactId = artifactId.trim();
        // Unchecked parameters
        this.packaging = packaging == null || packaging.trim().isEmpty() ? null : packaging.trim();
        this.cmplugin = this.artifactId.startsWith("cmplugin");
        this.version = version == null || version.isEmpty() ? null : version.trim();
        this.classifier = classifier == null || classifier.trim().isEmpty() ? null : classifier.trim();
        this.scope = scope == null || scope.trim().isEmpty() ? null : scope.trim();
        this.name = name == null || name.trim().isEmpty() ? null : name.trim();
        this.description = description == null || description.trim().isEmpty() ? null : description.trim();
        this.url = url == null || url.trim().isEmpty() ? null : url.trim();
        this.theme = this.artifactId.startsWith("cmtheme");
        this.configParams = configParams == null ? Collections.emptyList() : configParams;
    }

    public Collection<DependencyParam> getConfigParams() {
        return configParams;
    }

    public String profileArtifactId(String profile) {
        return "cmplugin" + (profile == null ? "" : "-" + profile) + artifactId.replaceFirst("cmplugin", "");
    }

    @Override
    public String toString() {
        return name == null ? (description == null ? groupId + ":" + artifactId + (packaging == null || packaging.equals("jar") ? "" : ":" + packaging)
                + (version == null ? "" : (":" + version)) : description) : name;
    }

    public String getInformation() {
        StringBuilder info = new StringBuilder();
        if (description != null)
            info.append(description).append("\n(").append(getFullArtifact()).append(")");
        else
            info.append("GroupId : ").append(groupId).append("\nArtifactId : ").append(artifactId).append("\nVersion : ").append(version);
        return info.toString();
    }

    public String getDisplayName() {
        return name == null ? getFullArtifact() : name;
    }

    public String getFullArtifact() {
        return groupId + ":" + artifactId + ":" + version;
    }

    public boolean isSame(Dependency dep) {
        if (this.cmplugin && dep.cmplugin)
            return this.groupId.equals(dep.groupId) && this.artifactId.equals(dep.artifactId);
        else if (!this.cmplugin && !dep.cmplugin)
            return this.groupId.equals(dep.groupId)
                    && this.artifactId.equals(dep.artifactId)
                    && (Objects.equals(this.scope, dep.scope))
                    && (Objects.equals(this.classifier, dep.classifier));
        else
            return false;
    }

    @Override
    public int compareTo(Dependency other) {
        int artifactComp = this.artifactId.compareTo(other.artifactId);
        return artifactComp != 0 ? artifactComp : this.groupId.compareTo(other.artifactId);
    }
}
