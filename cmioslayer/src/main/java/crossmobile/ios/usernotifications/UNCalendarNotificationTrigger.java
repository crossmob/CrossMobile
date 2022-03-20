/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSDateComponents;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class UNCalendarNotificationTrigger extends UNNotificationTrigger {

    private final NSDateComponents dateComponents;

    UNCalendarNotificationTrigger(NSDateComponents dateComponents, boolean repeats) {
        super(repeats);
        this.dateComponents = dateComponents;
    }

    @CMSelector("+ (instancetype)triggerWithDateMatchingComponents:(NSDateComponents *)dateComponents \n"
            + "                                          repeats:(BOOL)repeats;")
    public static UNCalendarNotificationTrigger triggerWithDateMatchingComponents(NSDateComponents dateComponents, boolean repeats) {
        return new UNCalendarNotificationTrigger(dateComponents, repeats);
    }

    @CMSelector("- (NSDate *)nextTriggerDate;")
    public NSDate nextTriggerDate() {
        Native.system().notImplemented();
        return null;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSDateComponents *dateComponents;")
    public NSDateComponents dateComponents() {
        return dateComponents;
    }

}
