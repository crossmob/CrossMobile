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
package org.crossmobile.build;

import org.codehaus.plexus.util.FileUtils;

import java.io.File;

public class ArtifactInfo {

    public final File source;
    public final String groupId;
    public final String artifactId;
    public final String version;
    public final File pomFile;
    public final String packaging;

    public ArtifactInfo(String groupid, String artifactid, String version, String packaging) {
        this(null, groupid, artifactid, version, packaging, null);
    }

    public ArtifactInfo(File fileToInstall, String groupid, String artifactid, String version, File pomfile) {
        this(fileToInstall, groupid, artifactid, version, FileUtils.extension(fileToInstall.getName()), pomfile);
    }

    public ArtifactInfo(File fileToInstall, String groupid, String artifactid, String version, String packaging, File pomfile) {
        this.source = fileToInstall;
        this.groupId = groupid;
        this.artifactId = artifactid;
        this.version = version;
        this.packaging = packaging;
        this.pomFile = pomfile;
    }

    @Override
    public String toString() {
        return "ArtifactInfo{groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version + ", packaging=" + packaging + '}';
    }
}
