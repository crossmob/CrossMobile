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
