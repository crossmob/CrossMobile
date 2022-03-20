/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.func;

public interface UnsafeFunction<F, T> {

    T apply(F from) throws Throwable;

}