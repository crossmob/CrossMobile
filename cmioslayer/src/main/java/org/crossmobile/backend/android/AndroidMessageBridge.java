/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import crossmobile.ios.messageui.MFMessageComposeViewController;
import crossmobile.ios.messageui.MessageComposeResult;
import org.crossmobile.bridge.MessageBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;

import java.util.List;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID, name = "cmmessages")
public class AndroidMessageBridge implements MessageBridge {

    @Override
    public boolean supportsSMS() {
        return true;
    }

    @Override
    public boolean launchSMS(List<String> recipients, String body, final MFMessageComposeViewController controller) {
        if (recipients == null || recipients.isEmpty())
            return true;
        StringBuilder reclist = new StringBuilder();
        for (String rec : recipients)
            reclist.append(";").append(rec);
        String list = "smsto:" + reclist.substring(1);
        Intent smsIntent;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(list));
            String defaultSmsPackageName = null;
            try {
                defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(MainActivity.current);
            } catch (Throwable ex) {
                Native.system().error("Unable to send SMS", ex);
            }
            if (defaultSmsPackageName != null)
                smsIntent.setPackage(defaultSmsPackageName);
        } else
            smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(list));
//        smsIntent.setData(Uri.parse(list));
//        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("sms_body", body);
        smsIntent.putExtra("exit_on_sent", true);

        MainActivity.current.getStateListener().launch((resultCode, data) -> {
            if (controller != null && controller.messageComposeDelegate() != null)
                controller.messageComposeDelegate().didFinishWithResult(controller, MessageComposeResult.Sent);
        }, smsIntent);
        return true;
    }
}
