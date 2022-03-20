/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.system;

import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.RUNTIME;

@CMLib(target = RUNTIME)
public final class RuntimeCommons {
    public static final String MATERIALS_TAG = "materials";
    public static final String CROSSMOBILE_PROPERTIES = "crossmobile.properties";

    private RuntimeCommons() {
    }
}
