/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.Version;
import org.crossmobile.bridge.ann.CMLibParam;
import org.crossmobile.utils.func.Opt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import static org.crossmobile.utils.CollectionUtils.allValues;
import static org.crossmobile.utils.CollectionUtils.filter;
import static org.crossmobile.utils.Pom.CROSSMOBILE_THEME_ID;

public class PluginRegistry {

    private static final PluginRegistry current = new PluginRegistry();

    private final Map<String, Collection<Dependency>> PLUGINS = new TreeMap<>();
    private final Map<Dependency, File> INV_PLUGINS = new TreeMap<>();
    private final Collection<Dependency> THEMES = new TreeSet<>();
    private final Collection<DesktopSkin> SKINS = new TreeSet<>(Comparator.comparingInt(o -> o.priority));
    private final Dependency DEFAULT_THEME = new Dependency(Version.GROUPID, CROSSMOBILE_THEME_ID, Version.VERSION, null, null, null, null, null, null, null);

    public static void importFilePlugin(File xmlFile) {
        if (xmlFile.getName().endsWith(".xml"))
            try (FileInputStream in = new FileInputStream(xmlFile)) {
                importPlugin(in, xmlFile);
            } catch (IOException e) {
                Log.error(e);
            }
    }

    public static void importJarPlugin(File jarFile, String entry) {
        try (JarInputStream jarStream = new JarInputStream(new FileInputStream(jarFile))) {
            JarEntry jarEntry = jarStream.getNextJarEntry();
            while (jarEntry != null) {
                String name = jarEntry.getName();
                if (name.equals(entry)) {
                    importPlugin(jarStream);
                    return;
                }
                jarEntry = jarStream.getNextJarEntry();
            }
        } catch (IOException e) {
            Log.error(e);
        }
    }

    public static void importPlugin(InputStream inputStream) {
        importPlugin(inputStream, null);
    }

    private static void importPlugin(InputStream inputStream, File origin) {
        Opt.of(XMLWalker.load(inputStream)).ifExists(walker -> {
            if (walker.pathExists("/skins"))
                current.addSkinResource(walker);
            else if (walker.pathExists("/plugins"))
                current.addPluginResource(walker, origin);
        });
    }

    private void addSkinResource(XMLWalker walker) {
        walker.path("/skins").nodes("skin", w -> {
            String name = w.attribute("name");
            w.node("meta");
            int priority = 100;
            try {
                priority = Integer.parseInt(walker.attribute("priority"));
            } catch (Exception ignored) {
            }
            SKINS.add(new DesktopSkin(name, w.attribute("info"), w.attribute("descr"), priority));
        });
    }

    private void addPluginResource(XMLWalker walker, File origin) {
        walker.node("plugins");
        String type = walker.attribute("type");
        walker.nodes("plugin", p -> {
            Collection<DependencyParam> params = new LinkedHashSet<>();
            p.tag();
            String groupId = p.toTag().node("groupId").text();
            String artifactId = p.toTag().node("artifactId").text();
            p.toTag().filterNodes("param", pr -> {
                pr.tag("p");
                String property = pr.nodeExists("property") ? pr.node("property").text().trim() : null;
                String description = pr.toTag("p").nodeExists("description") ? pr.node("description").text().trim() : null;
                String paramMeta = pr.toTag("p").nodeExists("meta") ? pr.node("meta").text().trim() : null;
                CMLibParam.ParamContext paramContext = pr.toTag("p").nodeExists("context") ? CMLibParam.ParamContext.retrieve(pr.node("context").text()) : null;
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
            if (d.theme)
                THEMES.add(d);
            else {
                PLUGINS.computeIfAbsent(type, k -> new TreeSet<>()).add(d);
                if (origin != null)
                    INV_PLUGINS.put(d, origin.getAbsoluteFile());
            }
        });
    }

    public static Collection<DesktopSkin> getSkins() {
        if (current.SKINS.isEmpty())
            throw new NullPointerException("Skins not initialized");
        return current.SKINS;
    }

    public static Iterable<Dependency> getPlugins() {
        if (current.PLUGINS.isEmpty())
            throw new NullPointerException("System plugins not initialized");
        return allValues(current.PLUGINS);
    }

    public static Iterable<Dependency> getExternalPlugins() {
        if (current.PLUGINS.isEmpty())
            throw new NullPointerException("System plugins not initialized");
        Map<String, Collection<Dependency>> externals = new TreeMap<>(current.PLUGINS);
        externals.remove("core");
        return allValues(externals);
    }

    public static void removeExternalPlugin(Dependency dep) {
        File file = current.INV_PLUGINS.get(dep);
        if (file != null) {
            Collection<Dependency> toRemove = new HashSet<>();
            current.INV_PLUGINS.forEach((key, value) -> {
                if (file.equals(value))
                    toRemove.add(key);
            });
            toRemove.forEach(other -> {
                current.INV_PLUGINS.remove(other);
                current.PLUGINS.forEach((key, value) -> {
                    if (!"core".equals(key))
                        value.remove(other);
                });
            });
            FileUtils.delete(file);
        }
    }

    public static Iterable<Dependency> getThemes() {
        if (current.THEMES.isEmpty())
            throw new NullPointerException("System themes not initialized");
        return current.THEMES;
    }

    public static Map<String, Collection<Dependency>> getCategorizedSystemPlugins() {
        return current.PLUGINS;
    }

    public static Map<String, Collection<Dependency>> getCategorizedSystemThemes() {
        return Collections.singletonMap("theme", current.THEMES);
    }

    public static Dependency findSystemDependency(String groupId, String artifactId) {
        if (groupId == null)
            groupId = Version.GROUPID;
        for (Dependency plugin : getPlugins())
            if (plugin.groupId.equals(groupId) && plugin.artifactId.equals(artifactId))
                return plugin;
        for (Dependency theme : getThemes())
            if (theme.groupId.equals(groupId) && theme.artifactId.equals(artifactId))
                return theme;
        return null;
    }

    public static Dependency getDefaultTheme() {
        return current.DEFAULT_THEME;
    }

    public static Dependency find(String groupId, String artifactId, String version, String classifier, String scope, String packaging) {
        if (groupId == null || groupId.trim().isEmpty()
                || artifactId == null || artifactId.trim().isEmpty())
            return null;
        Dependency system = findSystemDependency(groupId, artifactId);
        return system == null ? new Dependency(groupId, artifactId, version, classifier, packaging, scope, null, null, null, null) : system;
    }
}
