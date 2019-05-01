// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIUserNotificationAction implementation

#import "crossmobile_ios_uikit_UIUserNotificationAction.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UIUserNotificationAction$Ext

// (UIUserNotificationAction) @property(nonatomic, assign, readonly) UIUserNotificationActivationMode activationMode;
- (int) activationMode__
{
    return [super activationMode];
}

// (UIUserNotificationAction) @property(nonatomic, assign, readonly, getter=isAuthenticationRequired) BOOL authenticationRequired;
- (BOOL) isAuthenticationRequired__
{
    return [super isAuthenticationRequired];
}

// (UIUserNotificationAction) @property(nonatomic, assign, readonly) UIUserNotificationActionBehavior behavior;
- (int) behavior__
{
    return [super behavior];
}

// (UIUserNotificationAction) @property(nonatomic, assign, readonly, getter=isDestructive) BOOL destructive;
- (BOOL) isDestructive__
{
    return [super isDestructive];
}

// (UIUserNotificationAction) @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIUserNotificationAction) @property(nonatomic, copy, readonly) NSDictionary *parameters;
- (NSDictionary*) parameters__
{
    NSDictionary* re$ult = [super parameters];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIUserNotificationAction) @property(nonatomic, copy, readonly) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [super title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSObject) - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [super setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// (NSObject) - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [super valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end

@implementation UIUserNotificationAction (cm_crossmobile_ios_uikit_UIUserNotificationAction)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIUserNotificationAction__
{
    return [self init];
}

// direct binding of: @property(nonatomic, assign, readonly) UIUserNotificationActivationMode activationMode;
- (int) activationMode__
{
    return [self activationMode];
}

// direct binding of: @property(nonatomic, assign, readonly, getter=isAuthenticationRequired) BOOL authenticationRequired;
- (BOOL) isAuthenticationRequired__
{
    return [self isAuthenticationRequired];
}

// direct binding of: @property(nonatomic, assign, readonly) UIUserNotificationActionBehavior behavior;
- (int) behavior__
{
    return [self behavior];
}

// direct binding of: @property(nonatomic, assign, readonly, getter=isDestructive) BOOL destructive;
- (BOOL) isDestructive__
{
    return [self isDestructive];
}

// direct binding of: @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy, readonly) NSDictionary *parameters;
- (NSDictionary*) parameters__
{
    NSDictionary* re$ult = [self parameters];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, copy, readonly) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
