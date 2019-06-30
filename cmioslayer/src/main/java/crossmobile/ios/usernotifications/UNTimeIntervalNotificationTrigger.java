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

import crossmobile.ios.foundation.NSDate;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class UNTimeIntervalNotificationTrigger extends UNNotificationTrigger {

    private final double timeInterval;

    UNTimeIntervalNotificationTrigger(double timeInterval, boolean repeats) {
        super(repeats);
        this.timeInterval = timeInterval;
    }

    @CMSelector("+ (instancetype)triggerWithTimeInterval:(NSTimeInterval)timeInterval \n"
            + "repeats:(BOOL)repeats;")
    public static UNTimeIntervalNotificationTrigger triggerWithTimeInterval(double timeInterval, boolean repeats) {
        return new UNTimeIntervalNotificationTrigger(timeInterval, repeats);
    }

    @CMGetter("@property(readonly, nonatomic) NSTimeInterval timeInterval;")
    public double timeInterval() {
        return timeInterval;
    }

    @CMSelector("- (NSDate *)nextTriggerDate;")
    public NSDate nextTriggerDate() {
        Native.lifecycle().notImplemented();
        return null;
    }
}
