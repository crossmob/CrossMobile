package org.crossmobile.bridge;

import crossmobile.ios.messageui.MFMessageComposeViewController;

import java.util.List;

public interface MessageBridge {

    public boolean supportsSMS();

    public boolean launchSMS(List<String> recipients, String body, MFMessageComposeViewController controller);

}
