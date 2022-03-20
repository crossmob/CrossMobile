// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationAttachment definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_foundation_NSURL;
@class crossmobile_rt_StrongReference;
@class java_lang_String;
@protocol java_util_Map;

CM_EXPORT_CLASS
@interface crossmobile_ios_usernotifications_UNNotificationAttachment$Ext : UNNotificationAttachment
@end

#define crossmobile_ios_usernotifications_UNNotificationAttachment UNNotificationAttachment
@interface UNNotificationAttachment (cm_crossmobile_ios_usernotifications_UNNotificationAttachment)
+ (instancetype) attachmentWithIdentifier___java_lang_String_crossmobile_ios_foundation_NSURL_java_util_Map_crossmobile_rt_StrongReference:(NSString*) identifier :(NSURL*) URL :(NSDictionary*) options :(crossmobile_rt_StrongReference*) error ;
- (NSURL*) URL__;
- (NSString*) identifier__;
- (NSString*) type__;
@end
