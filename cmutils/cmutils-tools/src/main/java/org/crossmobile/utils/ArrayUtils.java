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

public class ArrayUtils {

    public static byte[][] split(byte[] data, int maxsize) {
        if (data == null || data.length < 1 || maxsize < 1)
            return null;

        byte splitted[][] = new byte[(data.length + maxsize - 1) / maxsize][];
        for (int i = 0; i < splitted.length; ++i) {
            int from = i * maxsize;
            int to = from + maxsize;
            if (to > data.length)
                to = data.length;
            int length = to - from;
            splitted[i] = new byte[length];
            System.arraycopy(data, from, splitted[i], 0, length);
        }
        return splitted;
    }

    public static byte[] join(byte[][] splitted) {
        if (splitted == null || splitted.length < 1)
            return null;

        int length = 0;
        for (byte[] splitted1 : splitted)
            if (splitted1 == null || splitted1.length == 0)
                return null;
            else
                length += splitted1.length;
        byte[] joined = new byte[length];
        int loc = 0;
        for (byte[] part : splitted) {
            System.arraycopy(part, 0, joined, loc, part.length);
            loc += part.length;
        }
        return joined;
    }
}
