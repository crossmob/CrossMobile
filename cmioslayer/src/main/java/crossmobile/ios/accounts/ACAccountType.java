/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns the id of this type of account.
     *
     * @return The id of this type of account.
     */
    @CMGetter("@property(readonly, nonatomic) NSString *identifier;")
    public String identifier() {
        Native.system().notImplemented();
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
        Native.system().notImplemented();
        return false;
    }
}
