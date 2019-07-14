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

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(TYPE)
/**
 * Single Android Injection
 */
public @interface CMAndroidInjections {
    /**
     * Extra information needed to be appended to the application section of the
     * AndroidManifest.xml file
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
