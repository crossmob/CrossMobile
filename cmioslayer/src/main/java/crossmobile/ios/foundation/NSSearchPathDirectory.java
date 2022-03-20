/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSSearchPathDirectory class defines different directories used by the
 * NSFileManager.
 */
@CMEnum
public final class NSSearchPathDirectory {

    /**
     * The directory of supported applications.
     */
    public static final int Application = 1;

    /**
     * The directory of unsupported applications and demonstration versions.
     */
    public static final int DemoApplication = 2;

    /**
     * The directory of developer applications.
     */
    public static final int DeveloperApplication = 3;

    /**
     * The directory of system and network administration applications.
     */
    public static final int AdminApplication = 4;

    /**
     * The directory that contains documentation, configuration files and
     * support files.
     */
    public static final int Library = 5;

    /**
     * The directory of developer resources.
     */
    public static final int Developer = 6;

    /**
     * The home directory.
     */
    public static final int User = 7;

    /**
     * The directory of the documentation.
     */
    public static final int Documentation = 8;

    /**
     * The directory of application's documents.
     */
    public static final int Document = 9;

    /**
     * The directory of core services.
     */
    public static final int CoreService = 10;

    /**
     * The autosave directory.
     */
    public static final int AutosavedInformation = 11;

    /**
     * The directory of user's desktop.
     */
    public static final int Desktop = 12;

    /**
     * The cache directory.
     */
    public static final int Caches = 13;

    /**
     * The application support directory.
     */
    public static final int ApplicationSupport = 14;

    /**
     * The directory of the downloads.
     */
    public static final int Downloads = 15;

    /**
     * The directory of the input methods.
     */
    public static final int InputMethods = 16;

    /**
     * The directory of the movies.
     */
    public static final int Movies = 17;

    /**
     * The directory of the music.
     */
    public static final int Music = 18;

    /**
     * The directory of the pictures.
     */
    public static final int Pictures = 19;

    /**
     * The directory of printer descriptions.
     */
    public static final int PrinterDescription = 20;

    /**
     * The shared public directory.
     */
    public static final int SharedPublic = 21;

    /**
     * The Preference Panes directory.
     */
    public static final int PreferencePanes = 22;

    /**
     * The item replacement directory for implementing safe-save features.
     */
    public static final int ItemReplacement = 99;

    /**
     * Path for applications.
     */
    public static final int AllApplications = 100;

    /**
     * The path of the resources.
     */
    public static final int AllLibraries = 101;

    private NSSearchPathDirectory() {
    }
}
