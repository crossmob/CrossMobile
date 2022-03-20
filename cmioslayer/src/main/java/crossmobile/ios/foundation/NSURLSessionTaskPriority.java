/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class NSURLSessionTaskPriority {

    public final static float NSURLSessionTaskPriorityLow = 0.25f;
    public final static float NSURLSessionTaskPriorityHigh = 0.75f;
    public final static float NSURLSessionTaskPriorityDefault = 0.50f;

    NSURLSessionTaskPriority() {
    }
}
