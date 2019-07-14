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
package org.crossmobile.backend.desktop;

import org.crossmobile.bind.io.GenericSocialBridge;
import org.crossmobile.bridge.*;

public abstract class NativeDesktop extends Native {

    @Override
    protected SoundBridge initSound() {
        return new DesktopSoundBridge();
    }

    @Override
    protected FileBridge initFile() {
        return new DesktopFileBridge();
    }

    @Override
    protected InAppBridge initInApp() {
        return new DesktopInAppBridge();
    }

    @Override
    protected LocationBridge initLocation() {
        return new DesktopLocation();
    }

    @Override
    protected NetworkBridge initNetwork() {
        return new DesktopNetworkBridge();
    }

    @Override
    protected SocialBridge initSocial() {
        return new GenericSocialBridge();
    }

    @Override
    protected UIGuidelinesBridge initUIGuidelines() {
        return new DesktopUIGuidelinesBridge();
    }

    @Override
    protected ShareBridge initShare() {
        return (items, excluded, completion) -> {
        };
    }

    @Override
    protected SecurityBridge initSecurity() {
        return new DesktopSecurityBridge();
    }

    @Override
    protected MessageBridge initMessage() {
        return new DesktopMessageBridge();
    }

    @Override
    protected NotificationBridge initNotification() {
        return new DesktopNotificationsBridge();
    }
}
