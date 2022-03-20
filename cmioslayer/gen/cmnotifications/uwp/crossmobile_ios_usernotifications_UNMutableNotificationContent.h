// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNMutableNotificationContent definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_usernotifications_UNNotificationSound;
@class java_lang_Number;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

@interface crossmobile_ios_usernotifications_UNMutableNotificationContent$Ext : UNMutableNotificationContent
@end

#define crossmobile_ios_usernotifications_UNMutableNotificationContent UNMutableNotificationContent
@interface UNMutableNotificationContent (cm_crossmobile_ios_usernotifications_UNMutableNotificationContent)
- (instancetype) __init_crossmobile_ios_usernotifications_UNMutableNotificationContent__;
- (void) setAttachments___java_util_List:(NSArray*) attachments ;
- (void) setBadge___java_lang_Number:(java_lang_Number*) badge ;
- (void) setBody___java_lang_String:(NSString*) body ;
- (void) setCategoryIdentifier___java_lang_String:(NSString*) categoryIdentifier ;
- (void) setLaunchImageName___java_lang_String:(NSString*) launchImageName ;
- (void) setSound___crossmobile_ios_usernotifications_UNNotificationSound:(UNNotificationSound*) sound ;
- (void) setSubtitle___java_lang_String:(NSString*) subtitle ;
- (void) setThreadIdentifier___java_lang_String:(NSString*) threadIdentifier ;
- (void) setTitle___java_lang_String:(NSString*) title ;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo ;
@end
