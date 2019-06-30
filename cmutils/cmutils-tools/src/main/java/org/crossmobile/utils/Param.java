/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.utils;

import java.util.Objects;

import static org.crossmobile.bridge.ann.CMLibParam.ParamContext;
import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.Regular;
import static org.crossmobile.bridge.system.Pair.pair;
import static org.crossmobile.utils.TextUtils.getPairedParams;

public class Param {

    public final boolean ommitIfMissing;
    public final String name;
    public final String anchor;
    public final String meta;
    public final ParamContext context;
    public final String deflt;
    final TagType type;

    Param(boolean ommitIfMissing, String param, String anchor, String deflt, String paramMeta, ParamContext paramContext, TagType type) {
        this.ommitIfMissing = ommitIfMissing;
        this.name = param;
        this.anchor = anchor;
        this.meta = paramMeta == null ? "" : paramMeta.trim();
        this.context = paramContext == null ? Regular : paramContext;
        this.deflt = deflt;
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Param other = (Param) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        String extra = getPairedParams("=", ", ", pair("context", context == Regular ? null : context.name()), pair("meta", meta));
        return name + (extra.isEmpty() ? "" : "{" + extra + "}");
    }

    enum TagType {
        /**
         * System property, not available at runtime
         */
        SYSTEM,
        /**
         * System property, available at runtime
         */
        SYSTEMRUNTIME,
        /**
         * Generic property, not available at runtime
         */
        BUILD,
        /**
         * Generic property, available at runtime
         */
        RUNTIME,
        /**
         * As a local variable
         */
        LOCAL
    }

}
