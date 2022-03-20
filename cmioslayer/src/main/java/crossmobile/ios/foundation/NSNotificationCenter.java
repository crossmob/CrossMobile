/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMJoinSEL;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * NSNotificationCenter class defines an object that handles the notifications
 * of the application.
 */
@CMClass
public class NSNotificationCenter extends NSObject {

    private static final NSNotificationCenter defaultCenter = new NSNotificationCenter();

    private Collection<NotificationItem> queue = new HashSet<>();

    private NSNotificationCenter() {
    }

    /**
     * Returns the default notification center.
     *
     * @return The default notification center.
     */
    @CMSelector("+ (NSNotificationCenter *) defaultCenter;")
    public static NSNotificationCenter defaultCenter() {
        return defaultCenter;
    }

    /**
     * Adds an observer for the specified notification
     *
     * @param observer The object registered as an observer. Not NULL.
     * @param aName    The name of the notification.
     * @param anObject The object whose notifications will be received the
     *                 observer.
     */
    @CMSelector("- (void)addObserver:(id)observer \n"
            + "           selector:(SEL)aSelector \n"
            + "               name:(NSNotificationName)aName \n"
            + "             object:(id)anObject;")
    public void addObserver(@CMJoinSEL(selector = "aSelector", target = "observer") NSSelector<NSNotification> observer, String aName, Object anObject) {
        if (observer == null)
            return;
        queue.add(new NotificationItem(observer, aName, anObject));
    }

    @CMSelector("- (void)removeObserver:(id)observer;")
    public void removeObserver(NSSelector<NSNotification> observer) {
        removeObserver(observer, null, null);
    }

    @CMSelector("- (void)removeObserver:(id)observer \n"
            + "                  name:(NSNotificationName)aName \n"
            + "                object:(id)anObject;")
    @SuppressWarnings("StringEquality")
    public void removeObserver(NSSelector<NSNotification> observer, String aName, Object anObject) {
        if (observer == null)
            return;
        Iterator<NotificationItem> iterator = queue.iterator();
        while (iterator.hasNext()) {
            NotificationItem item = iterator.next();
            if (observer == item.observer) {
                if (aName != null && aName != item.name)
                    continue;
                if (anObject != null && anObject != item.object)
                    continue;
                iterator.remove();
            }
        }
    }

    @CMSelector("- (void)postNotificationName:(NSNotificationName)aName \n"
            + "                      object:(id)anObject;")
    public void postNotificationName(String aName, Object anObject) {
        postNotificationName(aName, anObject, null);
    }

    @CMSelector("- (void)postNotificationName:(NSNotificationName)aName \n"
            + "                      object:(id)anObject \n"
            + "                    userInfo:(NSDictionary *)aUserInfo;")
    public void postNotificationName(String aName, Object anObject, Map<String, ?> aUserInfo) {
        postNotification(new NSNotification(aName, anObject, aUserInfo));
    }

    /**
     * Posts the specified notification.
     *
     * @param notification The notification to post.Not NULL.
     */
    @CMSelector("- (void)postNotification:(NSNotification *)notification;")
    public void postNotification(NSNotification notification) {
        for (NotificationItem item : queue) {
            if (item.name != null && !item.name.equals(notification.name))
                continue;
            if (item.object != null && item.object != notification.object)
                continue;
            item.observer.exec(notification);
        }
    }

    private static class NotificationItem {

        private final NSSelector<NSNotification> observer;
        private final String name;
        private final Object object;

        public NotificationItem(NSSelector<NSNotification> observer, String name, Object object) {
            this.observer = observer;
            this.name = name;
            this.object = object;
        }

        @Override
        public String toString() {
            return "Notification[" + name + "]";
        }
    }

}
