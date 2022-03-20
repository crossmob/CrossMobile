/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system.init;

import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.SOURCEONLY;

@CMLib(name = "cmioslayer", target = SOURCEONLY)
public class PluginsLauncherList {

    @SuppressWarnings("UseSpecificCatch")
    public static void initialize() {
    }

    @SuppressWarnings("UseSpecificCatch")
    public static void earlyInitialize(Object context) {
    }
}
