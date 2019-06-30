/*
 * (c) 2019 by Panayotis Katsaloulis
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
