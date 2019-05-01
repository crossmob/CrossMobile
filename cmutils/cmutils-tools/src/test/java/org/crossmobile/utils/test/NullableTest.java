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
package org.crossmobile.utils.test;

import java.util.concurrent.atomic.AtomicBoolean;

import org.crossmobile.utils.Nullable;

import static org.junit.Assert.*;

import org.junit.Test;

public class NullableTest {

    @Test
    public void testNullable() {
        AtomicBoolean test1 = new AtomicBoolean(false);
        AtomicBoolean test2 = new AtomicBoolean(false);
        AtomicBoolean test3 = new AtomicBoolean(true);

        Nullable.of(null).onNull(() -> test1.set(true)).onValid(in -> assertTrue("Should not call when null", false));
        Nullable.of(new Object()).onNull(() -> assertTrue("Should not call when not null", false)).onValid(in -> test2.set(true));

        assertEquals("item", Nullable.of("item").input());
        assertEquals("correct", Nullable.of("item").def("correct").get(String.class));
        assertEquals("correct", Nullable.of("item").set(s -> "correct").get(String.class));
        assertEquals("correct", Nullable.of(null).def("correct").set(in -> "wrong").get(String.class));

        assertTrue(test1.get());
        assertTrue(test2.get());
        assertTrue(test3.get());
    }
}
