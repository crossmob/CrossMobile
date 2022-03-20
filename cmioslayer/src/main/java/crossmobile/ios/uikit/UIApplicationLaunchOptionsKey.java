/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIApplicationLaunchOptions class defines different options or information
 * related to application launching.
 */
@CMEnum
public final class UIApplicationLaunchOptionsKey {

    /**
     * The application was launched to open a URL.
     */
    public static final String URL = "UIApplicationLaunchOptionsURLKey";

    /**
     * Another application requested the launching of the application.
     */
    public static final String SourceApplication = "UIApplicationLaunchOptionsSourceApplicationKey";

    /**
     * The application depends on a remote notification in order to proceed.
     */
    public static final String RemoteNotification = "UIApplicationLaunchOptionsRemoteNotificationKey";

    /**
     * The application that requested to open the URL provided custom data.
     */
    public static final String Annotation = "UIApplicationLaunchOptionsAnnotationKey";

    /**
     * The application depends on a local notification in order to proceed.
     */
    public static final String LocalNotification = "UIApplicationLaunchOptionsLocalNotificationKey";

    /**
     * The application was launched due to a local evenet.
     */
    public static final String Location = "UIApplicationLaunchOptionsLocationKey";

    /**
     * The requested downloaded data required for the application are available.
     */
    public static final String NewsstandDownload = "UIApplicationLaunchOptionsNewsstandDownloadsKey";

    private UIApplicationLaunchOptionsKey() {
    }
}
