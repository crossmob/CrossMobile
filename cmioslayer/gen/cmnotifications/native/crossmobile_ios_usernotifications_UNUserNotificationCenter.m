// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNUserNotificationCenter implementation

#import "crossmobile_ios_foundation_NSError.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_usernotifications_UNNotificationRequest.h"
#import "crossmobile_ios_usernotifications_UNNotificationSettings.h"
#import "crossmobile_ios_usernotifications_UNUserNotificationCenter.h"
#import "crossmobile_ios_usernotifications_UNUserNotificationCenterDelegate.h"
#import "java_lang_Boolean.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"
#import "java_util_Set.h"
#import "org_robovm_objc_block_VoidBlock1.h"
#import "org_robovm_objc_block_VoidBlock2.h"

@implementation crossmobile_ios_usernotifications_UNUserNotificationCenter$Ext

// (UNUserNotificationCenter) @property(weak, nonatomic) id<UNUserNotificationCenterDelegate> delegate;
- (void) setDelegate___crossmobile_ios_usernotifications_UNUserNotificationCenterDelegate:(id<UNUserNotificationCenterDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [super setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// (UNUserNotificationCenter) @property(weak, nonatomic) id<UNUserNotificationCenterDelegate> delegate;
- (id<UNUserNotificationCenterDelegate>) delegate__
{
    id<UNUserNotificationCenterDelegate> re$ult = [super delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNUserNotificationCenter) @property(readonly, nonatomic) BOOL supportsContentExtensions;
- (BOOL) supportsContentExtensions__
{
    return [super supportsContentExtensions];
}

// (NSObject) - (void)addObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath options:(NSKeyValueObservingOptions)options context:(void *)context;
- (void) addObserver___crossmobile_ios_foundation_NSObject_java_lang_String_int_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(int) options :(id) context 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) options:options context:(context == JAVA_NULL ? nil : context)];
}

// (NSObject) - (void)observeValueForKeyPath:(NSString *)keyPath ofObject:(id)object change:(NSDictionary<NSKeyValueChangeKey, id> *)change context:(void *)context;
- (void) observeValueForKeyPath___java_lang_String_java_lang_Object_java_util_Map_java_lang_Object:(NSString*) keyPath :(id) object :(NSDictionary*) change :(id) context 
{
    [super observeValueForKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) ofObject:(object == JAVA_NULL ? nil : object) change:(change == JAVA_NULL ? nil : change) context:(context == JAVA_NULL ? nil : context)];
}

// (UNUserNotificationCenter) - (void)removeAllDeliveredNotifications;
- (void) removeAllDeliveredNotifications__
{
    [super removeAllDeliveredNotifications];
}

// (UNUserNotificationCenter) - (void)removeAllPendingNotificationRequests;
- (void) removeAllPendingNotificationRequests__
{
    [super removeAllPendingNotificationRequests];
}

// (UNUserNotificationCenter) - (void)removeDeliveredNotificationsWithIdentifiers:(NSArray<NSString *> *)identifiers;
- (void) removeDeliveredNotificationsWithIdentifiers___java_util_List:(NSArray*) identifiers 
{
    [super removeDeliveredNotificationsWithIdentifiers:(identifiers == JAVA_NULL ? nil : identifiers)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String:(NSObject*) observer :(NSString*) keyPath 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath)];
}

// (NSObject) - (void)removeObserver:(NSObject *)observer forKeyPath:(NSString *)keyPath context:(void *)context;
- (void) removeObserver___crossmobile_ios_foundation_NSObject_java_lang_String_java_lang_Object:(NSObject*) observer :(NSString*) keyPath :(id) context 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) forKeyPath:(keyPath == JAVA_NULL ? nil : keyPath) context:(context == JAVA_NULL ? nil : context)];
}

// (UNUserNotificationCenter) - (void)removePendingNotificationRequestsWithIdentifiers:(NSArray<NSString *> *)identifiers;
- (void) removePendingNotificationRequestsWithIdentifiers___java_util_List:(NSArray*) identifiers 
{
    [super removePendingNotificationRequestsWithIdentifiers:(identifiers == JAVA_NULL ? nil : identifiers)];
}

