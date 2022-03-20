/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.usernotifications;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.List;
import java.util.Map;

@CMClass
public class UNMutableNotificationContent extends UNNotificationContent {

    private String title;
    private String subtitle;
    private String body;
    private Number badge;
    private UNNotificationSound sound;
    private String launchImageName;
    private Map<String, Object> userInfo;
    private List<UNNotificationAttachment> attachments;
    private String categoryIdentifier;
    private String threadIdentifier;

    @CMSetter("@property(copy, nonatomic) NSString *title;")
    public void setTitle(String title) {
        this.title = title;
    }

    @CMGetter("@property(copy, nonatomic) NSString *title;")
    public String title() {
        return title;
    }

    @CMSetter("@property(copy, nonatomic) NSString *subtitle;")
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    @CMGetter("@property(copy, nonatomic) NSString *subtitle;")
    public String subtitle() {
        return subtitle;
    }

    @CMSetter("@property(copy, nonatomic) NSString *body;")
    public void setBody(String body) {
        this.body = body;
    }

    @CMGetter("@property(copy, nonatomic) NSString *body;")
    public String body() {
        return body;
    }

    @CMSetter("@property(copy, nonatomic) NSNumber *badge;")
    public void setBadge(Number badge) {
        this.badge = badge;
    }

    @CMGetter("@property(copy, nonatomic) NSNumber *badge;")
    public Number badge() {
        return badge;
    }

    @CMSetter("@property(copy, nonatomic) UNNotificationSound *sound;")
    public void setSound(UNNotificationSound sound) {
        this.sound = sound;
    }

    @CMGetter("@property(copy, nonatomic) UNNotificationSound *sound;")
    public UNNotificationSound sound() {
        return sound;
    }

    @CMSetter("@property(copy, nonatomic) NSString *launchImageName;")
    public void setLaunchImageName(String launchImageName) {
        this.launchImageName = launchImageName;
    }

    @CMGetter("@property(copy, nonatomic) NSString *launchImageName;")
    public String launchImageName() {
        return launchImageName;
    }

    @CMSetter("@property(copy, nonatomic) NSDictionary *userInfo;")
    public void setUserInfo(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }

    @CMGetter("@property(copy, nonatomic) NSDictionary *userInfo;")
    public Map<String, Object> userInfo() {
        return userInfo;
    }

    @CMSetter("@property(copy, nonatomic) NSArray<UNNotificationAttachment *> *attachments;")
    public void setAttachments(List<UNNotificationAttachment> attachments) {
        this.attachments = attachments;
    }

    @CMGetter("@property(copy, nonatomic) NSArray<UNNotificationAttachment *> *attachments;")
    public List<UNNotificationAttachment> attachments() {
        return attachments;
    }

    @CMSetter("@property(copy, nonatomic) NSString *categoryIdentifier;")
    public void setCategoryIdentifier(String categoryIdentifier) {
        this.categoryIdentifier = categoryIdentifier;
    }

    @CMGetter("@property(copy, nonatomic) NSString *categoryIdentifier;")
    public String categoryIdentifier() {
        return categoryIdentifier;
    }

    @CMSetter("@property(copy, nonatomic) NSString *threadIdentifier;")
    public void setThreadIdentifier(String threadIdentifier) {
        this.threadIdentifier = threadIdentifier;
    }

    @CMGetter("@property(copy, nonatomic) NSString *threadIdentifier;")
    public String threadIdentifier() {
        return threadIdentifier;
    }

}
