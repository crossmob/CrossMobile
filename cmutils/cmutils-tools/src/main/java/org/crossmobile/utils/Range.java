/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.Objects;

public class Range {

    public final Integer from;
    public final Integer upto;

    public Range(Integer from, Integer upto) {
        this.from = from;
        this.upto = upto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.from);
        hash = 67 * hash + Objects.hashCode(this.upto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Range other = (Range) obj;
        if (!Objects.equals(this.from, other.from))
            return false;
        return Objects.equals(this.upto, other.upto);
    }

    @Override
    public String toString() {
        return "Range{" + "from=" + from + ", upto=" + upto + '}';
    }

}
