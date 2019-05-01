// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationResponse implementation

#import "crossmobile_ios_usernotifications_UNNotification.h"
#import "crossmobile_ios_usernotifications_UNNotificationResponse.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotificationResponse$Ext

// (UNNotificationResponse) @property(readonly, copy, nonatomic) NSString *actionIdentifier;
- (NSString*) actionIdentifier__
{
    NSString* re$ult = [super actionIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotificationResponse) @property(readonly, copy, nonatomic) UNNotification *notification;
- (UNNotification*) notification__
{
    UNNotification* re$ult = [super notification];
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

@implementation UNNotificationResponse (cm_crossmobile_ios_usernotifications_UNNotificationResponse)

// direct binding of: @property(readonly, copy, nonatomic) NSString *actionIdentifier;
- (NSString*) actionIdentifier__
{
    NSString* re$ult = [self actionIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy, nonatomic) UNNotification *notification;
- (UNNotification*) notification__
{
    UNNotification* re$ult = [self notification];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
