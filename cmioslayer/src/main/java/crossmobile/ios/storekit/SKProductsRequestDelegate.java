/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
