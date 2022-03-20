/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.List;
import java.util.Map;

@CMClass
public class NSExtensionItem extends NSObject implements NSSecureCoding {
    public static final String AttributedTitleKey = "NSExtensionItemAttributedTitleKey";
    public static final String AttributedContentTextKey = "NSExtensionItemAttributedContentTextKey";
    public static final String AttachmentsKey = "NSExtensionItemAttachmentsKey";

    private Map<String, Object> userInfo;
    private List<NSItemProvider> attachments;

    @CMGetter("@property(copy, nonatomic) NSDictionary *userInfo;")
    public Map<String, Object> userInfo() {
        return userInfo;
    }

    @CMSetter("@property(copy, nonatomic) NSDictionary *userInfo;")
    public void setUserInfo(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }

    @CMGetter("@property(copy, nonatomic) NSArray *attachments;")
    public List<NSItemProvider> attachments() {
        return attachments;
    }

    @CMSetter("@property(copy, nonatomic) NSArray *attachments;")
    public void setAttachments(List<NSItemProvider> attachments) {
        this.attachments = attachments;
    }

}
