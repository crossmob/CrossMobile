/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.func;

public interface TriFunction<S, T, U, V> {
    V apply(S one, T two, U three);
}
