// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.bridge;

import java.util.Map;

public interface LifecycleBridge extends Thread.UncaughtExceptionHandler {

    String UNKNOWN_NAME = "Unknown";
    String CROSSMOBILE_PROPERTIES = "crossmobile.properties";
    String THEME_PROPERTIES = "theme.properties";

    void init(String[] args);

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
