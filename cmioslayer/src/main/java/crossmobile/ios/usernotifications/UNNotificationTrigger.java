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

@CMClass
public class UNNotificationTrigger extends NSObject implements NSSecureCoding {

    private final boolean repeats;

    UNNotificationTrigger(boolean repeats) {
        this.repeats = repeats;
    }

    @CMGetter("@property(readonly, nonatomic) BOOL repeats;")
    public boolean repeats() {
        return repeats;
    }
}
