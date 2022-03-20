/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.bridge.ann.CMLibParam.ParamContext;
import org.crossmobile.bridge.system.Pair;

import java.util.Objects;

import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.Regular;
import static org.crossmobile.bridge.system.Pair.pair;
import static org.crossmobile.utils.TextUtils.getPairedParams;

public class DependencyParam implements Comparable<DependencyParam> {

    public final String description;
    public final String fullname;
    public final String meta;
    public final ParamContext context;
    public final Param param;

    public DependencyParam(String fullname, String description, String paramMeta, ParamContext paramContext) {
        this.fullname = fullname;
        this.description = description == null ? fullname : description;
        this.meta = paramMeta == null ? "" : paramMeta.trim();
        this.context = paramContext == null ? Regular : paramContext;
        param = new Param(true, this.fullname, null, "", this.meta, this.context, Param.TagType.RUNTIME);
    }

    @Override
    public int compareTo(DependencyParam o) {
        return description.compareTo(o.description);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.fullname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final DependencyParam other = (DependencyParam) obj;
        return Objects.equals(this.fullname, other.fullname);
    }

    @Override
    public String toString() {
        String extra = getPairedParams("=", ", ", pair("context", context == Regular ? null : context.name()), pair("meta", meta));
        return fullname + "{description='" + description + (extra.isEmpty() ? "" : " " + extra) + '}';
    }

}
