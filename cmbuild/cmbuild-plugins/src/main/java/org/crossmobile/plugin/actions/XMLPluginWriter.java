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
package org.crossmobile.plugin.actions;

import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.CMLibParam;
import org.crossmobile.plugin.Repository;
import org.crossmobile.plugin.reg.Plugin;
import org.crossmobile.plugin.reg.PluginParam;
import org.crossmobile.plugin.reg.PluginRegistry;
import org.crossmobile.utils.FileUtils;
import org.crossmobile.utils.XMLWalker;
import org.crossmobile.utils.plugin.DependencyItem;

import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.Regular;

public class XMLPluginWriter {
    public static void updateXML(Repository repository, DependencyItem root) {
        if (repository == null)
            return;
        if (repository.getFile() == null)
            throw new NullPointerException("Please provide the filename of the repository");

        // Load XML if exists
        FileUtils.mkdirs(repository.getFile().getParentFile());
        XMLWalker walker = repository.getFile().isFile() ? XMLWalker.load(repository.getFile()) : null;
        if (walker == null)
            walker = new XMLWalker();
        StrongReference<String> name = new StrongReference<>("");
        StrongReference<String> url = new StrongReference<>("");

        // Find old entries
        walker.node("repositories");
        walker.filterNodes("repository", n -> {
            name.set(n.attribute("name"));
            url.set(n.attribute("url"));
            if (repository.isCleanEntries()) {
                n.remove();
                n.add("repository").tag();
            } else
                n.tag();
        }, p -> repository.getId().equals(p.attribute("id")));

        // Sanity checks
        if (!walker.hasTag())   // Didn't find it - should create it
            walker.node("/repositories").add("repository").tag();
        if (repository.getUrl() != null && !repository.getUrl().trim().isEmpty())
            url.set(repository.getUrl().trim());
        if (repository.getName() != null && !repository.getName().trim().isEmpty())
            name.set(repository.getName().trim());
        if (url.get().isEmpty())
            throw new NullPointerException("Please provide the URL of the repository");
        if (name.get().isEmpty())
            throw new NullPointerException("Please provide the name of the repository");

        // Set Repository configuration
        walker.toTag().setAttribute("id", repository.getId()).
                setAttribute("name", name.get()).
                setAttribute("url", url.get());
        // Create Plugins node
        walker.toTag().execIf(p -> !p.nodeExists("plugin"), e -> e.add("plugins"));
        walker.toTag().node("plugins").tag();

        for (String pluginName : PluginRegistry.plugins()) {
            if (pluginName.equals("cmioslayer"))
                continue;
            Plugin plugin = PluginRegistry.getPluginData(pluginName);
            walker.toTag().add("plugin").tag("p");
            walker.toTag("p").add("groupId").setText(root.getGroupID());
            walker.toTag("p").add("artifactId").setText("cmplugin-" + plugin.getName());
            walker.toTag("p").add("version").setText(root.getVersion());
            walker.toTag("p").add("name").setText(plugin.getDisplayName());
            walker.toTag("p").add("description").setText(plugin.getDescription());
            if (!plugin.getUrl().isEmpty())
                walker.toTag("p").add("url").setText(plugin.getUrl());
            for (String paramName : plugin.getParams()) {
                PluginParam param = plugin.getParam(paramName);
                walker.toTag("p").add("param").tag("m");
                walker.toTag("m").add("property").setText(paramName);
                walker.toTag("m").add("description").setText(param.getDescription().isEmpty() ? paramName : param.getDescription());
                if (!param.getMeta().isEmpty())
                    walker.toTag("m").add("meta").setText(param.getMeta());
                if (param.getContext() != Regular)
                    walker.toTag("m").add("context").setText(param.getContext().name().toLowerCase());
            }
        }
        walker.store(repository.getFile(), true);
    }
}
