/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.plugin;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
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
    public void exec() throws MojoExecutionException, MojoFailureException {
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
