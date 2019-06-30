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
package org.crossmobile.backend.android;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.touchid.LAContext;
import crossmobile.rt.StrongReference;
import org.crossmobile.bind.io.GenericSocialBridge;
import org.crossmobile.bridge.*;
import org.robovm.objc.block.VoidBlock2;

public class NativeAndroid extends Native {

    @Override
    protected ImageBridge initImage() {
        return new AndroidImageBridge();
    }

    @Override
    protected SystemBridge initSystem() {
        return new AndroidSystemBridge();
    }

    @Override
    protected LifecycleBridge initLifecycle() {
        return new AndroidLifecycleBridge();
    }

    @Override
    protected GraphicsBridge initGraphics() {
        return new AndroidGraphicsBridge();
    }

    @Override
    protected SoundBridge initSound() {
        return new AndroidSoundBridge();
    }

    @Override
    protected WrapperBridge initWidget() {
        return new AndroidWrapperBridge();
    }

    @Override
    protected FileBridge initFile() {
        return new AndroidFileBridge();
    }

    @Override
    protected InAppBridge initInApp() {
        return new AndroidInAppBridge();
    }

    @Override
    protected LocationBridge initLocation() {
        return new AndroidLocation();
    }

    @Override
    protected NetworkBridge initNetwork() {
        return new AndroidNetworkBridge();
    }

    @Override
    protected SocialBridge initSocial() {
        return new GenericSocialBridge();
    }

    @Override
    protected UIGuidelinesBridge initUIGuidelines() {
        return new AndroidUIGuidelinesBridge();
    }

    @Override
    protected NotificationBridge initNotification() {
        return new AndroidNotificationBridge();
    }

    @Override
    protected ShareBridge initShare() {
        return new AndroidShareBridge();
    }

    @Override
    protected SecurityBridge initSecurity() {
        try {
            return new AndroidSecurityBridge();
        } catch (Throwable th) {
            return new SecurityBridge() {
                @Override
                public boolean supportsFingerprint(StrongReference<NSError> error) {
                    return false;
                }

                @Override
                public void requestFingerprint(VoidBlock2<Boolean, NSError> callback, LAContext context) {
                    callback.invoke(false, new NSError("Fingerprint not supported", 0, null));
                }
            };
        }
    }

    @Override
    protected WrapperMapBridge initMapWidget() {
        return new AndroidWrapperMapBridge();
    }

    @Override
    protected MessageBridge initMessage() {
        return new AndroidMessageBridge();
    }
}
