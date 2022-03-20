/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import org.robovm.objc.block.Block1;
import org.robovm.objc.block.VoidBlock1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@SuppressWarnings("Java8MapApi")
public class Recycler<C, V> {

    private final Map<C, LinkedList<V>> storage = new HashMap<>();
    private final Block1<C, V> constructor;
    private final VoidBlock1<V> cleanup;
    private final VoidBlock1<V> resurrect;

    public Recycler() {
        this(null, null, null);
    }

    public Recycler(Block1<C, V> constructor, VoidBlock1<V> cleanup, VoidBlock1<V> resurrect) {
        this.constructor = constructor;
        this.cleanup = cleanup;
        this.resurrect = resurrect;
    }

    public synchronized void put(V item) {
        put(null, item);
    }

    public synchronized void put(C category, V item) {
        if (item == null)
            return;
        LinkedList<V> cat = storage.get(category);
        if (cat == null)
            storage.put(category, cat = new LinkedList<>());
        if (cat.add(item) && cleanup != null)
            cleanup.invoke(item);
    }

    public synchronized V get() {
        return get(null);
    }

    public synchronized V get(C category) {
        LinkedList<V> cat = storage.get(category);
        if (cat == null || cat.isEmpty())
            return constructor == null ? null : constructor.invoke(category);
        V found = cat.removeLast();
        if (found != null)
            resurrect.invoke(found);
        return found;
    }
}
