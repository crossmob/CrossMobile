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
