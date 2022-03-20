/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * NSURLConnectionDelegate interface is the delegate responsible for handling
 * success or failure of connections.
 */
@CMClass
public interface NSURLConnectionDelegate {

    /**
     * It is used after a connection load request failure.
     *
     * @param p1 The connection that sends the message.
     * @param p2 An error object with the details of the connection failure.
     */
    @CMSelector("- (void)connection:(NSURLConnection *)connection \n"
            + "  didFailWithError:(NSError *)error;\n"
            + "")
    default void didFailWithError(NSURLConnection p1, NSError p2) {
    }
}
