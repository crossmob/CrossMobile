/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.build.utils;

import org.apache.maven.plugin.logging.Log;
import org.crossmobile.utils.Logger;

import java.util.Objects;

public class MojoLogger implements Logger {

    //    private static final String DEBUG = "🐞";
//    private static final String INFO = "ℹ️ ";
//    private static final String WARNING = "⚠️";
//    private static final String ERROR = "❌ ";
    private static boolean isRegistered;
    private final Log log;

    public static void register(Log log) {
        if (!isRegistered) {
            org.crossmobile.utils.Log.register(new MojoLogger(log));
            isRegistered = true;
        }
    }

    public MojoLogger(Log log) {
        Objects.requireNonNull(log);
        this.log = log;
    }

    @Override
    public void debug(String message) {
        log.debug(message);
    }

    @Override
    public void info(String message) {
        log.info(message);
    }

    @Override
    public void warning(String message) {
        log.warn(message);
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
        log.error(message, th);
    }

}
