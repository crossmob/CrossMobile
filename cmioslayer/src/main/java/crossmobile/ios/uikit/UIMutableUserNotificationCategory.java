/*
 * (c) 2019 by Panayotis Katsaloulis
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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.HashMap;
import java.util.List;

/**
 * UIMutableUserNotificationCategory class defines an object that holds
 * information related to customized actions in response to local or push
 * notifications.
 */
@CMClass
@CMLib(name = "cmnotifications")
public class UIMutableUserNotificationCategory extends UIUserNotificationCategory {

    /**
     * Sets the name of the action group.
     *
     * @param identifier The action group category name.
     */
    @CMSetter("@property(nonatomic, copy) NSString *identifier;")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Assigns the specified actions to the specified context.
     *
     * @param actions                         The actions to be assigned to the specified context.
     * @param UIUserNotificationActionContext The context for which the actions
     *                                        are assigned.
     * @see crossmobile.ios.uikit.UIUserNotificationActionContext
     */
    @CMSelector("- (void)setActions:(NSArray<UIUserNotificationAction *> *)actions \n"
            + "        forContext:(UIUserNotificationActionContext)context;")
    public void setActions(List<UIUserNotificationAction> actions, int UIUserNotificationActionContext) {
        if (actions == null || actions.isEmpty()) {
            if (this.actions != null) {
                this.actions.remove(UIUserNotificationActionContext);
                if (this.actions.isEmpty())
                    this.actions = null;
            }
        } else {
            if (this.actions == null)
                this.actions = new HashMap<>();
            this.actions.put(UIUserNotificationActionContext, actions);
        }
    }

}
