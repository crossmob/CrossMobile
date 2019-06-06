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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

/**
 * NSURLConnectionDataDelegate interface is the delegate responsible for
 * handling events related to data of NSURLConnection objects.
 */
@CMClass
public interface NSURLConnectionDataDelegate extends NSURLConnectionDelegate {

    /**
     * It is used after the connection has loaded the received data.
     *
     * @param connection The connection that sends the message.
     * @param data       The new data.
     */
    @CMSelector("- (void)connection:(NSURLConnection *)connection \n"
            + "    didReceiveData:(NSData *)data;")
    default void didReceiveData(NSURLConnection connection, NSData data) {
    }

    /**
     * It is used after the connection has received enough data for the URL
     * construction as response to the request.
     *
     * @param connection The connection that sends the message.
     * @param response   The URL response of request.
     */
    @CMSelector("- (void)connection:(NSURLConnection *)connection \n"
            + "didReceiveResponse:(NSURLResponse *)response;")
    default void didReceiveResponse(NSURLConnection connection, NSURLResponse response) {
    }

    /**
     * It is used after the connection has finished loading successfully.
     *
     * @param p1 The connection that sends the message.
     */
    @CMSelector("- (void)connectionDidFinishLoading:(NSURLConnection *)connection;")
    default void didFinishLoading(NSURLConnection p1) {
    }
}
