/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

@CMLib(name = "cmwebkit", libs = "WebKit.framework", includes = "<WebKit/WebKit.h>",
        displayName = "WebKit Framework",
        description = "CrossMobile© Compatibility library for WebKit Framework",
        initializer = WebViewInitializer.class,
        depends = @CMLibDepends(pluginName = "cmioslayer"))
package crossmobile.ios.webkit;

import org.crossmobile.bind.wrapper.WebViewInitializer;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
