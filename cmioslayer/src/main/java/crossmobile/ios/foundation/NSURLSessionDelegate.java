/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
