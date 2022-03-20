/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.desktop;

import crossmobile.ios.messageui.MFMessageComposeViewController;
import crossmobile.ios.messageui.MessageComposeResult;
import org.crossmobile.bridge.MessageBridge;

import java.util.List;

import static org.crossmobile.bind.system.i18n.I18NSelf.ℑ;

public class DesktopMessageBridge implements MessageBridge {

    @Override
    public boolean supportsSMS() {
        return false;
    }

    @Override
    @SuppressWarnings({"deprecation", "UnnecessaryFullyQualifiedName"})
    public boolean launchSMS(List<String> recipients, String body, MFMessageComposeViewController controller) {
        new crossmobile.ios.uikit.UIAlertView(ℑ("Unsupported protocol"), ℑ("Unable to use SMS service"), null, ℑ("Acknowledge")).show();
        if (controller != null && controller.messageComposeDelegate() != null)
            controller.messageComposeDelegate().didFinishWithResult(controller, MessageComposeResult.Failed);
        return false;
    }
}
