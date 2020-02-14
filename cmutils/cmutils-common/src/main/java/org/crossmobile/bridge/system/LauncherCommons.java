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
package org.crossmobile.bridge.system;

import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.RUNTIME;
import static org.crossmobile.bridge.ann.CMLibTarget.SOURCEONLY;

@CMLib(target = RUNTIME)
public final class LauncherCommons {

    public static final String OUTPUT_PACKAGE = "META-INF";
    public static final String OUTPUT_FILE = "launcher.properties";

    private LauncherCommons() {
    }

}
