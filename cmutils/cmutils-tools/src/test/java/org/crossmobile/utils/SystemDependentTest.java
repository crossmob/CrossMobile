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
package org.crossmobile.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author teras
 */
public class SystemDependentTest {

    @Test
    public void testIsJavaOld() {
        assertTrue(SystemDependent.isJavaOld("1.0"));
        assertTrue(SystemDependent.isJavaOld("1.1"));
        assertTrue(SystemDependent.isJavaOld("1.2"));
        assertTrue(SystemDependent.isJavaOld("1.8.0_92-b14"));
        assertTrue(SystemDependent.isJavaOld("1.8.0_110"));
        assertFalse(SystemDependent.isJavaOld("1.8.0_111"));
        assertFalse(SystemDependent.isJavaOld("1.8.0_144-b01"));
        assertFalse(SystemDependent.isJavaOld("9"));
        assertFalse(SystemDependent.isJavaOld("1.9.0"));
        assertFalse(SystemDependent.isJavaOld("1.8.0_155-b01"));
    }

}
