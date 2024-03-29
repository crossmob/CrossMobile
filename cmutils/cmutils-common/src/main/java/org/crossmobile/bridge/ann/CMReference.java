/*
 * (c) 2023 by Panayotis Katsaloulis
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
public @interface CMReference {

    String REFERENCE_NAME = "$reference";

    Class<?> proxyOf() default Object.class;

    /**
     * Maybe this class is an alias of another type - it is only used by TypeDef
     *
     * @return the possible aliases
     */
    String[] typeAlias() default {};

}