// (UNUserNotificationCenter) - (void)setNotificationCategories:(NSSet<UNNotificationCategory *> *)categories;
- (void) setNotificationCategories___java_util_Set:(NSSet*) categories 
{
    [super setNotificationCategories:(categories == JAVA_NULL ? nil : categories)];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValueForKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (void)setValue:(id)value forUndefinedKey:(NSString *)key;
- (void) setValueForUndefinedKey___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forUndefinedKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (id)valueForUndefinedKey:(NSString *)key;
- (id) valueForUndefinedKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForUndefinedKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UNUserNotificationCenter (cm_crossmobile_ios_usernotifications_UNUserNotificationCenter)

// direct binding of: +(UNUserNotificationCenter *)currentNotificationCenter;
+ (UNUserNotificationCenter*) currentNotificationCenter__
{
    UNUserNotificationCenter* re$ult = [UNUserNotificationCenter currentNotificationCenter];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(weak, nonatomic) id<UNUserNotificationCenterDelegate> delegate;
- (void) setDelegate___crossmobile_ios_usernotifications_UNUserNotificationCenterDelegate:(id<UNUserNotificationCenterDelegate>) delegate 
{
    objc_setAssociatedObject(self, @selector(setDelegate:), delegate, OBJC_ASSOCIATION_RETAIN_NONATOMIC);
    [self setDelegate:(delegate == JAVA_NULL ? nil : delegate)];
}

// direct binding of: @property(weak, nonatomic) id<UNUserNotificationCenterDelegate> delegate;
- (id<UNUserNotificationCenterDelegate>) delegate__
{
    id<UNUserNotificationCenterDelegate> re$ult = [self delegate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) BOOL supportsContentExtensions;
- (BOOL) supportsContentExtensions__
{
    return [self supportsContentExtensions];
}

// direct binding of: - (void)addNotificationRequest:(UNNotificationRequest *)request withCompletionHandler:(void (^)(NSError *error))completionHandler;
- (void) addNotificationRequest___crossmobile_ios_usernotifications_UNNotificationRequest_org_robovm_objc_block_VoidBlock1:(UNNotificationRequest*) request :(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self addNotificationRequest:(request == JAVA_NULL ? nil : request) withCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(NSError* error) {
        [completionHandler invoke___java_lang_Object:(error ? error : JAVA_NULL)];
    })];
}

// direct binding of: - (void)getDeliveredNotificationsWithCompletionHandler:(void (^)(NSArray<UNNotification *> * notifications))completionHandler;
- (void) getDeliveredNotificationsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self getDeliveredNotificationsWithCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(NSArray<UNNotification*>* notifications) {
        [completionHandler invoke___java_lang_Object:(notifications ? notifications : JAVA_NULL)];
    })];
}

// direct binding of: - (void)getNotificationCategoriesWithCompletionHandler:(void (^)(NSSet<UNNotificationCategory *> *categories))completionHandler;
- (void) getNotificationCategoriesWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self getNotificationCategoriesWithCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(NSSet<UNNotificationCategory*>* categories) {
        [completionHandler invoke___java_lang_Object:(categories ? categories : JAVA_NULL)];
    })];
}

// direct binding of: - (void)getNotificationSettingsWithCompletionHandler:(void (^)(UNNotificationSettings *settings))completionHandler;
- (void) getNotificationSettingsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self getNotificationSettingsWithCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(UNNotificationSettings* settings) {
        [completionHandler invoke___java_lang_Object:(settings ? settings : JAVA_NULL)];
    })];
}

// direct binding of: - (void)getPendingNotificationRequestsWithCompletionHandler:(void (^)(NSArray<UNNotificationRequest *> *requests))completionHandler;
- (void) getPendingNotificationRequestsWithCompletionHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) completionHandler 
{
    [self getPendingNotificationRequestsWithCompletionHandler:(completionHandler == JAVA_NULL ? nil : ^(NSArray<UNNotificationRequest*>* requests) {
        [completionHandler invoke___java_lang_Object:(requests ? requests : JAVA_NULL)];
    })];
}

// direct binding of: - (void)removeAllDeliveredNotifications;
- (void) removeAllDeliveredNotifications__
{
    [self removeAllDeliveredNotifications];
}

// direct binding of: - (void)removeAllPendingNotificationRequests;
- (void) removeAllPendingNotificationRequests__
{
    [self removeAllPendingNotificationRequests];
}

// direct binding of: - (void)removeDeliveredNotificationsWithIdentifiers:(NSArray<NSString *> *)identifiers;
- (void) removeDeliveredNotificationsWithIdentifiers___java_util_List:(NSArray*) identifiers 
{
    [self removeDeliveredNotificationsWithIdentifiers:(identifiers == JAVA_NULL ? nil : identifiers)];
}

// direct binding of: - (void)removePendingNotificationRequestsWithIdentifiers:(NSArray<NSString *> *)identifiers;
- (void) removePendingNotificationRequestsWithIdentifiers___java_util_List:(NSArray*) identifiers 
{
    [self removePendingNotificationRequestsWithIdentifiers:(identifiers == JAVA_NULL ? nil : identifiers)];
}

// direct binding of: - (void)requestAuthorizationWithOptions:(UNAuthorizationOptions)options completionHandler:(void(^)(BOOL granted, NSError *error))completionHandler;
- (void) requestAuthorizationWithOptions___long_org_robovm_objc_block_VoidBlock2:(JAVA_LONG) options :(id<org_robovm_objc_block_VoidBlock2>) completionHandler 
{
    [self requestAuthorizationWithOptions:options completionHandler:(completionHandler == JAVA_NULL ? nil : ^(BOOL granted, NSError* error) {
        java_lang_Boolean* granted$conv = [[java_lang_Boolean alloc] initWithBool:granted];
        [completionHandler invoke___java_lang_Object_java_lang_Object:granted$conv :(error ? error : JAVA_NULL)];
        [granted$conv release];
    })];
}

// direct binding of: - (void)setNotificationCategories:(NSSet<UNNotificationCategory *> *)categories;
- (void) setNotificationCategories___java_util_Set:(NSSet*) categories 
{
    [self setNotificationCategories:(categories == JAVA_NULL ? nil : categories)];
}

@end
