/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import org.robovm.objc.block.Block1;

public final class Promise<T> {

    private final T source;
    private T cached = null;
    private final Block1<T, T> converter;

    public Promise(T source, Block1<T, T> converter) {
        this.source = source;
        this.converter = converter;
    }

    public T source() {
        return source;
    }

    public T get() {
        if (cached == null)
            if (converter == null)
                return source;
            else
                cached = converter.invoke(source);
        return cached;
    }

    public void destroy() {
        cached = null;
    }
}
