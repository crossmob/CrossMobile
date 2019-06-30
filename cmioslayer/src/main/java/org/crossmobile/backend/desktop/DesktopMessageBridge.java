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

import crossmobile.ios.messageui.MFMessageComposeViewController;
import crossmobile.ios.messageui.MessageComposeResult;
import crossmobile.ios.uikit.UIAlertView;
import org.crossmobile.bridge.MessageBridge;

import java.util.List;

import static org.crossmobile.bind.system.i18n.I18NSelf.ℑ;

public class DesktopMessageBridge implements MessageBridge {

    @Override
    public boolean supportsSMS() {
        return false;
    }

    @Override
    public boolean launchSMS(List<String> recipients, String body, MFMessageComposeViewController controller) {
        new UIAlertView(ℑ("Unsupported protocol"), ℑ("Unable to use SMS service"), null, ℑ("Acknowledge")).show();
        if (controller != null && controller.messageComposeDelegate() != null)
            controller.messageComposeDelegate().didFinishWithResult(controller, MessageComposeResult.Failed);
        return false;
    }
}
