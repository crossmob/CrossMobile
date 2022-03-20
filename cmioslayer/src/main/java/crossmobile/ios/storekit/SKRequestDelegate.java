/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
    default void didFailWithError(SKRequest request, NSError error) {
    }

    /**
     * It is used in order to handle the successful request process.
     *
     * @param request The SKRequest object that corresponds to this delegate.
     */
    @CMSelector("- (void)requestDidFinish:(SKRequest *)request;")
    default void didFinish(SKRequest request) {
    }
}
