/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
