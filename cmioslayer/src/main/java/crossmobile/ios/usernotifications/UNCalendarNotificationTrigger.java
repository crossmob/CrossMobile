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
        Native.lifecycle().notImplemented();
        return null;
    }

    @CMGetter("@property(readonly, copy, nonatomic) NSDateComponents *dateComponents;")
    public NSDateComponents dateComponents() {
        return dateComponents;
    }

}
