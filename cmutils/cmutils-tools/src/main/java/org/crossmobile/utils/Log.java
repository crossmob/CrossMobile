/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import static org.crossmobile.utils.Log.Level.*;

public class Log {

    private static Logger logger = new Default();
    private static Level level = DEBUG;

    public static void register(Logger logger) {
        Log.logger = logger == null ? new Default() : logger;
    }

    public static void debug(String message) {
        if (level.ordinal() <= DEBUG.ordinal())
            logger.debug(message);
    }

    public static void info(String message) {
        if (level.ordinal() <= INFO.ordinal())
            logger.info(message);
    }

    public static void warning(String message) {
        if (level.ordinal() <= WARNING.ordinal())
            logger.warning(message);
    }

    public static void error(String message) {
        if (level.ordinal() <= ERROR.ordinal())
            logger.error(message);
    }

    public static void error(Throwable th) {
        if (level.ordinal() <= ERROR.ordinal())
            logger.error(th);
    }

    public static void error(String message, Throwable th) {
        if (level.ordinal() <= ERROR.ordinal())
            logger.error(message, th);
    }

    public static void setLevel(Level level) {
        Log.level = level == null ? DEBUG : level;
    }

    public static Level getLevel() {
        return level;
    }

    private Log() {
    }

    public static class Default implements Logger {

        @Override
        public void debug(String message) {
            System.out.println(message);
        }

        @Override
        public void info(String message) {
            System.out.println(message);
        }

        @Override
        public void warning(String message) {
            System.err.println(message);
        }

        @Override
        public void error(String message) {
            error(message, null);
        }

        @Override
        public void error(Throwable th) {
            error(null, th);
        }

        @Override
        public void error(String message, Throwable th) {
            if (message != null)
                System.err.println(message);
            if (th != null)
                th.printStackTrace(System.err);
        }
    }

    public enum Level {
        DEBUG, INFO, WARNING, ERROR, NONE;
    }

}
