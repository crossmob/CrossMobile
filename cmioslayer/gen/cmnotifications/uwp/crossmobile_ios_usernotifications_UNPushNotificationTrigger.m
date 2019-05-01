// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNPushNotificationTrigger implementation

#import "crossmobile_ios_usernotifications_UNPushNotificationTrigger.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNPushNotificationTrigger$Ext

// (UNNotificationTrigger) @property(readonly, nonatomic) BOOL repeats;
- (BOOL) repeats__
{
    return [super repeats];
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

@implementation UNPushNotificationTrigger (cm_crossmobile_ios_usernotifications_UNPushNotificationTrigger)

@end
