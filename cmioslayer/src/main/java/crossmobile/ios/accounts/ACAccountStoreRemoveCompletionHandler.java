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
 * ACAccountStoreRemoveCompletionHandler interface specifies the handler that is called
 * when an account is being removed from the store.
 */
@CMTarget
public interface ACAccountStoreRemoveCompletionHandler extends VoidBlock2<Boolean, NSError> {

    /**
     * It is called when an account is being removed from the store.
     *
     * @param input1 TRUE, if the removal is successful.
     * @param input2 The error in case of failure.
     */
    @Override
    @CMBlock("void(^ACAccountStoreRemoveCompletionHandler)(BOOL success, NSError *error);")
    public void invoke(Boolean input1, NSError input2);

}
