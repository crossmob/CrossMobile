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
package org.crossmobile.bridge.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@CMLib(target = CMLibTarget.APIJAVA)
public @interface CMClass {
    /**
     * Maybe this class is an alias of another type - it is only used by TypeDef
     *
     * @return the possible aliases
     */
    String[] typeAlias() default {};

    /**
     * This class is an alias of an already existing class. By default the name of the class should be verbatim the
     * name of the Objective C object. With this annotation it is possible to define a virtual class which corresponds
     * to an existing class. Thus, this class could not exist at all
     * @return
     */
    Class<?> proxyOf() default Object.class;
}
