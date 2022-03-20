/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
