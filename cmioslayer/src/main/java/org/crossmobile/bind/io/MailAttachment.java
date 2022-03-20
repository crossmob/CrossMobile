/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.io;

import crossmobile.ios.foundation.NSData;

public class MailAttachment {

    public final NSData attachment;
    public final String mimeType;
    public final String filename;

    public MailAttachment(NSData attachment, String mimeType, String filename) {
        this.attachment = attachment;
        this.mimeType = mimeType;
        this.filename = filename;
    }
}
