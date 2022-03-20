/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Dependency implements Comparable<Dependency> {

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

    Dependency(String groupId, String artifactId, String version, String classifier, String packaging, String scope, String name, String description, String url, Collection<DependencyParam> configParams) {
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
        return artifactComp != 0 ? artifactComp : this.groupId.compareTo(other.groupId);
    }
}
