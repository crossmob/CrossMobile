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
