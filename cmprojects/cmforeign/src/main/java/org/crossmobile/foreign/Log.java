// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: AGPL-3.0-only

package org.crossmobile.foreign;

public class Log {

    public static void info(String message) {
        System.out.println((message == null || message.isEmpty() ? "" : "[INFO] ") + message);
    }

    public static void error(String message) {
        System.out.println((message == null || message.isEmpty() ? "" : "[ERROR] ") + message);
    }

    public static void passInfo(String message) {
        System.out.println(message);
    }

    public static void passError(String message) {
        System.out.println(message);
    }
}
