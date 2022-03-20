/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop.cgeo;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface CClickable {

    CEvent getEvent();

    class Reverse<T> implements Iterable<T> {

        private final List<T> forward;

        public Reverse(List<T> original) {
            this.forward = original;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private final ListIterator<T> iterator = forward.listIterator(forward.size());

                @Override
                public boolean hasNext() {
                    return iterator.hasPrevious();
                }

                @Override
                public T next() {
                    return iterator.previous();
                }

                @Override
                public void remove() {
                    iterator.remove();
                }
            };
        }

        public static <T> Reverse<T> reversed(List<T> original) {
            return new Reverse<>(original);
        }
    }
}
