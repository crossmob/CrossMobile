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
