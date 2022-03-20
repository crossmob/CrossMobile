// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNUserNotificationCenter definition

#import "xmlvm.h"
#import <UIKit/UIKit.h>
#import <UserNotifications/UserNotifications.h>
@class crossmobile_ios_foundation_NSError;
@class crossmobile_ios_usernotifications_UNNotificationRequest;
@class crossmobile_ios_usernotifications_UNNotificationSettings;
@protocol crossmobile_ios_usernotifications_UNUserNotificationCenterDelegate;
@class java_lang_Boolean;
@protocol java_util_List;
@protocol java_util_Set;
@protocol org_robovm_objc_block_VoidBlock1;
@protocol org_robovm_objc_block_VoidBlock2;

CM_EXPORT_CLASS
@interface crossmobile_ios_usernotifications_UNUserNotificationCenter$Ext : UNUserNotificationCenter
@end

#define crossmobile_ios_usernotifications_UNUserNotificationCenter UNUserNotificationCenter
@interface UNUserNotificationCenter (cm_crossmobile_ios_usernotifications_UNUserNotificationCenter)
+ (UNUserNotificationCenter*) currentNotificationCenter__;
- (void) setDelegate___crossmobile_ios_usernotifications_UNUserNotificationCenterDelegate:(id<UNUserNotificationCenterDelegate>) delegate ;
- (id<UNUserNotificationCenterDelegate>) delegate__;
- (BOOL) supportsContentExtensions__;
- (void) addNotificationRequest___crossmobile_ios_usernotifications_UNNotificationRequest_org_robovm_objc_block_VoidBlock1:(UNNotificationRequest*) request :(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
- (void) getDeliveredNotificationsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
- (void) getNotificationCategoriesWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
- (void) getNotificationSettingsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
- (void) getPendingNotificationRequestsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler ;
- (void) removeAllDeliveredNotifications__;
- (void) removeAllPendingNotificationRequests__;
- (void) removeDeliveredNotificationsWithIdentifiers___java_util_List:(NSArray*) identifiers ;
- (void) removePendingNotificationRequestsWithIdentifiers___java_util_List:(NSArray*) identifiers ;
- (void) requestAuthorizationWithOptions___int_org_robovm_objc_block_VoidBlock2:(int) options :(id<org_robovm_objc_block_VoidBlock2>) completionHandler ;
- (void) setNotificationCategories___java_util_Set:(NSSet*) categories ;
@end
