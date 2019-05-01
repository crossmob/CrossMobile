/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, getVersion 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
