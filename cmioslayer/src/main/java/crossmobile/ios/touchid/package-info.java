/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmtouchid",
        displayName = "TouchID Framework", includes = "<LocalAuthentication/LocalAuthentication.h>",
        description = "CrossMobile© Compatibility library for TouchID Framework",
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.touchid;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
