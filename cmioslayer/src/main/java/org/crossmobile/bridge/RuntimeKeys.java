/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bridge;

import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

/**
 * Here could be found keys available at runtime time which provide specific functionality
 */
@CMLib(target = CMLibTarget.BUILDONLY)
public final class RuntimeKeys {

    /**
     * Use to cancel the Android back button. By default the back button on the last page exits the application.
     * Before exiting, the system gives the application the chance to handle this event and probably abort program exit.
     * <p>
     * By listening to this notification, the object() property provides an AtomicBoolean with default value to "false".
     * If the application changes this value to "true" then the event is considered handled, and the application does not exit.
     * <p>
     * To listen to this notification, use the following code
     * <pre>{@code
     *     NSNotificationCenter.defaultCenter().addObserver(arg -> {
     *         boolean canExit = true;//false
     *         ((AtomicBoolean) arg.object()).set(canExit);
     *     }, AndroidBackButtonNotification, null);
     *  }
     *  </pre>
     */
    public static final String AndroidBackButtonNotification = "AndroidBackButtonNotification";

    /**
     * Use this dynamic user default to retreive the actual Facebook SDK Application signature. Note this
     * value is not stored but dynamically calculated when requested.
     * <p>
     * Example code:
     * {@code NSUserDefaults.standardUserDefaults().stringForKey(FacebookSdkApplicationSignature); }
     */
    public static final String FacebookSdkApplicationSignature = "FacebookSdkApplicationSignature";

    private RuntimeKeys() {
    }
}
