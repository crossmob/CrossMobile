/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.Objects;

import static org.crossmobile.bridge.ann.CMLibParam.ParamContext;
import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.Regular;
import static org.crossmobile.bridge.system.Pair.pair;
import static org.crossmobile.utils.TextUtils.getPairedParams;

public class Param {

    public final boolean omitIfMissing;
    public final String name;
    public final String anchor;
    public final String meta;
    public final ParamContext context;
    public final String deflt;
    final TagType type;

    Param(boolean omitIfMissing, String param, String anchor, String deflt, String paramMeta, ParamContext paramContext, TagType type) {
        this.omitIfMissing = omitIfMissing;
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
