/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.ann;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface CMFunction {

    String value();

    /**
     * Use this native method to resolve the size of an unknown array, i.e. when
     * we return one from a method
     *
     * @return
     */
    String sizeResolver() default "";

    /**
     * Use this native Swift method, if there is a need for a Swift bridge.
     * Historically this method was used to define variadic calls which were handled by Swift.
     * Now there is no direct need.
     */
    String swiftMethod() default "";

}
