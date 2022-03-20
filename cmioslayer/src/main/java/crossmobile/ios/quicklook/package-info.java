/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmquicklook", libs = "QuickLook.framework", includes = "<QuickLook/QuickLook.h>",
        displayName = "QuickLook Framework",
        description = "CrossMobile© Compatibility library for QuickLook Framework",
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.quicklook;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
