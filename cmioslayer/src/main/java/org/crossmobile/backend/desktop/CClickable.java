/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.backend.desktop;

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
