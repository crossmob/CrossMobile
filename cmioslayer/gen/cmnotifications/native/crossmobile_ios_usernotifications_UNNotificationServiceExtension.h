// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNNotificationServiceExtension definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_usernotifications_UNNotificationContent;
@class crossmobile_ios_usernotifications_UNNotificationRequest;
@protocol org_robovm_objc_block_VoidBlock1;

@interface crossmobile_ios_usernotifications_UNNotificationServiceExtension$Ext : UNNotificationServiceExtension
@end

#define crossmobile_ios_usernotifications_UNNotificationServiceExtension UNNotificationServiceExtension
@interface UNNotificationServiceExtension (cm_crossmobile_ios_usernotifications_UNNotificationServiceExtension)
- (instancetype) __init_crossmobile_ios_usernotifications_UNNotificationServiceExtension__;
- (void) didReceiveNotificationRequest___crossmobile_ios_usernotifications_UNNotificationRequest_org_robovm_objc_block_VoidBlock1:(UNNotificationRequest*) request :(id<org_robovm_objc_block_VoidBlock1>) contentHandler ;
- (void) serviceExtensionTimeWillExpire__;
@end
