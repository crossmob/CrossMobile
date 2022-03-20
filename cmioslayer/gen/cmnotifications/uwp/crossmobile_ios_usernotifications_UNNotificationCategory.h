// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationCategory definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class java_lang_String;
@protocol java_util_List;

@interface crossmobile_ios_usernotifications_UNNotificationCategory$Ext : UNNotificationCategory
@end

#define crossmobile_ios_usernotifications_UNNotificationCategory UNNotificationCategory
@interface UNNotificationCategory (cm_crossmobile_ios_usernotifications_UNNotificationCategory)
+ (instancetype) categoryWithIdentifier___java_lang_String_java_util_List_java_util_List_long:(NSString*) identifier :(NSArray*) actions :(NSArray*) intentIdentifiers :(JAVA_LONG) options ;
- (NSArray*) actions__;
- (NSString*) identifier__;
- (NSArray*) intentIdentifiers__;
- (JAVA_LONG) options__;
@end
