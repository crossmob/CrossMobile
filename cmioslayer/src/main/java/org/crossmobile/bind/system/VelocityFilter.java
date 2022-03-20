/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

public final class VelocityFilter {

    private final double[] time;
    private final double[] value;
    private int pointer;
    private int size;

    public VelocityFilter() {
        this(2);
    }

    public VelocityFilter(int filterSize) {
        time = new double[filterSize + 1];
        value = new double[filterSize + 1];
        reset();
    }

    public final void reset() {
        pointer = -1;
        size = 0;
    }

    public final double getValue() {
        double result = 0;
        for (int i = 0; i < size - 1; i++) {
            int p1 = pointer - i;   // first current, then go backwards
            if (p1 < 0)
                p1 += size;
            int p2 = p1 - 1;    // One box earlier than p1
            if (p2 < 0)
                p2 += size;
            result += (value[p1] - value[p2]) / (time[p1] - time[p2]);
        }
        if (size > 1)
            result /= (size);
        return result;
    }

    public final void put(double time, double value) {
        if (pointer >= 0 && this.time[pointer] == time) {   // Avoid infinite values
            this.value[pointer] = value;
            return;
        }

        pointer++;
        if (pointer >= this.value.length)
            pointer = 0;
        else if (size < this.value.length)
            size++;
        this.time[pointer] = time;
        this.value[pointer] = value;
    }
}
