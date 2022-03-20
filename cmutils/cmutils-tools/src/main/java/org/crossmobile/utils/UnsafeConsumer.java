/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

public interface UnsafeConsumer<T>  {

    void accept(T t) throws Throwable;

}