// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSNotification implementation

#import "crossmobile_ios_foundation_NSNotification.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSNotification$Ext

// (NSNotification) @property(readonly, copy) NSNotificationName name;
- (NSString*) name__
{
    NSString* re$ult = [super name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSNotification) @property(readonly, retain) id object;
- (id) object__
{
    id re$ult = [super object];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// (NSNotification) @property(readonly, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [super userInfo];
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

@implementation NSNotification (cm_crossmobile_ios_foundation_NSNotification)

// direct binding of: + (instancetype)notificationWithName:(NSNotificationName)aName object:(id)anObject;
+ (instancetype) notificationWithName___java_lang_String_java_lang_Object:(NSString*) aName :(id) anObject 
{
    id re$ult = [NSNotification notificationWithName:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (instancetype)notificationWithName:(NSNotificationName)aName object:(id)anObject userInfo:(NSDictionary *)aUserInfo;
+ (instancetype) notificationWithName___java_lang_String_java_lang_Object_java_util_Map:(NSString*) aName :(id) anObject :(NSDictionary*) aUserInfo 
{
    id re$ult = [NSNotification notificationWithName:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject) userInfo:(aUserInfo == JAVA_NULL ? nil : aUserInfo)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (instancetype)initWithName:(NSNotificationName)name object:(id)object userInfo:(NSDictionary *)userInfo;
- (instancetype) __init_crossmobile_ios_foundation_NSNotification___java_lang_String_java_lang_Object_java_util_Map:(NSString*) name :(id) object :(NSDictionary*) userInfo 
{
    return [self initWithName:(name == JAVA_NULL ? nil : name) object:(object == JAVA_NULL ? nil : object) userInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

// direct binding of: @property(readonly, copy) NSNotificationName name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, retain) id object;
- (id) object__
{
    id re$ult = [self object];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
