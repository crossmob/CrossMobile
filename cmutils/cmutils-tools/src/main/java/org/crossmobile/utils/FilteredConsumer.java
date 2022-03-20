/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilteredConsumer<T> implements Consumer<T> {

    private final Consumer<T> parent;
    private final Predicate<T> predicate;

    public FilteredConsumer(Consumer<T> parent, Predicate<T> predicate) {
        this.parent = parent;
        this.predicate = predicate;
    }

    @Override
    public final void accept(T t) {
        if (parent != null && (predicate == null || predicate.test(t)))
            parent.accept(t);
    }

}
