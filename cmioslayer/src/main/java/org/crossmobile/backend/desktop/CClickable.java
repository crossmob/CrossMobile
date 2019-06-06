/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
