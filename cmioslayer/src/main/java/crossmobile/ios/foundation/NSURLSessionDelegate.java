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

@CMClass
public interface NSURLSessionDelegate {

    @CMSelector("- (void)URLSession:(NSURLSession *)session\n"
            + "    didBecomeInvalidWithError:(NSError *)error;")
    public void didBecomeInvalidWithError(NSURLSession session, NSError error);
//    @CMSelector("- (void)URLSession:(NSURLSession *)session\n" +
//            "    didReceiveChallenge:(NSURLAuthenticationChallenge *)challenge\n" +
//            "    completionHandler:(void (^)(NSURLSessionAuthChallengeDisposition disposition, NSURLCredential *credential))completionHandler;")
//    public void didReceiveChallenge(NSURLSession session, BlockInputInputInput<NSURLSessionAuthChallengeDisposition,NSURLCredential> completionHandler);

    @CMSelector("- (void)URLSessionDidFinishEventsForBackgroundURLSession:(NSURLSession *)session;")
    public void didFinishEventsForBackgroundURLSession(NSURLSession session);
}
