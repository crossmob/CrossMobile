/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.storekit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * SKProductsRequestDelegate interface is the delegate that is responsible for
 * handling operations related to SKProductsRequest objects.
 */
@CMClass
public interface SKProductsRequestDelegate {

    /**
     * It is used when a response is received from the App Store for the related request.
     *
     * @param request  The request that corresponds to this delegate.
     * @param response The response from the App Store.
     */
    @CMSelector("- (void)productsRequest:(SKProductsRequest *)request \n" +
            "     didReceiveResponse:(SKProductsResponse *)response;")
    public void didReceiveResponse(SKProductsRequest request, SKProductsResponse response);
}
