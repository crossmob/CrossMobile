/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.addressbook;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock2;

/**
 * ABAddressBookRequestAccessCompletionHandler interface specifies the handler that is
 * called when an access request is completed.
 */
@CMTarget
public interface ABAddressBookRequestAccessCompletionHandler extends VoidBlock2<Boolean, NSError> {

    /**
     * It is called when an access request is completed.
     *
     * @param granted TRUE if the access is granted after the request.
     * @param error   The error in case of failure.
     */
    @Override
    @CMBlock("void (^ABAddressBookRequestAccessCompletionHandler)(bool granted, CFErrorRef error);")
    public void invoke(Boolean granted, NSError error);
}
