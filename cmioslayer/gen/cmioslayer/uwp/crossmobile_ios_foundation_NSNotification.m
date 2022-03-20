// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSNotification implementation

#import "crossmobile_ios_foundation_NSNotification.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSNotification$Ext

@end

@implementation NSNotification (cm_crossmobile_ios_foundation_NSNotification)

// + (instancetype)notificationWithName:(NSNotificationName)aName object:(id)anObject;
+ (instancetype) notificationWithName___java_lang_String_java_lang_Object:(NSString*) aName :(id) anObject 
{
    id re$ult = [NSNotification notificationWithName:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (instancetype)notificationWithName:(NSNotificationName)aName object:(id)anObject userInfo:(NSDictionary *)aUserInfo;
+ (instancetype) notificationWithName___java_lang_String_java_lang_Object_java_util_Map:(NSString*) aName :(id) anObject :(NSDictionary*) aUserInfo 
{
    id re$ult = [NSNotification notificationWithName:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject) userInfo:(aUserInfo == JAVA_NULL ? nil : aUserInfo)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (instancetype)initWithName:(NSNotificationName)name object:(id)object userInfo:(NSDictionary *)userInfo;
- (instancetype) __init_crossmobile_ios_foundation_NSNotification___java_lang_String_java_lang_Object_java_util_Map:(NSString*) name :(id) object :(NSDictionary*) userInfo 
{
    return [self initWithName:(name == JAVA_NULL ? nil : name) object:(object == JAVA_NULL ? nil : object) userInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

// @property(readonly, copy) NSNotificationName name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, retain) id object;
- (id) object__
{
    id re$ult = [self object];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
