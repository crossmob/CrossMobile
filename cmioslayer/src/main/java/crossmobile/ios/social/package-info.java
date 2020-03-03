// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

@CMLib(name = "cmsocialbase", libs = {"Social.framework", "Twitter.framework~"}, includes = "<Social/Social.h>",
        displayName = "Social Framework", description = "CrossMobile© Compatibility library for Social Framework",
        depends = @CMLibDepends(pluginName = "cmaddressbook"), target = CMLibTarget.API_NOUWP)
package crossmobile.ios.social;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.ann.CMLibTarget;
