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
package org.crossmobile.plugin.reg;

import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.crossmobile.utils.CMVersion;
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
        return depends.version().equals("") ? CMVersion.VERSION : depends.version();
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
