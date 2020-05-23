/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
