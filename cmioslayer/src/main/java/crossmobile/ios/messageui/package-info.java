/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmmessages", libs = "MessageUI.framework~", includes = "<MessageUI/MessageUI.h>",
        displayName = "Message Framework", description = "CrossMobile© Compatibility library for Message Framework",
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.messageui;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
