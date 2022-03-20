/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */
package org.crossmobile.utils;

import java.util.function.Consumer;

public class NumberUtils {

    public static void safeInt(String data, Consumer<Integer> consumer) {
        try {
            if (data != null && consumer != null)
                consumer.accept(Integer.parseInt(data));
        } catch (NumberFormatException ignored) {
        }
    }

    public static void safeLong(String data, Consumer<Long> consumer) {
        try {
            if (data != null && consumer != null)
                consumer.accept(Long.parseLong(data));
        } catch (NumberFormatException ignored) {
        }
    }
}
