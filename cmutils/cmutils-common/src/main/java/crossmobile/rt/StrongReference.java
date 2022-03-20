/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.rt;

public class StrongReference<T> {

    private T data;

    public StrongReference() {
        data = null;
    }

    public StrongReference(T item) {
        this.data = item;
    }

    public T get() {
        return data;
    }

    public void set(T item) {
        this.data = item;
    }
}
