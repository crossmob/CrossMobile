/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.ann;

import org.crossmobile.bridge.CrossMobilePlugin;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({PACKAGE, TYPE})
/*
  Definition of a CrossMobile Library
 */
public @interface CMLib {

    /**
     * The name of the plugin; could be inherited
     *
     * @return Defaults to parent package plugin name
     */
    String name() default "";

    /**
     * The target platform of this entity, could be inherited
     *
     * @return defaults to UNKNOWN
     */
    CMLibTarget target() default CMLibTarget.UNKNOWN;

    /**
     * @return List of native libraries required by this plugin to work
     */
    String[] libs() default {};

    /**
     * Include Headers to be added in the generated objc class
     *
     * @return List of native includes required by this plugin to work
     */
    String[] includes() default {};

    /**
     * @return Name of the plugin as presented to the user
     */
    String displayName() default "";

    /**
     * Description of the plugin as presented to the user
     *
     * @return
     */
    String description() default "";

    /**
     * A URL holding more information about this plugin
     *
     * @return the description URL
     */
    String url() default "";

    /**
     * Provide the class name of the optional java initializer. Sometimes it is
     * required for a plugin to initialize early. With this property it is
     * possible to define an initialization object which conforms to the
     * org.crossmobile.bridge.CrossMobilePlugin interface
     *
     * @return the class of the plugin initializer
     */
    Class<? extends CrossMobilePlugin> initializer() default CrossMobilePlugin.class;

    /**
     * Extra information needed to be appended to the application section of the
     * AndroidManifest.xml file
     *
     * @return the application section of the manifest
     */
    CMAndroidInjections[] androidInjections() default {};

    /**
     * Extra android permissions needed by this plugin.
     *
     * @return list of external permissions - names only. I.e. internet
     * permissions are requested as "INTEGER".
     */
    String[] permissions() default {};

    /**
     * List of optional parameters as a plugin which the user is requested to
     * fill in
     *
     * @return
     */
    CMLibParam[] params() default {};

    /**
     * List of optional plugins which this plugin will depend on
     *
     * @return
     */
    CMLibDepends[] depends() default {};

    /**
     * List of optional pods, required for this plugin. Note: this is valid only for plugin creation
     *
     * @return
     */
    CMPod[] pods() default {};

    boolean optionalLibraryBinary() default false;
}
