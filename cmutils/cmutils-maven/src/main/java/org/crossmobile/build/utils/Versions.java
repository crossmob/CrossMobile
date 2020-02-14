/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.build.utils;

public class Versions {

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
        public static final String VERSION = "2.5.6";

        private RetroLambda() {
        }
    }

    public static final class XMLVM {

        public static final String GROUP = "com.panayotis";
        public static final String ARTIFACT = "xmlvm";
        public final static String VERSION = "1.0.4";

        private XMLVM() {
        }
    }
}
