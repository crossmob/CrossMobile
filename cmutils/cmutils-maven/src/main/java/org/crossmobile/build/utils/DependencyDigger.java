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
package org.crossmobile.build.utils;

import org.apache.maven.artifact.resolver.filter.ScopeArtifactFilter;
import org.apache.maven.execution.MavenSession;
import org.apache.maven.project.DefaultProjectBuildingRequest;
import org.apache.maven.project.MavenProject;
import org.apache.maven.project.ProjectBuildingRequest;
import org.apache.maven.shared.dependency.graph.DependencyGraphBuilder;
import org.apache.maven.shared.dependency.graph.DependencyGraphBuilderException;
import org.apache.maven.shared.dependency.graph.DependencyNode;
import org.apache.maven.shared.dependency.graph.traversal.DependencyNodeVisitor;
import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.build.ArtifactInfo;
import org.crossmobile.utils.Log;
import org.crossmobile.utils.plugin.DependencyItem;
import org.crossmobile.utils.plugin.DependencyTreeConsumer;

import java.io.File;
import java.util.Stack;
import java.util.function.Function;

public class DependencyDigger {
    //   Lazy initialization of dependencies 

    private static DependencyItem root;

    public static DependencyItem getDependencyTree(MavenProject mavenProject, MavenSession mavenSession, DependencyGraphBuilder dependencyGraphBuilder, Function<ArtifactInfo, File> resolver, boolean shouldResolveRoot) {
        if (root == null) {
            root = new DependencyItem(mavenProject.getGroupId(), mavenProject.getArtifactId(), mavenProject.getVersion(), mavenProject.getPackaging(),
                    shouldResolveRoot ? resolver.apply(new ArtifactInfo(mavenProject.getGroupId(), mavenProject.getArtifactId(), mavenProject.getVersion(), mavenProject.getPackaging())) : null);
            parseTree("compile", DependencyItem::addCompiletime, mavenProject, mavenSession, dependencyGraphBuilder, resolver);
            parseTree("runtime", DependencyItem::addRuntime, mavenProject, mavenSession, dependencyGraphBuilder, resolver);
            Log.debug("Compile time dependencies: " + root.getCompiletimeDependencies(true).toString());
            Log.debug("Run time dependencies: " + root.getRuntimeDependencies(true).toString());
        }
        return root;
    }

    private static void parseTree(String scope, DependencyTreeConsumer appender, MavenProject mavenProject, MavenSession mavenSession, DependencyGraphBuilder dependencyGraphBuilder, Function<ArtifactInfo, File> resolver) {
        try {
            ProjectBuildingRequest buildingRequest = new DefaultProjectBuildingRequest(mavenSession.getProjectBuildingRequest());
            buildingRequest.setProject(mavenProject);
            DependencyNode dnRoot = dependencyGraphBuilder.buildDependencyGraph(buildingRequest, new ScopeArtifactFilter(scope));
            Stack<DependencyItem> stack = new Stack<>();
            DependencyItem ignore = new DependencyItem();
            dnRoot.accept(new DependencyNodeVisitor() {

                @Override
                public boolean visit(DependencyNode dn) {
                    org.apache.maven.artifact.Artifact a = dn.getArtifact();
                    if (dn.equals(dnRoot))
                        stack.add(root);
                    else {
                        DependencyItem item = appender.resolve(stack.peek(), a.getGroupId(), a.getArtifactId(), a.getVersion(), a.getType(),
                                resolver.apply(new ArtifactInfo(a.getGroupId(), a.getArtifactId(), a.getVersion(), a.getType())));
                        stack.push(item == null ? ignore : item);
                    }
                    return true;
                }

                @Override
                public boolean endVisit(DependencyNode dn) {
                    stack.pop();
                    return true;
                }
            });

        } catch (DependencyGraphBuilderException ex) {
            BaseUtils.throwException(ex);
        }
    }
}
