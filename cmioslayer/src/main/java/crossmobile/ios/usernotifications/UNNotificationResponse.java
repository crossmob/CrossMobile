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

@CMClass
public class UNNotificationResponse extends NSObject implements NSSecureCoding {

    private final String actionIdentifier;
    private final UNNotification notification;

    UNNotificationResponse(String actionIdentifier, UNNotification notification) {
        this.actionIdentifier = actionIdentifier;
        this.notification = notification;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSString *actionIdentifier;")
    public String actionIdentifier() {
        return actionIdentifier;
    }

    @CMGetter("@property(readonly, copy, nonatomic) UNNotification *notification;")
    public UNNotification notification() {
        return notification;
    }
}
