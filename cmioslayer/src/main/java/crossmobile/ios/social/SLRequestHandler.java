/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.social;

import crossmobile.ios.foundation.NSData;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.foundation.NSHTTPURLResponse;
import org.crossmobile.bridge.ann.CMBlock;
import org.crossmobile.bridge.ann.CMTarget;
import org.robovm.objc.block.VoidBlock3;

/**
 * SLRequestHandler interface is the handler that is called when a request is
 * done.
 */
@CMTarget
public interface SLRequestHandler extends VoidBlock3<NSData, NSHTTPURLResponse, NSError> {

    /**
     * It is called when request is done.
     *
     * @param responseData The related NSData.
     * @param urlResponse  The response to the request.
     * @param error        The error in case of failure.
     */
    @Override
    @CMBlock("void(^SLRequestHandler)(NSData *responseData, NSHTTPURLResponse *urlResponse, NSError *error);")
    public void invoke(NSData responseData, NSHTTPURLResponse urlResponse, NSError error);

}
