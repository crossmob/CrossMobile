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
package crossmobile.ios.accounts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

/**
 * ACAccountType class defines objects that represent specific types of
 * accounts.
 */
@CMClass
public class ACAccountType extends NSObject {

    /**
     * Returns the description of this type of account.
     *
     * @return The description of this type of account.
     */
    @CMGetter("@property(readonly, nonatomic) NSString *accountTypeDescription;")
    public String accountTypeDescription() {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Returns the id of this type of account.
     *
     * @return The id of this type of account.
     */
    @CMGetter("@property(readonly, nonatomic) NSString *identifier;")
    public String identifier() {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Returns a Boolean that shows whether the access to this type of accounts
     * is granted.
     *
     * @return TRUE then access to this type of accounts is granted.
     */
    @CMGetter("@property(readonly, nonatomic) BOOL accessGranted;")
    public boolean accessGranted() {
        Native.lifecycle().notImplemented();
        return false;
    }
}
