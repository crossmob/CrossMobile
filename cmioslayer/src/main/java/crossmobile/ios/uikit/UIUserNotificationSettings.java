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

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Set;

/**
 * UIUserNotificationSettings class defines an object that holds all the
 * information related to the settings of the notifications that the application
 * displays.
 */
@CMClass
public class UIUserNotificationSettings extends NSObject {

    private final Set<UIUserNotificationCategory> categories;
    private final int types;

    private UIUserNotificationSettings(int types, Set<UIUserNotificationCategory> categories) {
        this.types = types;
        this.categories = categories;
    }

    /**
     * Constructs and returns a UIUserNotificationSettings object for the
     * specified notification type and set of categories.
     *
     * @param UIUserNotificationType The notification type of the returned
     *                               object.
     * @param categories             The set of categories supported by the returned object.
     * @return The new UIUserNotificationSettings object.
     * @see crossmobile.ios.uikit.UIUserNotificationType
     */
    @CMSelector("+ (instancetype)settingsForTypes:(UIUserNotificationType)types categories:(NSSet<UIUserNotificationCategory *> *)categories;")
    public static UIUserNotificationSettings settingsForTypes(int UIUserNotificationType, Set<UIUserNotificationCategory> categories) {
        return new UIUserNotificationSettings(UIUserNotificationType, categories);
    }

    /**
     * Returns the group of actions for this app.
     *
     * @return The group of actions for this app.
     * @see crossmobile.ios.uikit.UIUserNotificationCategory
     */
    @CMGetter("@property(nonatomic, copy, readonly) NSSet<UIUserNotificationCategory *> *categories;")
    public Set<UIUserNotificationCategory> categories() {
        return categories;
    }

    /**
     * Returns the type of the available types of notifications for the app.
     *
     * @return The available types of notifications for the app.
     * @see crossmobile.ios.uikit.UIUserNotificationType
     */
    @CMGetter("@property(nonatomic, readonly) UIUserNotificationType types;")
    public int types() {
        return types;
    }

}
