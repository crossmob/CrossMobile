/*
 * (c) 2019 by Panayotis Katsaloulis
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
     * object, that does not map directly to the Java object, i.e. NSString
     * selectors on String class. If the return type of this selector is
     * "instancetype" and it is a Java-static method, then it will be considered
     * as a constructor and the first object will be kept from arguments. Otherwise
     * the first object will become the "self" object.
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

    /**
     * Use this native Swift method, if this Objective C function ends with a vararg statement.
     * The Swift method should be a va_list method, and this va_list argument
     * <b>should</b> be named `va_array`.
     */
    String swiftVarArgMethod() default "";

}
