/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

public interface Logger {

    void debug(String message);

    void info(String message);

    void warning(String message);

    void error(String message);

    void error(Throwable th);

    void error(String message, Throwable th);

}
