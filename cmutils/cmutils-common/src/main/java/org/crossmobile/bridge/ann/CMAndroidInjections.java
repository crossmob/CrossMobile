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

@Retention(RUNTIME)
@Target(TYPE)
/*
  Single Android Injection
 */
public @interface CMAndroidInjections {
    /**
     * Extra information needed to be appended to the application section of the
     * AndroidManifest.xml file.
     * <p>
     * Note these values support meta-parsing of other parameters. Other parameters
     * can be referenced inside this section in the format of ${plugin_package.parameter_name}.
     * The syntax is the same as the name of the property in the &lt;properties&gt; section
     * of the POM file.
     *
     * @return the application section of the manifest
     */
    String[] appSection() default {};

    /**
     * Extra information needed in the most-outer part of the build.gradle file
     *
     * @return the required gradle section
     */
    String[] gradleExt() default {};

    /**
     * Extra information needed in the buildscript dependencies of the build.gradle file
     *
     * @return the required gradle section
     */
    String[] gradleBuildDep() default {};
}
