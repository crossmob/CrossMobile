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
