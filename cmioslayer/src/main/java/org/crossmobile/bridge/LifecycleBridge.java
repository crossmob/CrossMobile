/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import static org.crossmobile.bridge.system.LauncherCommons.CROSSMOBILE_PROPERTIES;

public interface LifecycleBridge extends Thread.UncaughtExceptionHandler {

    String UNKNOWN_NAME = "Unknown";
    String THEME_PROPERTIES = "theme.properties";

    /**
     * Initialize bridge. This method should guarantee to call the parseArguments method.
     *
     * @param args user provided arguments which sould be passed to parseArguments
     */
    void init(String[] args);

    default void loadSystemProperties() {
        try {
            System.getProperties().load(new InputStreamReader(Native.file().getFileStream(Native.file().getApplicationPrefix() + "/" + CROSSMOBILE_PROPERTIES), "UTF-8"));
        } catch (IOException ex) {
            Native.lifecycle().quit("Corrupted CrossMobile application: " + ex.toString(), ex);
            return;
        }
        try {
            System.getProperties().load(new InputStreamReader(Native.file().getFileStream(Native.file().getApplicationPrefix() + "/" + THEME_PROPERTIES), "UTF-8"));
        } catch (Exception ignored) {
        }
    }

    /**
     * Parse command line arguments. This method is called from inside init method
     *
     * @param args user provided arguments as passed by init
     */
    void parseArguments(String[] args);

    void splashTerminated();

    void activate();

    void deactivate();

    void quit(String error, Throwable throwable);

    /* The age of this application; when updating this age increases */
    long currentAgeInMillis();

    void notImplemented(String moreInfo);

    default void notImplemented() {
        notImplemented(null);
    }

    /**
     * Retrieve launch options from the environment and destroy them
     */
    Map<String, Object> consumeLaunchOptions();

    int getApplicationState();
}
