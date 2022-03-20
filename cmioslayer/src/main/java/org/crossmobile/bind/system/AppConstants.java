/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

public class AppConstants {

    public static final String DISPLAY_NAME = System.getProperty("cm.display.name", "CrossMobileApplication");
    public static final String DISPLAY_VERSION = System.getProperty("cm.bundle.version", "1");
}
