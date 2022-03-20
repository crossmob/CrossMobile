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
  Single dependency of a CrossMobile plugin
 */
public @interface CMLibDepends {

    /**
     * The group of the dependency maven plugin
     *
     * @return Defaults to current plugin groupID
     */
    String groupId() default "";

    /**
     * The name of the plugin. Note this is <b>not</b> the name of the artifact.
     * The actual name of the artifact will be a composition of plugin tag
     * (always will start with "cmplugin-", plugin target (followed by either
     * "android-", "ios-", "desktop-" etc.) and this plugin name. For example,
     * the android artifactId of plugin "myplugin" will be
     * "cmplugin-android-myplugin".
     *
     * @return The plugin name
     */
    String pluginName();

    /**
     * The version of the dependency maven plugin
     *
     * @return Defaults to current plugin version
     */
    String version() default "";

    /**
     * The type of the dependency maven plugin
     *
     * @return Defaults to to current plugin packaging
     */
    String type() default "";

    /**
     * The target platform of this entity, could be inherited from the defining
     * class if UNKNOWN.
     *
     * @return defaults to UNKNOWN
     */
    CMLibTarget target() default CMLibTarget.UNKNOWN;
}
