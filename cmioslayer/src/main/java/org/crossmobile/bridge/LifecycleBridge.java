/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
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
package org.crossmobile.bridge;

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

    // Whether the application should be stayed alive in the background
    boolean staysAlive();
}
