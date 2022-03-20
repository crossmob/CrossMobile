/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

import org.crossmobile.utils.func.Opt;
import org.junit.Test;

public class OptTest {

    @Test
    public void testNullable() {
        AtomicBoolean test1 = new AtomicBoolean(false);
        AtomicBoolean test2 = new AtomicBoolean(false);
        AtomicBoolean test3 = new AtomicBoolean(true);

        Opt.of(null).ifMissing(() -> test1.set(true)).ifExists(in -> assertTrue("Should not call when null", false));
        Opt.of(new Object()).ifMissing(() -> assertTrue("Should not call when not null", false)).ifExists(in -> test2.set(true));
        assertEquals("item", Opt.of("item").get());

        assertTrue(test1.get());
        assertTrue(test2.get());
        assertTrue(test3.get());
    }
}
