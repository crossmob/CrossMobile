/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSSecureCoding;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;
import java.util.Map;

/**
 * UIUserNotificationCategory class defines an object that holds information
 * related to the custom actions executed in response to local or push
 * notifications.
 */
@CMClass
@CMLib(name = "cmnotifications")
public class UIUserNotificationCategory extends NSObject implements NSSecureCoding {

    String identifier;
    Map<Integer, List<UIUserNotificationAction>> actions;

    /**
     * Returns the name of the action group.
     *
     * @return The name of the action group.
     */
    @CMGetter("@property(nonatomic, copy, readonly) NSString *identifier;")
    public String identifier() {
        return identifier;
    }

    /**
     * Returns a list of all the actions for the specified notification context.
     *
     * @param UIUserNotificationActionContext The notification context for which
     *                                        the action are requested.
     * @return The list of all the actions for the specified notification
     * context.
     * @see crossmobile.ios.uikit.UIUserNotificationActionContext
     */
    @CMSelector("- (NSArray<UIUserNotificationAction *> *)actionsForContext:(UIUserNotificationActionContext)context;")
    public List<UIUserNotificationAction> actionsForContext(int UIUserNotificationActionContext) {
        return actions == null ? null : actions.get(UIUserNotificationActionContext);
    }
}
