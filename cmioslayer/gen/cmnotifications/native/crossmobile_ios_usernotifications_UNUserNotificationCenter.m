// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_usernotifications_UNUserNotificationCenter implementation

#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_usernotifications_UNNotificationRequest.h"
#import "crossmobile_ios_usernotifications_UNNotificationSettings.h"
#import "crossmobile_ios_usernotifications_UNUserNotificationCenter.h"
#import "crossmobile_ios_usernotifications_UNUserNotificationCenterDelegate.h"
#import "java_lang_Boolean.h"
#import "java_util_List.h"
#import "java_util_Set.h"
#import "org_robovm_objc_block_VoidBlock1.h"
#import "org_robovm_objc_block_VoidBlock2.h"

@implementation crossmobile_ios_usernotifications_UNUserNotificationCenter$Ext

@end

@implementation UNUserNotificationCenter (cm_crossmobile_ios_usernotifications_UNUserNotificationCenter)

// +(UNUserNotificationCenter *)currentNotificationCenter;
+ (UNUserNotificationCenter*) currentNotificationCenter__
{
    UNUserNotificationCenter* re$ult = [UNUserNotificationCenter currentNotificationCenter];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(weak, nonatomic) id<UNUserNotificationCenterDelegate> delegate;
- (void) setDelegate___crossmobile_ios_usernotifications_UNUserNotificationCenterDelegate:(id<UNUserNotificationCenterDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// @property(weak, nonatomic) id<UNUserNotificationCenterDelegate> delegate;
- (id<UNUserNotificationCenterDelegate>) delegate__
{
    id<UNUserNotificationCenterDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, nonatomic) BOOL supportsContentExtensions;
- (BOOL) supportsContentExtensions__
{
    return [self supportsContentExtensions];
}

// - (void)addNotificationRequest:(UNNotificationRequest *)request withCompletionHandler:(void (^)(NSError *error))completionHandler;
- (void) addNotificationRequest___crossmobile_ios_usernotifications_UNNotificationRequest_org_robovm_objc_block_VoidBlock1:(UNNotificationRequest*) request :(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self addNotificationRequest:(request == JAVA_NULL ? nil : request) withCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(NSError* error) {
        [completionHandler invoke___java_lang_Object:(error ? error : JAVA_NULL)];
    })];
}

// - (void)getDeliveredNotificationsWithCompletionHandler:(void (^)(NSArray<UNNotification *> * notifications))completionHandler;
- (void) getDeliveredNotificationsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self getDeliveredNotificationsWithCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(NSArray<UNNotification*>* notifications) {
        [completionHandler invoke___java_lang_Object:(notifications ? notifications : JAVA_NULL)];
    })];
}

// - (void)getNotificationCategoriesWithCompletionHandler:(void (^)(NSSet<UNNotificationCategory *> *categories))completionHandler;
- (void) getNotificationCategoriesWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self getNotificationCategoriesWithCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(NSSet<UNNotificationCategory*>* categories) {
        [completionHandler invoke___java_lang_Object:(categories ? categories : JAVA_NULL)];
    })];
}

// - (void)getNotificationSettingsWithCompletionHandler:(void (^)(UNNotificationSettings *settings))completionHandler;
- (void) getNotificationSettingsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self getNotificationSettingsWithCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(UNNotificationSettings* settings) {
        [completionHandler invoke___java_lang_Object:(settings ? settings : JAVA_NULL)];
    })];
}

// - (void)getPendingNotificationRequestsWithCompletionHandler:(void (^)(NSArray<UNNotificationRequest *> *requests))completionHandler;
- (void) getPendingNotificationRequestsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self getPendingNotificationRequestsWithCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(NSArray<UNNotificationRequest*>* requests) {
        [completionHandler invoke___java_lang_Object:(requests ? requests : JAVA_NULL)];
    })];
}

// - (void)removeAllDeliveredNotifications;
- (void) removeAllDeliveredNotifications__
{
    [self removeAllDeliveredNotifications];
}

// - (void)removeAllPendingNotificationRequests;
- (void) removeAllPendingNotificationRequests__
{
    [self removeAllPendingNotificationRequests];
}

// - (void)removeDeliveredNotificationsWithIdentifiers:(NSArray<NSString *> *)identifiers;
- (void) removeDeliveredNotificationsWithIdentifiers___java_util_List:(NSArray*) identifiers 
{
    [self removeDeliveredNotificationsWithIdentifiers:(identifiers == JAVA_NULL ? nil : identifiers)];
}

// - (void)removePendingNotificationRequestsWithIdentifiers:(NSArray<NSString *> *)identifiers;
- (void) removePendingNotificationRequestsWithIdentifiers___java_util_List:(NSArray*) identifiers 
{
    [self removePendingNotificationRequestsWithIdentifiers:(identifiers == JAVA_NULL ? nil : identifiers)];
}

// - (void)requestAuthorizationWithOptions:(UNAuthorizationOptions)options completionHandler:(void(^)(BOOL granted, NSError *error))completionHandler;
- (void) requestAuthorizationWithOptions___int_org_robovm_objc_block_VoidBlock2:(int) options :(id<org_robovm_objc_block_VoidBlock2>) completionHandler 
{
    [self requestAuthorizationWithOptions:options completionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL granted, NSError* error) {
        java_lang_Boolean* granted$conv = [[java_lang_Boolean alloc] initWithBool:granted];
        [completionHandler invoke___java_lang_Object_java_lang_Object:granted$conv :(error ? error : JAVA_NULL)];
        [granted$conv release];
    })];
}

// - (void)setNotificationCategories:(NSSet<UNNotificationCategory *> *)categories;
- (void) setNotificationCategories___java_util_Set:(NSSet*) categories 
{
    [self setNotificationCategories:(categories == JAVA_NULL ? nil : categories)];
}

@end
