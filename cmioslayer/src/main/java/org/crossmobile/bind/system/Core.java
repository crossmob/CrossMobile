// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.bind.system;

public class Core {

    public static <T> boolean equals(T a, T b) {
        if (a == null)
            return b == null;
        return a.equals(b);
    }
}
