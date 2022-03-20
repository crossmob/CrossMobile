/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.utils.func.UnsafeRunnable;

public class ExceptionUtils {
    public static void callNoException(UnsafeRunnable runnable) {
        try {
            runnable.run();
        } catch (Throwable ignored) {
        }
    }
}
