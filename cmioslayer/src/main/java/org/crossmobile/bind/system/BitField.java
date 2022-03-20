/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import java.util.Arrays;

public class BitField {
    private final int size;
    private final byte[] storage;

    public BitField(int size) {
        this(size, false);
    }

    public BitField(int size, boolean defaultValue) {
        this.size = size;
        storage = new byte[(size + 7) >>> 3];
        if (defaultValue)
            Arrays.fill(storage, (byte) 0xFF);
    }

    public void set(int location, boolean value) {
        int pool = location >>> 3;
        int bit = 1 << (location & 0x7);
        if (value)
            storage[pool] |= bit;
        else
            storage[pool] &= ~bit;
    }

    public boolean get(int location) {
        int pool = location >>> 3;
        int bit = 1 << (location & 0x7);
        return (storage[pool] & bit) != 0;
    }

    public boolean getAndSet(int location, boolean value) {
        int pool = location >>> 3;
        int bit = 1 << (location & 0x7);
        boolean result = (storage[pool] & bit) != 0;
        if (value)
            storage[pool] |= bit;
        else
            storage[pool] &= ~bit;
        return result;
    }
}
