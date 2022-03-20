// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNMutableNotificationContent implementation

#import "crossmobile_ios_usernotifications_UNMutableNotificationContent.h"
#import "crossmobile_ios_usernotifications_UNNotificationSound.h"
#import "java_lang_Number.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_usernotifications_UNMutableNotificationContent$Ext

@end

@implementation UNMutableNotificationContent (cm_crossmobile_ios_usernotifications_UNMutableNotificationContent)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_usernotifications_UNMutableNotificationContent__
{
    return [self init];
}

// @property(copy, nonatomic) NSArray<UNNotificationAttachment *> *attachments;
- (void) setAttachments___java_util_List:(NSArray*) attachments 
{
    [self setAttachments:(attachments == JAVA_NULL ? nil : attachments)];
}

// @property(copy, nonatomic) NSNumber *badge;
- (void) setBadge___java_lang_Number:(java_lang_Number*) badge 
{
    [self setBadge:(badge == JAVA_NULL ? nil : badge)];
}

// @property(copy, nonatomic) NSString *body;
- (void) setBody___java_lang_String:(NSString*) body 
{
    [self setBody:(body == JAVA_NULL ? nil : body)];
}

// @property(copy, nonatomic) NSString *categoryIdentifier;
- (void) setCategoryIdentifier___java_lang_String:(NSString*) categoryIdentifier 
{
    [self setCategoryIdentifier:(categoryIdentifier == JAVA_NULL ? nil : categoryIdentifier)];
}

// @property(copy, nonatomic) NSString *launchImageName;
- (void) setLaunchImageName___java_lang_String:(NSString*) launchImageName 
{
    [self setLaunchImageName:(launchImageName == JAVA_NULL ? nil : launchImageName)];
}

// @property(copy, nonatomic) UNNotificationSound *sound;
- (void) setSound___crossmobile_ios_usernotifications_UNNotificationSound:(UNNotificationSound*) sound 
{
    [self setSound:(sound == JAVA_NULL ? nil : sound)];
}

// @property(copy, nonatomic) NSString *subtitle;
- (void) setSubtitle___java_lang_String:(NSString*) subtitle 
{
    [self setSubtitle:(subtitle == JAVA_NULL ? nil : subtitle)];
}

// @property(copy, nonatomic) NSString *threadIdentifier;
- (void) setThreadIdentifier___java_lang_String:(NSString*) threadIdentifier 
{
    [self setThreadIdentifier:(threadIdentifier == JAVA_NULL ? nil : threadIdentifier)];
}

// @property(copy, nonatomic) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

// @property(copy, nonatomic) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [self setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

@end
