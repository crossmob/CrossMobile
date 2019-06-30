/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
