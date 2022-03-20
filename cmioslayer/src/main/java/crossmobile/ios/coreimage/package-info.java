/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmimage", libs = "CoreImage.framework", includes = "<CoreImage/CoreImage.h>", target = CMLibTarget.API_NOUWP,
        displayName = "CoreImage Framework", description = "CrossMobile© Compatibility library for Camera and CoreImage Framework",
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.coreimage;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibTarget;
