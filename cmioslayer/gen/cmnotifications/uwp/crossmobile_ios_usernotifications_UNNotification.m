// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotification implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_usernotifications_UNNotification.h"
#import "crossmobile_ios_usernotifications_UNNotificationRequest.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotification$Ext

// (UNNotification) @property(nonatomic, readonly, copy) NSDate *date;
- (NSDate*) date__
{
    NSDate* re$ult = [super date];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (UNNotification) @property(nonatomic, readonly, copy) UNNotificationRequest *request;
- (UNNotificationRequest*) request__
{
    UNNotificationRequest* re$ult = [super request];
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

@implementation UNNotification (cm_crossmobile_ios_usernotifications_UNNotification)

// direct binding of: @property(nonatomic, readonly, copy) NSDate *date;
- (NSDate*) date__
{
    NSDate* re$ult = [self date];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly, copy) UNNotificationRequest *request;
- (UNNotificationRequest*) request__
{
    UNNotificationRequest* re$ult = [self request];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
