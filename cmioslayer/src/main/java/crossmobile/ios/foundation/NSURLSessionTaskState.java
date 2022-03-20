/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class NSURLSessionTaskState {

    public static final int Running = 0;
    public static final int Suspended = 1;
    public static final int Canceling = 2;
    public static final int Completed = 3;

    NSURLSessionTaskState() {

    }
}
