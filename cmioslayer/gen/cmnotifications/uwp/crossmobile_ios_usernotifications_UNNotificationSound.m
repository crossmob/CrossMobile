// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.usernotifications.UNNotificationSound implementation

#import "crossmobile_ios_usernotifications_UNNotificationSound.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_usernotifications_UNNotificationSound$Ext

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

@implementation UNNotificationSound (cm_crossmobile_ios_usernotifications_UNNotificationSound)

// direct binding of: + (instancetype)defaultSound;
+ (instancetype) defaultSound__
{
    id re$ult = [UNNotificationSound defaultSound];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)soundNamed:(NSString *)name;
+ (instancetype) soundNamed___java_lang_String:(NSString*) name 
{
    id re$ult = [UNNotificationSound soundNamed:(name == JAVA_NULL ? nil : name)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
