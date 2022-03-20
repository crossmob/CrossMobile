/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMClass;

@CMClass
public class UNPushNotificationTrigger extends UNNotificationTrigger {

    UNPushNotificationTrigger(boolean repeats) {
        super(repeats);
    }
}
