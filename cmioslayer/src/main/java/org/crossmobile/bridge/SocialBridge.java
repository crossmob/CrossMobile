/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.social.SLComposeViewControllerCompletionHandler;
import crossmobile.ios.uikit.UIImage;

import java.util.Set;

public interface SocialBridge {

    void registerSocial(String handler, Handler classHandler);

    Handler getHandler(String handler);

    interface Handler {
        void launchSocial(String text, Set<UIImage> images, Set<NSURL> urls, SLComposeViewControllerCompletionHandler chandler);
    }
}
