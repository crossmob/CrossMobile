// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationAction implementation

#import "crossmobile_ios_usernotifications_UNNotificationAction.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotificationAction$Ext

// (UNNotificationAction) @property(copy, readonly, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [super identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationAction) @property(readonly, nonatomic) UNNotificationActionOptions options;
- (JAVA_LONG) options__
{
    return [super options];
}

// (UNNotificationAction) @property(copy, readonly, nonatomic) NSString *title;
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

@implementation UNNotificationAction (cm_crossmobile_ios_usernotifications_UNNotificationAction)

// direct binding of: + (instancetype)actionWithIdentifier:(NSString *)identifier title:(NSString *)title options:(UNNotificationActionOptions)options;
+ (instancetype) actionWithIdentifier___java_lang_String_java_lang_String_long:(NSString*) identifier :(NSString*) title :(JAVA_LONG) options 
{
    id re$ult = [UNNotificationAction actionWithIdentifier:(identifier == JAVA_NULL ? nil : identifier) title:(title == JAVA_NULL ? nil : title) options:options];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(copy, readonly, nonatomic) NSString *identifier;
- (NSString*) identifier__
{
    NSString* re$ult = [self identifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, nonatomic) UNNotificationActionOptions options;
- (JAVA_LONG) options__
{
    return [self options];
}

// direct binding of: @property(copy, readonly, nonatomic) NSString *title;
- (NSString*) title__
{
    NSString* re$ult = [self title];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
