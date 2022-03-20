/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.accounts;

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock2;

/**
 * ACAccountStoreSaveCompletionHandler interface specifies the handler that is called
 * after the completion of an operation in an Accounts database.
 */
@CMTarget
public interface ACAccountStoreSaveCompletionHandler extends VoidBlock2<Boolean, NSError> {

    /**
     * It is called in order to handle the completion of an operation in the account database.
     *
     * @param input1 TRUE if the operation was successful.
     * @param input2 The error in case of failure.
     */
    @Override
    @CMBlock(" void (^ACAccountStoreSaveCompletionHandler)(BOOL success, NSError *error);")
    public void invoke(Boolean input1, NSError input2);

}
