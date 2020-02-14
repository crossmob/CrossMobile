/*
 * (c) 2020 by Panayotis Katsaloulis
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

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

@CMClass
public class UNNotificationAction extends NSObject implements NSSecureCoding {

    private final String identifier;
    private final String title;
    private final long options;

    UNNotificationAction(String identifier, String title, long options) {
        this.identifier = identifier;
        this.title = title;
        this.options = options;
    }

    @CMSelector("+ (instancetype)actionWithIdentifier:(NSString *)identifier \n"
            + "                               title:(NSString *)title \n"
            + "                             options:(UNNotificationActionOptions)options;")
    public static UNNotificationAction actionWithIdentifier(String identifier, String title, long options) {
        return new UNNotificationAction(identifier, title, options);
    }

    @CMGetter("@property(copy, readonly, nonatomic) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

    @CMGetter("@property(copy, readonly, nonatomic) NSString *title;")
    public String title() {
        return title;
    }

    @CMGetter("@property(readonly, nonatomic) UNNotificationActionOptions options;")
    public long options() {
        return options;
    }

}
