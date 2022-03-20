/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.ann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
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
