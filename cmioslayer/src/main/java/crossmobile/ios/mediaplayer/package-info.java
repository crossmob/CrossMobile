/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmmedia", libs = {"MediaPlayer.framework~", "CoreMedia.framework~"}, includes = "<MediaPlayer/MediaPlayer.h>",
        displayName = "MediaPlayer Framework", description = "CrossMobile© Compatibility library for MediaPlayer and relative Frameworks",
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.mediaplayer;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
