/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class ParamSet {

    private final Set<Param> other = new HashSet<>();
    private final Set<Param> build = new HashSet<>();
    private final Set<Param> runtime = new HashSet<>();
    private final Set<Param> local = new HashSet<>();

    {
        for (ParamsCommon p : ParamsCommon.values())
            register(p.tag());
    }

    public void register(Param p) {
        switch (p.type) {
            case SYSTEMRUNTIME:
                runtime.add(p);
                break;
            case BUILD:
                build.add(p);
                break;
            case RUNTIME:
                build.add(p);
                runtime.add(p);
                break;
            case LOCAL:
                local.add(p);
                break;
            default:
            case SYSTEM:
                other.add(p);
                break;
        }
    }

    public void unregister(Param p) {
        other.remove(p);
        build.remove(p);
        runtime.remove(p);
        local.remove(p);
    }

    public Set<Param> local() {
        return local;
    }

    public Set<Param> build() {
        return build;
    }

    public Set<Param> runtime() {
        return runtime;
    }

    public Properties getDefaults() {
        Properties defaults = new Properties();
        for (Param tag : other)
            defaults.put(tag.name, tag.deflt);
        for (Param tag : build)
            defaults.put(tag.name, tag.deflt);
        for (Param tag : runtime)
            defaults.put(tag.name, tag.deflt);
        for (Param tag : local)
            defaults.put(tag.name, tag.deflt);
        return defaults;
    }
}
