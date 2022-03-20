/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.ann;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Single parameter of a CrossMobile plugin
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface CMLibParam {

    /**
     * The property name of this plugin. Note that this name should be as simple
     * as possible, since CrossMobile will prepend the id of this plugin to the
     * name of the property.
     *
     * @return The simple name of the plugin
     */
    String property();

    /**
     * @return The description of the plugin
     */
    String description();

    /**
     * Sometimes Android SDK needs external meta data to be present, especially
     * in AndroidManifest. With this parameter we define the android name of
     * this property.
     *
     * @return The android parameter name
     */
    String meta() default "";

    /**
     * The context of the specified parameter
     *
     * @return The current context of this parameter
     */
    ParamContext context() default ParamContext.Regular;

    enum ParamContext {
        Regular, Android, XcodeTarget;

        public static ParamContext retrieve(String input) {
            if (input != null && !(input = input.trim().toLowerCase()).isEmpty())
                for (ParamContext context : ParamContext.values())
                    if (context.name().toLowerCase().equals(input))
                        return context;
            System.err.println("Unable to parse parameter context of type '" + input + "'");
            return Regular;
        }
    }
}
