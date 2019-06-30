/*
 * (c) 2019 by Panayotis Katsaloulis
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
