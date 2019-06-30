/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
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
