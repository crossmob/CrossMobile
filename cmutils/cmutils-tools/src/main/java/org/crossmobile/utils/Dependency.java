/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.Version;
import org.crossmobile.bridge.ann.CMLibParam.ParamContext;

import java.io.ByteArrayInputStream;
import java.util.*;

import static org.crossmobile.utils.CollectionUtils.asList;
import static org.crossmobile.utils.Pom.CROSSMOBILE_GROUP_ID;
import static org.crossmobile.utils.Pom.CROSSMOBILE_THEME_ID;

public class Dependency {

    private final static Map<String, List<Dependency>> PLUGINS = new TreeMap<>();
    private final static Map<String, List<Dependency>> THEMES = new TreeMap<>();
    private final static List<DesktopSkin> SKINS = new ArrayList<>();

    private static Dependency DEFAULT_THEME = new Dependency(CROSSMOBILE_GROUP_ID, CROSSMOBILE_THEME_ID, Version.VERSION, null, null, null, null, null, null);

    private static XMLWalker loadWalker(String localresourse) {
        String resource = FileUtils.readResourceSafe(localresourse);
        if (resource == null)
            Log.error("Unable to load XML from " + localresourse);
        return resource == null ? null : XMLWalker.load(new ByteArrayInputStream(resource.getBytes()));
    }

    public static Collection<DesktopSkin> getSystemSkins() {
        if (SKINS.isEmpty()) {
            XMLWalker walker = loadWalker("plugins/baseskins.xml");
            try {
                if (walker != null)
                    walker.path("/skins").nodes("skin", skin
                            -> SKINS.add(new DesktopSkin(skin.node("name").text(), skin.parent().node("info").text(), skin.parent().node("description").text())));
            } catch (Exception ex) {
            } finally {
                if (walker == null)
                    SKINS.add(new DesktopSkin("phone", "Phone", "A phone-like skin"));
            }
        }
        return SKINS;
    }

    private static void initSystemDependencies() {
        if (!THEMES.isEmpty())
            return;
        XMLWalker walker = loadWalker("plugins/baseplugins.xml");
        if (walker == null)
            THEMES.put("Default Theme", Collections.singletonList(DEFAULT_THEME));
        else
            walker.path("/repositories").nodes("repository", r -> {
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
                            null,
                            p.toTag().node("name").text(),
                            p.toTag().node("description").text(),
                            p.toTag().nodeExists("url") ? p.toTag().node("url").text() : null,
                            params.isEmpty() ? null : Collections.unmodifiableCollection(params));
                    (d.theme ? THEMES : PLUGINS).computeIfAbsent(repoName, k -> new ArrayList<>()).add(d);
                    if (d.artifactId.equals(CROSSMOBILE_THEME_ID))
                        DEFAULT_THEME = d;
                });
            });
    }

    public static List<Dependency> getSystemPlugins() {
        initSystemDependencies();
        return asList(PLUGINS);
    }

    public static List<Dependency> getSystemThemes() {
        initSystemDependencies();
        return asList(THEMES);
    }

    public static Map<String, List<Dependency>> getCategorizedSystemPlugins() {
        return PLUGINS;
    }

    public static Map<String, List<Dependency>> getCategorizedSystemThemes() {
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
    public final String scope;
    public final String name;
    public final String description;
    public final String url;
    public final boolean cmplugin;
    public final boolean theme;
    private final Collection<DependencyParam> configParams;

    public static Dependency find(String groupId, String artifactId, String version, String classifier, String scope) {
        if (groupId == null || groupId.trim().isEmpty()
                || artifactId == null || artifactId.trim().isEmpty())
            return null;
        Dependency system = findSystemDependency(groupId, artifactId);
        return system == null ? new Dependency(groupId, artifactId, version, classifier, scope, null, null, null, null) : system;
    }

    private Dependency(String groupId, String artifactId, String version, String classifier, String scope, String name, String description, String url, Collection<DependencyParam> configParams) {
        // Already checked parameters
        this.groupId = groupId.trim();
        this.artifactId = artifactId.trim();
        // Unchecked parameters
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

    public String artifactId(String profile) {
        return "cmplugin" + (profile == null ? "" : "-" + profile) + artifactId.replaceFirst("cmplugin", "");
    }

    @Override
    public String toString() {
        return name == null ? (description == null ? groupId + ":" + artifactId + (version == null ? "" : (":" + version)) : description) : name;
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
        if (this.cmplugin == true && dep.cmplugin == true)
            return this.groupId.equals(dep.groupId) && this.artifactId.equals(dep.artifactId);
        else if (this.cmplugin == false && dep.cmplugin == false)
            return this.groupId.equals(dep.groupId)
                    && this.artifactId.equals(dep.artifactId)
                    && (this.scope != null ? this.scope.equals(dep.scope) : dep.scope == null)
                    && (this.classifier != null ? this.classifier.equals(dep.classifier) : dep.classifier == null);
        else
            return false;
    }

}
