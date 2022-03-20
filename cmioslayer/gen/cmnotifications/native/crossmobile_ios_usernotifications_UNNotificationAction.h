// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationAction definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class java_lang_String;

@interface crossmobile_ios_usernotifications_UNNotificationAction$Ext : UNNotificationAction
@end

#define crossmobile_ios_usernotifications_UNNotificationAction UNNotificationAction
@interface UNNotificationAction (cm_crossmobile_ios_usernotifications_UNNotificationAction)
+ (instancetype) actionWithIdentifier___java_lang_String_java_lang_String_long:(NSString*) identifier :(NSString*) title :(JAVA_LONG) options ;
- (NSString*) identifier__;
- (JAVA_LONG) options__;
- (NSString*) title__;
@end
