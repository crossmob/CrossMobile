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
package org.crossmobile.plugin.model;

public class NParamAffiliation {

    private final NParam parameter;
    private final Type type;

    public NParamAffiliation(NParam parameter, Type type) {
        this.parameter = parameter;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public NParam getParameter() {
        return parameter;
    }

    public static enum Type {
        SELECTOR,
        MEMBLOCK;
    }
}
