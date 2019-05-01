/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
