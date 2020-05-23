/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge.resolver;

import org.crossmobile.foreign.AndroidLauncher;
import org.crossmobile.foreign.IOSLauncher;
import org.crossmobile.foreign.UwpLauncher;

import java.util.Properties;

public class ForeignResolver {

    @SuppressWarnings("ConvertToStringSwitch")
    public static void launch(Properties props, String flavour) {
        if ("ios".equals(flavour))
            IOSLauncher.launch(props);
        else if ("android".equals(flavour))
            AndroidLauncher.launch(props);
        else if ("uwp".equals(flavour))
            UwpLauncher.launch(props);
        else
            throw new RuntimeException("Unknown launch target");
        System.exit(0);
    }
}
