/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.junit.Test;

import static org.junit.Assert.*;

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
