/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.foundation.NSString;
import crossmobile.ios.foundation.NSStringEncoding;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.social.SLComposeViewControllerResult;
import crossmobile.ios.social.SLServiceType;
import crossmobile.ios.uikit.UIApplication;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(name = "cmsocial", target = CMLibTarget.SWING)
public class DesktopSocial {

    @SuppressWarnings("deprecation")
    public void initialize() {
        Native.social().registerSocial(SLServiceType.Twitter, (text, images, urls, handler) -> {
            if (text != null)
                //noinspection ConstantConditions
                UIApplication.sharedApplication().openURL(NSURL.URLWithString(
                        "https://twitter.com/intent/tweet?text=" + NSString.stringByAddingPercentEscapesUsingEncoding(text, NSStringEncoding.UTF8)
                ));
            if (handler != null)
                handler.invoke(text == null ? SLComposeViewControllerResult.Cancelled : SLComposeViewControllerResult.Done);
        });
    }
}
