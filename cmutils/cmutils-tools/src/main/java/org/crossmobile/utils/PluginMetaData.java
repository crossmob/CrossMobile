/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.jar.JarFile;

import static org.crossmobile.utils.CollectionUtils.asCollection;
import static org.crossmobile.utils.CollectionUtils.asList;
import static org.crossmobile.utils.TextUtils.iterableToString;
import static org.crossmobile.utils.TextUtils.listFromString;

public class PluginMetaData {

    private static final String LIBS_KEY = "objc.libs";
    private static final String ANDROID_PERMS_KEY = "android.permissions";
    private static final String ANDROID_INJECTIONS_KEY = "android.injections";
    private static final String ANDROID_EXTRA_DEPS_KEY = "android.extra.dependencies";
    private static final String INITIALIZER_KEY = "java.initializer";
    private static final String PODS_KEY = "objc.pods";

    public static final String PLUGIN_LOC = "META-INF/PLUGIN.INF";
    public static final String CURRENT_PLUGIN_REGISTRY = "org/crossmobile/backend/plugins.xml";
    public static final String TOKEN = ";";

    private final Collection<String> libsObjC;
    private final Collection<String> androidPermissions;
    private final Collection<PluginPod> pods;
    private final AndroidInjections androidInjections;
    private final String javaInitializer;
    private final File infile;
    private final Collection<String> androidExtraDependencies;

    public PluginMetaData(File JAR) {
        this(retrieve(JAR), JAR);
    }

    public PluginMetaData(Iterable<String> libsObjC, Iterable<String> androidPermissions, Iterable<PluginPod> pods, AndroidInjections androidInjections, String javaInitializer, Collection<String> androidExtraDependencies) {
        this(asCollection(libsObjC), asCollection(androidPermissions), asCollection(pods), androidInjections, javaInitializer, androidExtraDependencies, null);
    }

    private PluginMetaData(Collection<String> libsObjC, Collection<String> androidPermissions, Collection<PluginPod> pods, AndroidInjections androidInjections, String javaInitializer, Collection<String> androidExtraDependencies, File infile) {
        this.libsObjC = libsObjC;
        this.androidPermissions = androidPermissions;
        this.androidInjections = androidInjections;
        this.javaInitializer = javaInitializer;
        this.androidExtraDependencies = androidExtraDependencies;
        this.infile = infile;
        this.pods = pods;
    }

    private PluginMetaData(Properties props, File infile) {
        this(
                listFromString(props.getProperty(LIBS_KEY, ""), TOKEN),
                listFromString(props.getProperty(ANDROID_PERMS_KEY, ""), TOKEN),
                asList(listFromString(props.getProperty(PODS_KEY, ""), TOKEN), PluginPod::unfreeze),
                new AndroidInjections(props.getProperty(ANDROID_INJECTIONS_KEY, "")),
                props.getProperty(INITIALIZER_KEY, ""),
                listFromString(props.getProperty(ANDROID_EXTRA_DEPS_KEY, ""), TOKEN),
                infile);
    }

    public Collection<String> getObjCLibs() {
        return libsObjC;
    }

    public Collection<PluginPod> getPods() {
        return pods;
    }

    public Collection<? extends String> getPermissions() {
        return androidPermissions;
    }

    public AndroidInjections getAndroidInjections() {
        return androidInjections;
    }

    public String getJavaInitializer() {
        return javaInitializer;
    }

    public File getFile() {
        return infile;
    }

    public Collection<String> getAndroidExtraDependencies() {
        return androidExtraDependencies;
    }

    public String getProperties(String comment) {
        Map<String, String> props = new LinkedHashMap<>();
        props.put(LIBS_KEY, iterableToString(libsObjC, TOKEN));
        props.put(INITIALIZER_KEY, javaInitializer);
        props.put(PODS_KEY, iterableToString(pods, TOKEN, PluginPod::freeze));
        props.put(ANDROID_PERMS_KEY, iterableToString(androidPermissions, TOKEN));
        props.put(ANDROID_INJECTIONS_KEY, androidInjections.toString());
        props.put(ANDROID_EXTRA_DEPS_KEY, iterableToString(androidExtraDependencies, TOKEN));
        return PropertiesUtils.mapToString(props, comment);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("PluginMetaData[");
        if (!libsObjC.isEmpty())
            out.append(LIBS_KEY).append("=").append(iterableToString(libsObjC, TOKEN)).append(' ');
        if (!androidPermissions.isEmpty())
            out.append(ANDROID_PERMS_KEY).append("=").append(iterableToString(androidPermissions, TOKEN)).append(' ');
        if (!javaInitializer.trim().isEmpty())
            out.append(INITIALIZER_KEY).append("=").append(javaInitializer).append(' ');
        if (!androidInjections.isEmpty())
            out.append(ANDROID_INJECTIONS_KEY).append("='").append(androidInjections.toString()).append("' ");
        if (!androidExtraDependencies.isEmpty())
            out.append(ANDROID_EXTRA_DEPS_KEY).append("=").append(iterableToString(androidExtraDependencies, TOKEN)).append(' ');
        if (!pods.isEmpty())
            out.append(PODS_KEY).append("='").append(iterableToString(asList(pods, PluginPod::freeze), TOKEN)).append("' ");
        if (out.charAt(out.length() - 1) == ' ')
            out.delete(out.length() - 1, out.length());
        out.append("]");
        return out.toString();
    }

    private static Properties retrieve(File JAR) {
        Properties props = new Properties();
        try (JarFile jar = new JarFile(JAR); InputStreamReader in = new InputStreamReader(jar.getInputStream(jar.getEntry(PLUGIN_LOC)), StandardCharsets.UTF_8)) {
            props.load(in);
        } catch (Exception ignored) {
        }
        return props;
    }
}
