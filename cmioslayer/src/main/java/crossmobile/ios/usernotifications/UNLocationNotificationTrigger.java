/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import crossmobile.ios.corelocation.CLRegion;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class UNLocationNotificationTrigger extends UNNotificationTrigger {

    private final CLRegion region;

    UNLocationNotificationTrigger(CLRegion region, boolean repeats) {
        super(repeats);
        this.region = region;
    }

    @CMSelector("+ (instancetype)triggerWithRegion:(CLRegion *)region \n"
            + "                          repeats:(BOOL)repeats;")
    public static UNLocationNotificationTrigger triggerWithRegion(CLRegion region, boolean repeats) {
        return new UNLocationNotificationTrigger(region, repeats);
    }

    @CMGetter("@property(readonly, copy, nonatomic) CLRegion *region;")
    public CLRegion region() {
        return region;
    }
}
