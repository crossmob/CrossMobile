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
