/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmgamekit", libs = "GameKit.framework", includes = "<GameKit/GameKit.h>",
        displayName = "GameKit Framework", description = "CrossMobile© Compatibility library for GameKit Framework",
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.gamekit;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
