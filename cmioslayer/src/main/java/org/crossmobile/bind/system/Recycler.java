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
package org.crossmobile.bind.system;

import java.util.Collection;
import java.util.LinkedList;

public abstract class Recycler<I> {

    private final Collection<I> items = new LinkedList<I>();

    public synchronized void put(I item) {
        items.add(item);
    }

    public synchronized I get() {
        if (items.isEmpty())
            return newItem();
        I res = items.iterator().next();
        items.remove(res);
        return res;
    }

    protected abstract I newItem();
}
