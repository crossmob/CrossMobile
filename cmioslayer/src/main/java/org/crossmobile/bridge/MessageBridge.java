/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import crossmobile.ios.messageui.MFMessageComposeViewController;

import java.util.List;

public interface MessageBridge {

    boolean supportsSMS();

    boolean launchSMS(List<String> recipients, String body, MFMessageComposeViewController controller);

}
