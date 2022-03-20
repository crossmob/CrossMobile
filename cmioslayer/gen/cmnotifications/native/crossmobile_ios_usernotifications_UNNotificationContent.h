// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationContent definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_usernotifications_UNNotificationSound;
@class java_lang_Number;
@class java_lang_String;
@protocol java_util_List;
@protocol java_util_Map;

@interface crossmobile_ios_usernotifications_UNNotificationContent$Ext : UNNotificationContent
@end

#define crossmobile_ios_usernotifications_UNNotificationContent UNNotificationContent
@interface UNNotificationContent (cm_crossmobile_ios_usernotifications_UNNotificationContent)
- (NSArray*) attachments__;
- (java_lang_Number*) badge__;
- (NSString*) body__;
- (NSString*) categoryIdentifier__;
- (NSString*) launchImageName__;
- (UNNotificationSound*) sound__;
- (NSString*) subtitle__;
- (NSString*) threadIdentifier__;
- (NSString*) title__;
- (NSDictionary*) userInfo__;
@end
