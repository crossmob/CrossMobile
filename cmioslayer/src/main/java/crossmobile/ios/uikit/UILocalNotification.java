/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSCalendar;
import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSTimeZone;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.Map;

/**
 * UILocalNotification class's instances contain information related to
 * notifications that an application presents to the user.
 */
@Deprecated
@CMClass
public class UILocalNotification extends NSObject {

    private String alertAction;
    private String alertBody;
    private String alertLaunchImage;
    private int applicationIconBadgeNumber;
    private NSDate fireDate;
    private boolean hasAction;
    private NSCalendar repeatCalendar;
    private int repeatInterval;
    private String soundName;
    private NSTimeZone timeZone;
    private Map<String, Object> userInfo;

    /**
     * Returns the title of the notification alert.
     *
     * @return The title of the notification alert.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSString *alertAction;")
    public String alertAction() {
        return alertAction;
    }

    /**
     * Sets the title of the notification alert.
     *
     * @param alertAction The title of the notification alert.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSString *alertAction;")
    public void setAlertAction(String alertAction) {
        this.alertAction = alertAction;
    }

    /**
     * Returns the text displayed on the notification alert.
     *
     * @return The text of the notification alert.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSString *alertBody;")
    public String alertBody() {
        return alertBody;
    }

    /**
     * Sets the text of the notification alert.
     *
     * @param alertBody The text of notification alert.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSString *alertBody;")
    public void setAlertBody(String alertBody) {
        this.alertBody = alertBody;
    }

    /**
     * Returns the filename of the image used as launch image.
     *
     * @return The filename of the image used as a launch image.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSString *alertLaunchImage;")
    public String alertLaunchImage() {
        return alertLaunchImage;
    }

    /**
     * Set the filename of the image used as launch image.
     *
     * @param alertLaunchImage The filename of the image used as launch image.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSString *alertLaunchImage;")
    public void setAlertLaunchImage(String alertLaunchImage) {
        this.alertLaunchImage = alertLaunchImage;
    }

    /**
     * Returns the number that is displayed on the icon badge of the
     * application.
     *
     * @return The number that is displayed on the icon badge of the
     * application.
     */
    @Deprecated
    @CMGetter("@property(nonatomic) NSInteger applicationIconBadgeNumber;")
    public int applicationIconBadgeNumber() {
        return applicationIconBadgeNumber;
    }

    /**
     * Sets the number for the icon badge of the application.
     *
     * @param applicationIconBadgeNumber The number for icon badge of the
     *                                   application.
     */
    @Deprecated
    @CMSetter("@property(nonatomic) NSInteger applicationIconBadgeNumber;")
    public void setApplicationIconBadgeNumber(int applicationIconBadgeNumber) {
        this.applicationIconBadgeNumber = applicationIconBadgeNumber;
    }

    /**
     * Returns date and time of the notification delivery.
     *
     * @return Date and time of the notification delivery.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSDate *fireDate;")
    public NSDate fireDate() {
        return fireDate;
    }

    /**
     * Sets date and time for notification delivery.
     *
     * @param fireDate NSDate instance for notification delivery.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSDate *fireDate;")
    public void setFireDate(NSDate fireDate) {
        this.fireDate = fireDate;
    }

    /**
     * Returns a Boolean value that indicates whether the notification shows or
     * hides the alert action.
     *
     * @return A Boolean value that indicates whether the notification shows or
     * hides the alert action.
     */
    @Deprecated
    @CMGetter("@property(nonatomic) BOOL hasAction;")
    public boolean hasAction() {
        return hasAction;
    }

    /**
     * Sets a Boolean value that defines whether the notification shows or hides
     * the alert action.
     *
     * @param hasAction A Boolean value that defines whether the notification
     *                  shows or hides the alert action.
     */
    @Deprecated
    @CMSetter("@property(nonatomic) BOOL hasAction;")
    public void setHasAction(boolean hasAction) {
        this.hasAction = hasAction;
    }

    /**
     * Returns an instance of the NSCalendar that is used when the notification
     * alert is repeated.If NULL then user calendar is used.
     *
     * @return The NSCalendar that is used for repeated notification.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSCalendar *repeatCalendar;")
    public NSCalendar repeatCalendar() {
        return repeatCalendar;
    }

    /**
     * Sets the NSCanlendar used for a repeated notification.
     *
     * @param repeatCalendar The NSCalenader used for a repeated notification.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSCalendar *repeatCalendar;")
    public void setRepeatCalendar(NSCalendar repeatCalendar) {
        this.repeatCalendar = repeatCalendar;
    }

    /**
     * Returns the interval of the notification repetition.
     *
     * @return The interval of the notification repetition.
     */
    @Deprecated
    @CMGetter("@property(nonatomic) NSCalendarUnit repeatInterval;\n"
            + "")
    public int repeatInterval() {
        return repeatInterval;
    }

    /**
     * Sets the interval for the notification repetition.
     *
     * @param repeatInterval The interval for the notification repetition.
     */
    @Deprecated
    @CMSetter("@property(nonatomic) NSCalendarUnit repeatInterval;\n"
            + "")
    public void setRepeatInterval(int repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    /**
     * Returns the file name with the alert sound.
     *
     * @return The file name with the alert sound.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSString *soundName;")
    public String soundName() {
        return soundName;
    }

    /**
     * Sets the file name with the alert sound.
     *
     * @param soundName The file name with the alert sound.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSString *soundName;")
    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    /**
     * Returns the time zone for the notification delivery.
     *
     * @return The time zone for the notification delivery.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSTimeZone *timeZone;")
    public NSTimeZone timeZone() {
        return timeZone;
    }

    /**
     * Sets time zone for the notification delivery.
     *
     * @param timeZone The time zone for the notification delivery.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSTimeZone *timeZone;")
    public void setTimeZone(NSTimeZone timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * Returns a dictionary containing custom information related to the
     * notifications of the application.
     *
     * @return A dictionary containing custom information related to the
     * notifications of the application.
     */
    @Deprecated
    @CMGetter("@property(nonatomic, copy) NSDictionary *userInfo;")
    public Map<String, Object> userInfo() {
        return userInfo;
    }

    /**
     * Sets a dictionary that contains custom information related to the
     * notifications of the application.
     *
     * @param userInfo A dictionary that contains custom information related to
     *                 the notifications of the application.
     */
    @Deprecated
    @CMSetter("@property(nonatomic, copy) NSDictionary *userInfo;")
    public void setUserInfo(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }

}
