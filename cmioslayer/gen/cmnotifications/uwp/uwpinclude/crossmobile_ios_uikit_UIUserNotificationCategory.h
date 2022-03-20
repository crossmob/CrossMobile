// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIUserNotificationCategory definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIUserNotificationCategory$Ext : UIUserNotificationCategory
@end

#define crossmobile_ios_uikit_UIUserNotificationCategory UIUserNotificationCategory
@interface UIUserNotificationCategory (cm_crossmobile_ios_uikit_UIUserNotificationCategory)
- (instancetype) __init_crossmobile_ios_uikit_UIUserNotificationCategory__;
- (NSString*) identifier__;
- (NSArray*) actionsForContext___int:(int) context ;
@end
