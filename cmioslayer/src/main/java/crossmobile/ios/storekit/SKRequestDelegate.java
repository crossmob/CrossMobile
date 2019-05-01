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

import crossmobile.ios.foundation.NSError;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * SKRequestDelegate interface is the delegate responsible to
 * collaborate with SKRequest objects.
 */
@CMClass
public interface SKRequestDelegate {

    /**
     * It is used in order to handle the failure of requests.
     *
     * @param request The SKRequest object that corresponds to this delegate.
     * @param error   The error that caused failure.
     */
    @CMSelector("- (void)request:(SKRequest *)request \n" +
            "didFailWithError:(NSError *)error;")
    public default void didFailWithError(SKRequest request, NSError error) {
    }

    /**
     * It is used in order to handle the successful request process.
     *
     * @param request The SKRequest object that corresponds to this delegate.
     */
    @CMSelector("- (void)requestDidFinish:(SKRequest *)request;")
    public default void didFinish(SKRequest request) {
    }
}
