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
package crossmobile.ios.touchid;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class LAError {

    public static final int AppCancel = -9;
    public static final int SystemCancel = -4;
    public static final int UserCancel = -2;
    public static final int BiometryLockout = -8;
    public static final int BiometryNotAvailable = -6;
    public static final int BiometryNotEnrolled = -7;
    public static final int TouchIDLockout = -8;
    public static final int TouchIDNotAvailable = -6;
    public static final int TouchIDNotEnrolled = -7;
    public static final int AuthenticationFailed = -1;
    public static final int InvalidContext = -10;
    public static final int NotInteractive = -1004;
    public static final int PasscodeNotSet = -5;
    public static final int UserFallback = -3;

    private LAError() {

    }

}

/*
LAError Authentication failed: 0 
LAError Invalid value: 9 
LAError Pasccode not set: 4 
LAError Touch id not available: 5 
LAError System cancel: 3 
 */
