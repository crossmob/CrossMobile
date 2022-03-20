/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;

import java.io.IOException;
import java.io.InputStream;

public class StreamConverter {

    private byte[] chunk = new byte[4096];
    private int size = -1;
    private StreamConverter next = null;

    public static byte[] toBytes(InputStream inputstream) {
        StreamConverter head = null;
        StreamConverter queue = null;
        StreamConverter current;
        if (inputstream != null) {
            do {
                current = new StreamConverter(inputstream);
                if (current.isValid()) {
                    if (queue != null)
                        queue.next = current;
                    else
                        head = current;
                    queue = current;
                }
            } while (current.isValid());
            if (head != null)
                return head.consumeBytes();
            else
                return null;
        } else
            return null;
    }

    private StreamConverter(InputStream in) {
        try {
            size = in.read(chunk);
        } catch (IOException ignored) {
        }
    }

    private byte[] consumeBytes() {
        StreamConverter current = this;
        int total = 0;
        // Calculate data size
        while (current != null) {
            total += current.size;
            current = current.next;
        }
        if (total < 1)
            return null;

        // reconstruct array
        byte[] res = new byte[total];
        int loc = 0;
        current = this;
        while (current != null) {
            System.arraycopy(current.chunk, 0, res, loc, current.size);
            current.chunk = null;

            loc += current.size;
            current.size = 0;

            StreamConverter cnext = current.next;
            current.next = null;
            current = cnext;
        }
        return res;
    }

    private boolean isValid() {
        return size >= 0;
    }
}
