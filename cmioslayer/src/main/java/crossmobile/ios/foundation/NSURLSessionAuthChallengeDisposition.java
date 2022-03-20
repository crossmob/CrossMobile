/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class NSURLSessionAuthChallengeDisposition {

    public final static int UseCredential = 0;
    public final static int PerformDefaultHandling = 1;
    public final static int CancelAuthenticationChallenge = 2;
    public final static int RejectProtectionSpace = 3;

    NSURLSessionAuthChallengeDisposition() {
    }
}
