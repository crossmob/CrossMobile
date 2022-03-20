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
 * ACAccountStoreCredentialRenewalHandler interface specifies the handler that is
 * called when the credentials are renewed.
 */
@CMTarget
public interface ACAccountStoreCredentialRenewalHandler extends VoidBlock2<Integer, NSError> {

    /**
     * It is called in order to handle account credentials' renewal.
     *
     * @param renewResult The result of the event of renewing account credentials.
     * @param error       The error in case of failure.
     */
    @Override
    @CMBlock("void(^ACAccountStoreCredentialRenewalHandler)(ACAccountCredentialRenewResult renewResult, NSError *error);")
    public void invoke(Integer renewResult, NSError error);

}
