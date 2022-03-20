/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.crossmobile.prefs;

public class MvnVersions {

    public static final class ProGuard {

        public static final String GROUP = "net.sf.proguard";
        public static final String ARTIFACT = "proguard-base";
        public static final String VERSION = "6.1.1";

        private ProGuard() {
        }
    }

    public static final class RetroLambda {

        public static final String GROUP = "net.orfjackal.retrolambda";
        public static final String ARTIFACT = "retrolambda";
        public static final String VERSION = "2.5.7";

        private RetroLambda() {
        }
    }

    public static final class XMLVM {

        public static final String GROUP = "com.panayotis";
        public static final String ARTIFACT = "xmlvm";
        public final static String VERSION = "1.0.5";

        private XMLVM() {
        }
    }

    public static final class Unaar {

        public static final String GROUP = "com.panayotis";
        public static final String ARTIFACT = "unaar";
        public final static String VERSION = "0.1";
        public final static String GOAL = "unaar";

        private Unaar() {
        }
    }
}
