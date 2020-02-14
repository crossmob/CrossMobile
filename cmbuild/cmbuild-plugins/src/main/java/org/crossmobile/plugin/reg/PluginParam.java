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

import org.crossmobile.bridge.ann.CMLibParam.ParamContext;

import static org.crossmobile.bridge.ann.CMLibParam.ParamContext.Regular;
import static org.crossmobile.utils.TextUtils.replaceOld;
import static org.crossmobile.utils.TextUtils.replaceOldString;

public class PluginParam {

    private String description = "";
    private String paramMeta = "";
    private ParamContext paramContext = Regular;

    public void setDescription(String description, String info) {
        this.description = replaceOldString(this.description, description, info);
    }

    public String getDescription() {
        return description;
    }

    public void setMeta(String paramMeta, String info) {
        this.paramMeta = replaceOldString(this.paramMeta, paramMeta, info);
    }

    public String getMeta() {
        return paramMeta;
    }

    public void setContext(ParamContext paramContext, String info) {
        this.paramContext = replaceOld(this.paramContext == Regular ? null : this.paramContext, paramContext, info);
    }

    public ParamContext getContext() {
        return paramContext;
    }
}
