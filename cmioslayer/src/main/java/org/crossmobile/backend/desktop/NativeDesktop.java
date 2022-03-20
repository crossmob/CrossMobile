/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
