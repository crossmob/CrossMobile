// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIUserNotificationAction implementation

#import "crossmobile_ios_uikit_UIUserNotificationAction.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UIUserNotificationAction$Ext

@end

@implementation UIUserNotificationAction (cm_crossmobile_ios_uikit_UIUserNotificationAction)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIUserNotificationAction__
{
    return [self init];
}

// @property(nonatomic, assign, readonly) UIUserNotificationActivationMode activationMode;
- (int) activationMode__
{
    return [self activationMode];
}

// @property(nonatomic, assign, readonly, getter=isAuthenticationRequired) BOOL authenticationRequired;
- (BOOL) isAuthenticationRequired__
{
    return [self isAuthenticationRequired];
}

// @property(nonatomic, assign, readonly) UIUserNotificationActionBehavior behavior;
- (int) behavior__
{
    return [self behavior];
}

// @property(nonatomic, assign, readonly, getter=isDestructive) BOOL destructive;
- (BOOL) isDestructive__
{
    return [self isDestructive];
}

// @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy, readonly) NSDictionary *parameters;
- (NSDictionary*) parameters__
{
    NSDictionary* re$ult = [self parameters];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, copy, readonly) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
