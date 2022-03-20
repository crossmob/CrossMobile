/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics.theme;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

/**
 * Placeholder class; on a runtime environment will be replaced with a themed instance
 */
@CMLib(target = CMLibTarget.SOURCEONLY)
public class ThemeFactory {
    public static ThemeManager createManager() {
        return null;
    }
}
