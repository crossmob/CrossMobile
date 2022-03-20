/*
 * (c) 2022 by Panayotis Katsaloulis
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
public @interface CMSelector {

    String value();

    /**
     * Use this annotation to define that this static method is applied on an
     * object, that does not map directly to the Java Object schematics, i.e.
     * NSString selectors on String class or constructors returning null objects.
     * If the return type of this selector is "instancetype" and it is a
     * Java-static method, then it will be considered as a constructor and the
     * first object will be kept from arguments. Otherwise the first object
     * will become the "self" object.
     *
     * @return true, if static mapping is performed, usually false
     */
    boolean staticMapping() default false;

    /**
     * Use this native method to resolve the size of an unknown array, i.e. when
     * we return one from a method
     *
     * @return
     */
    String sizeResolver() default "";

    String sinceIos() default "";

}
