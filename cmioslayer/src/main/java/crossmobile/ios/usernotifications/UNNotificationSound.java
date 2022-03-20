/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class UNNotificationSound extends NSObject implements NSSecureCoding {

    UNNotificationSound() {
    }

    UNNotificationSound(String name) {
    }

    @CMSelector("+ (instancetype)defaultSound;")
    public static UNNotificationSound defaultSound() {
        return new UNNotificationSound();
    }

    @CMSelector("+ (instancetype)soundNamed:(NSString *)name;")
    public static UNNotificationSound soundNamed(String name) {
        return new UNNotificationSound(name);
    }
}
