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
package org.crossmobile.plugin;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.crossmobile.build.ArtifactInfo;
import org.crossmobile.build.GenericMojo;
import org.crossmobile.build.utils.MojoLogger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;

@Mojo(name = "deploy", defaultPhase = LifecyclePhase.DEPLOY, requiresDependencyResolution = ResolutionScope.COMPILE)
public class DeployMojo extends GenericMojo {

    static final Collection<ArtifactInfo> deployableArtifacts = new LinkedHashSet<>();
    @Parameter(property = "repositoryId")
    private String repositoryId;

    @Parameter(property = "url")
    private String url;

    @Override
    public void exec() {
        MojoLogger.register(getLog());

        if (repositoryId == null)
            repositoryId = getProject().getDistributionManagementArtifactRepository().getId();
        if (url == null)
            url = getProject().getDistributionManagementArtifactRepository().getUrl();

        Collection<ArtifactInfo> toDeploy = new ArrayList<>();
        synchronized (deployableArtifacts) {
            toDeploy.addAll(deployableArtifacts);
            deployableArtifacts.clear();
        }
        for (ArtifactInfo info : toDeploy)
            if (!deployArtifact(info, repositoryId, url))
                break;
    }
}
