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

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(PARAMETER)
public @interface CMParamMod {
    /**
     * If a parameter is used by reference
     *
     * @return true is it is called by reference
     */
    boolean byRef() default false;

    /**
     * Native code
     *
     * @return the native code of the conversion mechanism
     */
    String convertWith() default "";

    /**
     * Native type
     *
     * @return Java class of native type
     */
    Class<?> type() default Object.class;

    /**
     * Will associate this parameter object to the parent object. This is useful
     * for weak references or any kind of associations between objects. By
     * default all properties which are weak referenced will be associated. Only
     * applicable to objects.
     *
     * @return if association will be required
     */
    AssociationType association() default AssociationType.DEFAULT;

    /**
     * Do not execute this method if this parameter is null/zero. Only
     * applicable to methods which return void.
     *
     * @return
     */
    boolean shouldNotBeNull() default false;

    /**
     * When calculating selector name, append this name to the name of the
     * previous selector parameter. It is required when we want to force append
     * this part of the selector with the previous.
     *
     * @return
     */
    boolean concatName() default false;
}
