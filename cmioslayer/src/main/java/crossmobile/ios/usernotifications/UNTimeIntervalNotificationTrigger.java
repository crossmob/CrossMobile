/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
        Native.system().notImplemented();
        return null;
    }
}
