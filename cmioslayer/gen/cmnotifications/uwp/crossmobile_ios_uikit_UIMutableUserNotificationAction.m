// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIMutableUserNotificationAction implementation

#import "crossmobile_ios_uikit_UIMutableUserNotificationAction.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UIMutableUserNotificationAction$Ext

@end

@implementation UIMutableUserNotificationAction (cm_crossmobile_ios_uikit_UIMutableUserNotificationAction)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIMutableUserNotificationAction__
{
    return [self init];
}

// @property(nonatomic, assign) UIUserNotificationActivationMode activationMode;
- (void) setActivationMode___int:(int) activationMode 
{
    [self setActivationMode:activationMode];
}

// @property(nonatomic, assign, getter=isAuthenticationRequired) BOOL authenticationRequired;
- (void) setAuthenticationRequired___boolean:(BOOL) authenticationRequired 
{
    [self setAuthenticationRequired:authenticationRequired];
}

// @property(nonatomic, assign) UIUserNotificationActionBehavior behavior;
- (void) setBehavior___int:(int) behavior 
{
    [self setBehavior:behavior];
}

// @property(nonatomic, assign, getter=isDestructive) BOOL destructive;
- (void) setDestructive___boolean:(BOOL) destructive 
{
    [self setDestructive:destructive];
}

// @property(nonatomic, copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [self setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// @property(nonatomic, copy) NSDictionary *parameters;
- (void) setParameters___java_util_Map:(NSDictionary*) parameters 
{
    [self setParameters:(parameters == JAVA_NULL ? nil : parameters)];
}

// @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

@end
