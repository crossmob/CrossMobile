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
package org.crossmobile.plugin.robovm.models.parameters;

import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.utils.TextUtils;

public class StructRParam extends RParam {
    private final String value;

    public StructRParam(NParam nParam, Class<?> parameter, NType type, String value) {
        super(nParam, parameter, type);
        this.value = value;
    }

    @Override
    public String conversion() {
        StringBuilder conversion = new StringBuilder();
        if (value != null) {
            String[] split = value.split("\\.");
            if (split.length == 0)
                split = new String[]{value};
            conversion.append("this.");
            for (int i = 0; i < split.length - 1; i++) {
                String s = split[i];
                conversion.append("get").append(TextUtils.capitalize(s)).append("().");
            }
            conversion.append("set").append(TextUtils.capitalize(split[split.length - 1])).append("(").append(reference()).append(");").append("\n");
        }
        return conversion.toString();
    }
}
