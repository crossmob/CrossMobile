/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.HashMap;
import java.util.Map;

/**
 * NSNotification class defines information objects used by the
 * NSNotificationCenter for application's intercommunication.
 */
@CMClass
public class NSNotification extends NSObject {

    final String name;
    final Object object;
    private final Map<String, ?> userInfo;

    @CMSelector("+ (instancetype)notificationWithName:(NSNotificationName)aName \n"
            + "                              object:(id)anObject;")
    public static NSNotification notificationWithName(String aName, Object anObject) {
        return notificationWithName(aName, anObject, null);
    }

    @CMSelector("+ (instancetype)notificationWithName:(NSNotificationName)aName \n"
            + "                              object:(id)anObject \n"
            + "                            userInfo:(NSDictionary *)aUserInfo;")
    public static NSNotification notificationWithName(String aName, Object anObject, Map<String, ?> aUserInfo) {
        return new NSNotification(aName, anObject, aUserInfo);
    }

    @CMConstructor("- (instancetype)initWithName:(NSNotificationName)name \n"
            + "                      object:(id)object \n"
            + "                    userInfo:(NSDictionary *)userInfo;")
    public NSNotification(String aName, Object anObject, Map<String, ?> aUserInfo) {
        this.name = aName;
        this.object = anObject;
        this.userInfo = aUserInfo;
    }

    @CMGetter("@property(readonly, copy) NSNotificationName name;")
    public String name() {
        return name;
    }

    @CMGetter("@property(readonly, retain) id object;")
    public Object object() {
        return object;
    }

    /**
     * Returns a dictionary with the user information.
     *
     * @return The dictionary with the user information.
     */
    @CMGetter("@property(readonly, copy) NSDictionary *userInfo;")
    public Map<String, ?> userInfo() {
        return new HashMap<String, Object>(userInfo);
    }
}
