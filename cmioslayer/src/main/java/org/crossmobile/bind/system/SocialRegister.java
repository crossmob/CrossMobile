/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.system;


import org.crossmobile.backend.android.AndroidSocial;
import org.crossmobile.backend.desktop.DesktopSocial;
import org.crossmobile.bridge.CrossMobilePlugin;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;

import static org.crossmobile.bridge.ann.CMLibTarget.JAVA;

@CMLib(name = "cmsocial", target = JAVA, initializer = SocialRegister.class)
public class SocialRegister implements CrossMobilePlugin {
    @Override
    public void initialize() {
        if (Native.isAndroid())
            new AndroidSocial().initialize();
        else
            new DesktopSocial().initialize();
    }
}
