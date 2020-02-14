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
package org.crossmobile.plugin.reg;

import org.crossmobile.Version;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.crossmobile.utils.Log;

public class PluginDependency implements Comparable<PluginDependency> {

    private final CMLibDepends depends;
    private final String hostClassName;
    private CMLibTarget target;

    public PluginDependency(CMLibDepends depends, Class host, boolean requireTarget) {
        this.depends = depends;
        this.hostClassName = host.getName();
        if (target() == CMLibTarget.UNKNOWN && requireTarget)
            Log.error("Plugin Dependency " + toString() + " for Class " + hostClassName + ", has invalid target. A Valid target should be specified (i.e. \"target=API\")");
    }

    public CMLibTarget target() {
        if (target == null)
            target = depends.target() != CMLibTarget.UNKNOWN ? depends.target() : TargetRegistry.getTarget(hostClassName);
        return target;
    }

    public boolean isCMPlugin() {
        return depends.isCMPlugin();
    }

    public String pluginName() {
        return depends.pluginName();
    }

    public String type() {
        return depends.type();
    }

    public String groupId() {
        return depends.groupId();
    }

    public String version() {
        return depends.version().equals("") ? Version.VERSION : depends.version();
    }

    public String info() {
        return (isCMPlugin() ? pluginName() : groupId() + "." + pluginName()) + "(" + version() + ")";
    }

    @Override
    public int compareTo(PluginDependency other) {
        if (other == null)
            return -1;
        int s = this.groupId().compareTo(other.groupId());
        if (s != 0)
            return s;
        s = this.pluginName().compareTo(other.pluginName());
        if (s != 0)
            return s;
        return this.type().compareTo(other.type());
    }

    @Override
    public String toString() {
        return "Dependency{" + depends + "}";
    }
}
