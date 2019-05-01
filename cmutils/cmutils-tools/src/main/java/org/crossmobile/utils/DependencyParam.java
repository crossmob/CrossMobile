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
