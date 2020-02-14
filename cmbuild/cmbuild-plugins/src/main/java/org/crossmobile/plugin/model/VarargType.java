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

public enum VarargType {
    /**
     * Null terminated vararg; all elements of the same type
     */
    OBJC(false, false),
    /**
     * One Object as head, following by an arbitrary number of unknown objects. This type could be only derived and not
     * specifically defined
     */
    OBJCVIRTUAL(false, true),
    /**
     * Null terminated C-typed varargs
     */
    C(true, false),
    /**
     * One object as head, following by an arbitrary number of unknown objects. This type could be only derived and not
     * specifically defined
     */
    CVIRTUAL(true, true);

    /**
     * Vararg in a C-style function
     */
    public final boolean function;
    /**
     * Vararg is virtual; no definition available, thus types need to be found   
     */
    public final boolean virtual;

    VarargType(boolean function, boolean virtual) {
        this.function = function;
        this.virtual = virtual;
    }
}
