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
 * ACAccountStoreRequestAccessCompletionHandler interface specifies the handler that is
 * called when access is granted or denied.
 */
@CMTarget
public interface ACAccountStoreRequestAccessCompletionHandler extends VoidBlock2<Boolean, NSError> {

    /**
     * It is called when access to account stored is requested.
     *
     * @param input1 TRUE, if access if granted.
     * @param input2 The error in case of failure.
     */
    @Override
    @CMBlock("void (^ACAccountStoreRequestAccessCompletionHandler)(BOOL granted, NSError *error);")
    public void invoke(Boolean input1, NSError input2);

}
