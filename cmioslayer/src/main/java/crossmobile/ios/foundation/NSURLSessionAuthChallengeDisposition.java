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
