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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;

/**
 * NSTimeZone class defines an object that represents the time zone of the
 * application.
 */
@CMClass
public class NSTimeZone extends NSObject implements NSSecureCoding {

    private final String name;

    /**
     * Constructs a NSTimeZone object with the specified name.
     *
     * @param name The name of the NSTimeZone object.
     */
    @CMConstructor("- (instancetype)initWithName:(NSString *)tzName")
    public NSTimeZone(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this NSTimeZone object.
     *
     * @return The name of the NSTimeZone object.
     */
    @CMGetter("@property(readonly, copy) NSString *name;")
    public String name() {
        return name;
    }
}
