/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class UNNotificationRequest extends NSObject implements NSSecureCoding {

    private final String identifier;
    private final UNNotificationContent content;
    private final UNNotificationTrigger trigger;

    UNNotificationRequest(String identifier, UNNotificationContent content, UNNotificationTrigger trigger) {
        this.identifier = identifier;
        this.content = content;
        this.trigger = trigger;
    }

    @CMSelector("+ (instancetype)requestWithIdentifier:(NSString *)identifier \n"
            + "                              content:(UNNotificationContent *)content \n"
            + "                              trigger:(UNNotificationTrigger *)trigger;")
    public static UNNotificationRequest requestWithIdentifier(String identifier, UNNotificationContent content, UNNotificationTrigger trigger) {
        return new UNNotificationRequest(identifier, content, trigger);
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

    @CMGetter("@property(readonly, copy, nonatomic) UNNotificationContent *content;")
    public UNNotificationContent content() {
        return content;
    }

    @CMGetter("@property(readonly, copy, nonatomic) UNNotificationTrigger *trigger;")
    public UNNotificationTrigger trigger() {
        return trigger;
    }
}
