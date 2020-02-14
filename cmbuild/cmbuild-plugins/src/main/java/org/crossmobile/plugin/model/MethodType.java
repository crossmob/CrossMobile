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

public enum MethodType {
    SELECTOR,
    FUNCTION,
    EXTERNAL,
    BLOCK,
    VA_SELECTOR,
    VA_FUNCTION;

    public boolean isVarArgs() {
        return this == VA_SELECTOR || this == VA_FUNCTION;
    }

    public boolean isExternal() {
        return this == EXTERNAL;
    }

    public boolean isFunction() {
        return this == FUNCTION || this == VA_FUNCTION;
    }
}
