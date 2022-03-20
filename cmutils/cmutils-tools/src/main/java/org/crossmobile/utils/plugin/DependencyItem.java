/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.plugin;

import org.crossmobile.utils.PluginMetaData;

import java.io.File;
import java.util.*;

import static org.crossmobile.utils.CollectionUtils.asList;

public class DependencyItem implements Comparable<DependencyItem> {

    private final String groupID;
    private final String artifactID;
    private final String version;
    private final String type;
    private final File file;

    private final Set<DependencyItem> runtime = new TreeSet<>();
    private final Set<DependencyItem> compile = new TreeSet<>();

    public DependencyItem() {
        this.groupID = null;
        this.artifactID = null;
        this.version = null;
        this.type = null;
        this.file = null;
    }

    public DependencyItem(String groupID, String artifact, String version, String type, File file) {
        this.groupID = groupID == null ? "" : groupID;
        this.artifactID = artifact;
        this.version = version == null ? "" : version;
        this.type = type == null ? "" : type;
        this.file = file;
    }

    private DependencyItem add(String groupId, String artifactId, String version, String type, Set<DependencyItem> where, File file) {
        DependencyItem item = new DependencyItem(groupId, artifactId, version, type, file);
        where.add(item);
        return item;
    }

    public DependencyItem addCompiletime(String groupId, String artifactId, String version, String type, File file) {
        return add(groupId, artifactId, version, type, compile, file);
    }

    public DependencyItem addRuntime(String groupId, String artifactId, String version, String type, File file) {
        return add(groupId, artifactId, version, type, runtime, file);
    }

    private Collection<DependencyItem> getAllCompile(boolean recursively) {
        if (recursively) {
            Collection<DependencyItem> result = new TreeSet<>();
            for (DependencyItem item : compile) {
                result.add(item);
                result.addAll(item.getAllCompile(recursively));
            }
            return result;
        } else
            return new TreeSet<>(compile);
    }

    private Collection<DependencyItem> getAllRuntime(boolean recursively) {
        if (recursively) {
            Collection<DependencyItem> result = new TreeSet<>();
            for (DependencyItem item : runtime) {
                result.add(item);
                result.addAll(item.getAllRuntime(recursively));
            }
            return result;
        } else
            return new TreeSet<>(runtime);
    }

    public Iterable<PluginMetaData> getPluginMetaData() {
        return asList(getCompiletimeDependencies(true), d -> new PluginMetaData(d.getFile()));
    }

    public Iterable<DependencyItem> getCompiletimeDependencies(boolean recursively) {
        return getAllCompile(recursively);
    }

    public Iterable<DependencyItem> getRuntimeDependencies(boolean recursively) {
        return getAllRuntime(recursively);
    }

    public Iterable<DependencyItem> getCompileOnlyDependencies(boolean recursively) {
        Collection<DependencyItem> result = getAllCompile(recursively);
        result.removeAll(getAllRuntime(recursively));
        return result;
    }

    public Iterable<DependencyItem> getCompileAndRuntimeDependencies(boolean recursively) {
        Collection<DependencyItem> result = getAllCompile(recursively);
        result.retainAll(getAllRuntime(recursively));
        return result;
    }

    public Iterable<DependencyItem> getRuntimeOnlyDependencies(boolean recursively) {
        Collection<DependencyItem> result = getAllRuntime(recursively);
        result.removeAll(getAllCompile(recursively));
        return result;
    }

    public String getGroupID() {
        return groupID;
    }

    public String getArtifactID() {
        return artifactID;
    }

    public String getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }

    public File getFile() {
        return file;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass())
                && ((DependencyItem) obj).artifactID.equals(artifactID)
                && ((DependencyItem) obj).groupID.equals(groupID)
                && ((DependencyItem) obj).version.equals(version)
                && ((DependencyItem) obj).type.equals(type);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.artifactID);
        hash = 13 * hash + Objects.hashCode(this.groupID);
        hash = 13 * hash + Objects.hashCode(this.version);
        hash = 13 * hash + Objects.hashCode(this.type);
        return hash;
    }

    @Override
    public String toString() {
        return groupID + ":" + artifactID + ":" + version + ":" + type;
    }

    @Override
    public int compareTo(DependencyItem o) {
        int cmp = artifactID.compareTo(o.artifactID);
        if (cmp != 0)
            return cmp;
        cmp = groupID.compareTo(o.groupID);
        if (cmp != 0)
            return cmp;
        cmp = version.compareTo(o.version);
        if (cmp != 0)
            return cmp;
        return type.compareTo(o.type);
    }

}
