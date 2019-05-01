// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIMutableUserNotificationAction implementation

#import "crossmobile_ios_uikit_UIMutableUserNotificationAction.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UIMutableUserNotificationAction$Ext

// (UIMutableUserNotificationAction) @property(nonatomic, assign) UIUserNotificationActivationMode activationMode;
- (void) setActivationMode___int:(int) activationMode 
{
    [super setActivationMode:activationMode];
}

// (UIUserNotificationAction) @property(nonatomic, assign, readonly) UIUserNotificationActivationMode activationMode;
- (int) activationMode__
{
    return [super activationMode];
}

// (UIMutableUserNotificationAction) @property(nonatomic, assign, getter=isAuthenticationRequired) BOOL authenticationRequired;
- (void) setAuthenticationRequired___boolean:(BOOL) authenticationRequired 
{
    [super setAuthenticationRequired:authenticationRequired];
}

// (UIUserNotificationAction) @property(nonatomic, assign, readonly, getter=isAuthenticationRequired) BOOL authenticationRequired;
- (BOOL) isAuthenticationRequired__
{
    return [super isAuthenticationRequired];
}

// (UIMutableUserNotificationAction) @property(nonatomic, assign) UIUserNotificationActionBehavior behavior;
- (void) setBehavior___int:(int) behavior 
{
    [super setBehavior:behavior];
}

// (UIUserNotificationAction) @property(nonatomic, assign, readonly) UIUserNotificationActionBehavior behavior;
- (int) behavior__
{
    return [super behavior];
}

// (UIMutableUserNotificationAction) @property(nonatomic, assign, getter=isDestructive) BOOL destructive;
- (void) setDestructive___boolean:(BOOL) destructive 
{
    [super setDestructive:destructive];
}

// (UIUserNotificationAction) @property(nonatomic, assign, readonly, getter=isDestructive) BOOL destructive;
- (BOOL) isDestructive__
{
    return [super isDestructive];
}

// (UIMutableUserNotificationAction) @property(nonatomic, copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [super setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// (UIUserNotificationAction) @property(nonatomic, copy, readonly) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIMutableUserNotificationAction) @property(nonatomic, copy) NSDictionary *parameters;
- (void) setParameters___java_util_Map:(NSDictionary*) parameters 
{
    [super setParameters:(parameters == JAVA_NULL ? nil : parameters)];
}

// (UIUserNotificationAction) @property(nonatomic, copy, readonly) NSDictionary *parameters;
- (NSDictionary*) parameters__
{
    NSDictionary* re$ult = [super parameters];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UIMutableUserNotificationAction) @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [super setTitle:(title == JAVA_NULL ? nil : title)];
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

@implementation UIMutableUserNotificationAction (cm_crossmobile_ios_uikit_UIMutableUserNotificationAction)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIMutableUserNotificationAction__
{
    return [self init];
}

// direct binding of: @property(nonatomic, assign) UIUserNotificationActivationMode activationMode;
- (void) setActivationMode___int:(int) activationMode 
{
    [self setActivationMode:activationMode];
}

// direct binding of: @property(nonatomic, assign, getter=isAuthenticationRequired) BOOL authenticationRequired;
- (void) setAuthenticationRequired___boolean:(BOOL) authenticationRequired 
{
    [self setAuthenticationRequired:authenticationRequired];
}

// direct binding of: @property(nonatomic, assign) UIUserNotificationActionBehavior behavior;
- (void) setBehavior___int:(int) behavior 
{
    [self setBehavior:behavior];
}

// direct binding of: @property(nonatomic, assign, getter=isDestructive) BOOL destructive;
- (void) setDestructive___boolean:(BOOL) destructive 
{
    [self setDestructive:destructive];
}

// direct binding of: @property(nonatomic, copy) NSString *identifier;
- (void) setIdentifier___java_lang_String:(NSString*) identifier 
{
    [self setIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
}

// direct binding of: @property(nonatomic, copy) NSDictionary *parameters;
- (void) setParameters___java_util_Map:(NSDictionary*) parameters 
{
    [self setParameters:(parameters == JAVA_NULL ? nil : parameters)];
}

// direct binding of: @property(nonatomic, copy) NSString *title;
- (void) setTitle___java_lang_String:(NSString*) title 
{
    [self setTitle:(title == JAVA_NULL ? nil : title)];
}

@end
