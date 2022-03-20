/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

public class FileUtilsException extends RuntimeException {

    public FileUtilsException(String message) {
        super(message);
    }

    public FileUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUtilsException(Throwable cause) {
        super(cause);
    }

}
