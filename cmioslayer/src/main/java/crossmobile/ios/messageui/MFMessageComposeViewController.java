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
package crossmobile.ios.messageui;

import crossmobile.ios.uikit.UINavigationController;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.List;

/**
 * MFMessageComposeViewController class defines an object that handles message
 * composing and sending.
 */
@CMClass
public class MFMessageComposeViewController extends UINavigationController {

    private String body;
    private List<String> recipients;
    private MFMessageComposeViewControllerDelegate delegate;

    /**
     * Returns a Boolean that shows whether the device supports text messages
     * sending.
     *
     * @return TRUE then the device supports text messages sending.
     */
    @CMSelector("+ (BOOL)canSendText;")
    public static boolean canSendText() {
        return Native.message().supportsSMS();
    }

    /**
     * Returns the text-body of the message.
     *
     * @return The text-body of the message.
     */
    @CMGetter("@property(nonatomic, copy) NSString *body;")
    public String body() {
        return body;
    }

    /**
     * Sets the text-body of the message.
     *
     * @param body The text-body of the message.
     */
    @CMSetter("@property(nonatomic, copy) NSString *body;")
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Returns a list with the recipients of the message.
     *
     * @return The list of the recipients of this message.
     */
    @CMGetter("@property(nonatomic, copy) NSArray<NSString *> *recipients;")
    public List<String> recipients() {
        return recipients;
    }

    /**
     * Sets the list of the recipients of this message.
     *
     * @param recipients The list of the recipients of this message.
     */
    @CMSetter("@property(nonatomic, copy) NSArray<NSString *> *recipients;")
    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    /**
     * Returns the delegate of this MFMessageComposeViewController.
     *
     * @return The delegate of this MFMessageComposeViewController.
     */
    @CMGetter("@property(nonatomic, assign) id<MFMessageComposeViewControllerDelegate> messageComposeDelegate;")
    public MFMessageComposeViewControllerDelegate messageComposeDelegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this MFMessageComposeViewController.
     *
     * @param delegate The delegate of this MFMessageComposeViewController.
     */
    @CMSetter("@property(nonatomic, assign) id<MFMessageComposeViewControllerDelegate> messageComposeDelegate;")
    public void setMessageComposeDelegate(MFMessageComposeViewControllerDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        if (!Native.message().supportsSMS()) {
            if (delegate != null)
                delegate.didFinishWithResult(this, MessageComposeResult.Failed);
        } else
            Native.message().launchSMS(recipients, body, this);
    }
}
