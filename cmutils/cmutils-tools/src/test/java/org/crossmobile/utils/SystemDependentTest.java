/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.prefs.Config;
import org.junit.Test;

import static org.junit.Assert.*;

public class SystemDependentTest {

    @SuppressWarnings({"ResultOfMethodCallIgnored", "ConstantConditions"})
    @Test
    public void testIsJavaOld() {
        // Future proof methods
        Integer.parseInt(Config.MAX_JAVA_VERSION);    //make sure it's just a number;
        if (Config.MAX_JAVA_VERSION.startsWith("1."))
            Integer.parseInt(Config.MAX_JAVA_VERSION.substring(2));
        else
            Integer.parseInt(Config.MAX_JAVA_VERSION);
        assertEquals(4, TextUtils.listOfInts(Config.MIN_JAVA_VERSION_FULL).size());

        int current = Integer.parseInt(Config.MAX_JAVA_VERSION);

        assertFalse(SystemDependent.isJavaValid("1.0"));
        assertFalse(SystemDependent.isJavaValid("1.1"));
        assertFalse(SystemDependent.isJavaValid("1.2"));
        assertFalse(SystemDependent.isJavaValid("1.8.0_92-b14"));
        assertFalse(SystemDependent.isJavaValid("1.8.0_110"));
        assertTrue(SystemDependent.isJavaValid("1.8.0_111"));
        assertTrue(SystemDependent.isJavaValid("1.8.0_144-b01"));
        assertTrue(SystemDependent.isJavaValid("1.8.0_155-b01"));
        assertTrue(SystemDependent.isJavaValid("9"));
        assertTrue(SystemDependent.isJavaValid("9.1"));
        assertTrue(SystemDependent.isJavaValid("1.9.0"));
        assertTrue(SystemDependent.isJavaValid("10.0"));
        assertTrue(SystemDependent.isJavaValid("11.0"));
        assertTrue(SystemDependent.isJavaValid(Config.MIN_JAVA_VERSION_FULL));
        assertTrue(SystemDependent.isJavaValid(Config.MAX_JAVA_VERSION + ".0"));
        assertTrue(SystemDependent.isJavaValid(Config.MIN_JAVA_VERSION + ".1"));
        assertTrue(SystemDependent.isJavaValid(current + ".0"));
        assertFalse(SystemDependent.isJavaValid((current + 1) + ".0"));
    }
}
