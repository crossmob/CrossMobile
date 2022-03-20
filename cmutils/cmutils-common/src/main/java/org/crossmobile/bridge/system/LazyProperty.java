/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.system;

import org.robovm.objc.block.Block0;

public class LazyProperty<T> {
    private T value = null;
    private final Block0<T> supplier;
    private boolean initialized = false;

    public LazyProperty(Block0<T> supplier) {
        if (supplier == null)
            throw new NullPointerException("LazyProperty supplier not provided");
        this.supplier = supplier;
    }

    public T get() {
        if (!initialized) {
            value = supplier.invoke();
            initialized = true;
        }
        return value;
    }

    public void destroy() {
        value = null;
        initialized = false;
    }
}
