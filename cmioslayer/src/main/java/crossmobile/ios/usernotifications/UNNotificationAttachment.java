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
package crossmobile.ios.usernotifications;

import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURL;
import crossmobile.rt.StrongReference;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Map;

@CMClass
public class UNNotificationAttachment extends NSObject {

    private final String identifier;
    private final NSURL URL;
    private final String type;

    UNNotificationAttachment(String identifier, NSURL URL, String type) {
        this.identifier = identifier;
        this.URL = URL;
        this.type = type;
    }

    @CMSelector("+ (instancetype)attachmentWithIdentifier:(NSString *)identifier \n"
            + "                                     URL:(NSURL *)URL \n"
            + "                                 options:(NSDictionary *)options \n"
            + "                                   error:(NSError * _Nullable *)error;")
    public static UNNotificationAttachment attachmentWithIdentifier(String identifier, NSURL URL, Map<String, Object> options, StrongReference<NSError> error) {
        return new UNNotificationAttachment(identifier, URL, (String) options.get(UNNotificationAttachmentOptions.TypeHintKey));
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSURL *URL;")
    public NSURL URL() {
        return URL;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSString *type;")
    public String type() {
        return type;
    }
}
