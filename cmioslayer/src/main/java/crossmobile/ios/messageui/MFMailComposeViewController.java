/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.messageui;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSString;
import crossmobile.ios.foundation.NSStringEncoding;
import crossmobile.ios.foundation.NSURL;
import crossmobile.ios.uikit.UIApplication;
import crossmobile.ios.uikit.UINavigationController;
import org.crossmobile.bind.io.MailAttachment;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.ArrayList;
import java.util.List;

/**
 * MFMailComposeViewController class defines an object that handles email
 * message composing and sending.
 */
@CMClass
public class MFMailComposeViewController extends UINavigationController {

    private MFMailComposeViewControllerDelegate delegate;
    private String subject;
    private String body;
    private boolean HTMLBody;
    private List<String> toRecipients;
    private List<String> ccRecipients;
    private List<String> bccRecipients;
    private List<MailAttachment> attachments;

    /**
     * Returns a Boolean that shows whether the device supports email message
     * sending.
     *
     * @return TRUE then the device supports email message sending.
     */
    @CMSelector("+ (BOOL)canSendMail;")
    public static boolean canSendMail() {
        return true;
    }

    /**
     * The default constructor.
     */
    public MFMailComposeViewController() {
        super(null);
    }

    /**
     * Returns the delegate of this MFMailComposeViewController.
     *
     * @return The delegate of this MFMailComposeViewController.
     */
    @CMGetter("@property(nonatomic, assign) id<MFMailComposeViewControllerDelegate> mailComposeDelegate;")
    public MFMailComposeViewControllerDelegate mailComposeDelegate() {
        return delegate;
    }

    /**
     * Sets the delegate for this MFMailComposeViewController.
     *
     * @param mailComposeDelegate The delegate for this
     *                            MFMailComposeViewController.
     */
    @CMSetter("@property(nonatomic, assign) id<MFMailComposeViewControllerDelegate> mailComposeDelegate;")
    public void setMailComposeDelegate(MFMailComposeViewControllerDelegate mailComposeDelegate) {
        this.delegate = mailComposeDelegate;
    }

    /**
     * Adds the specified data as an attachment to the message.
     *
     * @param attachment The data to attach. Typically, this is the contents of
     *                   a file that you want to include. This parameter must not be nil.
     * @param mimeType   The MIME type of the specified data. (For example, the
     *                   MIME type for a JPEG image is image/jpeg.) For a list of valid MIME
     *                   types, see http://www.iana.org/assignments/media-types/. This parameter
     *                   must not be nil.
     * @param filename   The preferred filename to associate with the data.
     */
    @CMSelector("- (void)addAttachmentData:(NSData *)attachment \n"
            + "                 mimeType:(NSString *)mimeType \n"
            + "                 fileName:(NSString *)filename;")
    public void addAttachmentData(NSData attachment, String mimeType, String filename) {
        if (attachments == null)
            attachments = new ArrayList<MailAttachment>();
        attachments.add(new MailAttachment(attachment, filename, filename));
    }

    /**
     * Sets the Bcc recipients of the email message.
     *
     * @param bccRecipients The Bcc recipients of the email message.
     */
    @CMSelector("- (void)setBccRecipients:(NSArray<NSString *> *)bccRecipients;")
    public void setBccRecipients(List<String> bccRecipients) {
        this.bccRecipients = bccRecipients;
    }

    /**
     * Sets the Cc recipients of the email message.
     *
     * @param ccRecipients The Cc recipients of the email message.
     */
    @CMSelector("- (void)setCcRecipients:(NSArray<NSString *> *)ccRecipients;")
    public void setCcRecipients(List<String> ccRecipients) {
        this.ccRecipients = ccRecipients;
    }

    /**
     * Sets the text-body of the email message.
     *
     * @param body   The text-body of the email message.
     * @param isHTML TRUE the content is HTML.
     */
    @CMSelector("- (void)setMessageBody:(NSString *)body \n"
            + "                isHTML:(BOOL)isHTML;")
    public void setMessageBody(String body, boolean isHTML) {
        this.body = body;
        this.HTMLBody = isHTML;
    }

    /**
     * Sets the subject of the email message.
     *
     * @param subject The subject of the email message.
     */
    @CMSelector("- (void)setSubject:(NSString *)subject;\n"
            + "")
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Sets a list with the recipients of the email message.
     *
     * @param toRecipients A list with the recipients of the email message.
     */
    @CMSelector("- (void)setToRecipients:(NSArray<NSString *> *)toRecipients;")
    public void setToRecipients(List<String> toRecipients) {
        this.toRecipients = toRecipients;
    }

    @SuppressWarnings("deprecation")
    @Override
    public void viewWillAppear(boolean animated) {
        super.viewWillAppear(animated);
        NSURL url = NSURL.URLWithString("mailto:"
                + recipientsFromList(toRecipients)
                + "?cc=" + recipientsFromList(ccRecipients)
                + "&bcc=" + recipientsFromList(bccRecipients)
                + "&subject=" + NSString.stringByAddingPercentEscapesUsingEncoding(subject, NSStringEncoding.UTF8)
                + "&body=" + NSString.stringByAddingPercentEscapesUsingEncoding(body, NSStringEncoding.UTF8));
        if (url != null)
            UIApplication.sharedApplication().openURL(url);
        if (delegate != null)
            delegate.didFinishWithResult(this, MFMailComposeResult.Sent, null);
    }

    private String recipientsFromList(List<String> recipients) {
        StringBuilder to = new StringBuilder();
        if (recipients != null)
            for (String rec : recipients)
                to.append(",").append(rec);
        String all = to.toString();
        if (!all.isEmpty())
            all = all.substring(1);
        return all;
    }
}
