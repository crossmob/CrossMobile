/*
 * (c) 2020 by Panayotis Katsaloulis
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
