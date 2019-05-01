// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSNotificationCenter implementation

#import "crossmobile_ios_foundation_NSNotification.h"
#import "crossmobile_ios_foundation_NSNotificationCenter.h"
#import "crossmobile_ios_foundation_NSSelector.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_lang_reflect_Method.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSNotificationCenter$Ext

// (NSNotificationCenter) - (void)addObserver:(id)observer selector:(SEL)aSelector name:(NSNotificationName)aName object:(id)anObject;
- (void) addObserver___crossmobile_ios_foundation_NSSelector_java_lang_String_java_lang_Object:(id<crossmobile_ios_foundation_NSSelector>) observer :(NSString*) aName :(id) anObject 
{
    [super addObserver:(observer == JAVA_NULL ? nil : observer) selector:@selector(exec___java_lang_Object:) name:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject)];
}

// (NSNotificationCenter) - (void)postNotification:(NSNotification *)notification;
- (void) postNotification___crossmobile_ios_foundation_NSNotification:(NSNotification*) notification 
{
    [super postNotification:(notification == JAVA_NULL ? nil : notification)];
}

// (NSNotificationCenter) - (void)postNotificationName:(NSNotificationName)aName object:(id)anObject;
- (void) postNotificationName___java_lang_String_java_lang_Object:(NSString*) aName :(id) anObject 
{
    [super postNotificationName:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject)];
}

// (NSNotificationCenter) - (void)postNotificationName:(NSNotificationName)aName object:(id)anObject userInfo:(NSDictionary *)aUserInfo;
- (void) postNotificationName___java_lang_String_java_lang_Object_java_util_Map:(NSString*) aName :(id) anObject :(NSDictionary*) aUserInfo 
{
    [super postNotificationName:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject) userInfo:(aUserInfo == JAVA_NULL ? nil : aUserInfo)];
}

// (NSNotificationCenter) - (void)removeObserver:(id)observer;
- (void) removeObserver___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) observer 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer)];
}

// (NSNotificationCenter) - (void)removeObserver:(id)observer name:(NSNotificationName)aName object:(id)anObject;
- (void) removeObserver___crossmobile_ios_foundation_NSSelector_java_lang_String_java_lang_Object:(id<crossmobile_ios_foundation_NSSelector>) observer :(NSString*) aName :(id) anObject 
{
    [super removeObserver:(observer == JAVA_NULL ? nil : observer) name:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject)];
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

@implementation NSNotificationCenter (cm_crossmobile_ios_foundation_NSNotificationCenter)

// direct binding of: + (NSNotificationCenter *) defaultCenter;
+ (NSNotificationCenter*) defaultCenter__
{
    NSNotificationCenter* re$ult = [NSNotificationCenter defaultCenter];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)addObserver:(id)observer selector:(SEL)aSelector name:(NSNotificationName)aName object:(id)anObject;
- (void) addObserver___crossmobile_ios_foundation_NSSelector_java_lang_String_java_lang_Object:(id<crossmobile_ios_foundation_NSSelector>) observer :(NSString*) aName :(id) anObject 
{
    [self addObserver:(observer == JAVA_NULL ? nil : observer) selector:@selector(exec___java_lang_Object:) name:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject)];
}

// direct binding of: - (void)postNotification:(NSNotification *)notification;
- (void) postNotification___crossmobile_ios_foundation_NSNotification:(NSNotification*) notification 
{
    [self postNotification:(notification == JAVA_NULL ? nil : notification)];
}

// direct binding of: - (void)postNotificationName:(NSNotificationName)aName object:(id)anObject;
- (void) postNotificationName___java_lang_String_java_lang_Object:(NSString*) aName :(id) anObject 
{
    [self postNotificationName:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject)];
}

// direct binding of: - (void)postNotificationName:(NSNotificationName)aName object:(id)anObject userInfo:(NSDictionary *)aUserInfo;
- (void) postNotificationName___java_lang_String_java_lang_Object_java_util_Map:(NSString*) aName :(id) anObject :(NSDictionary*) aUserInfo 
{
    [self postNotificationName:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject) userInfo:(aUserInfo == JAVA_NULL ? nil : aUserInfo)];
}

// direct binding of: - (void)removeObserver:(id)observer;
- (void) removeObserver___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) observer 
{
    [self removeObserver:(observer == JAVA_NULL ? nil : observer)];
}

// direct binding of: - (void)removeObserver:(id)observer name:(NSNotificationName)aName object:(id)anObject;
- (void) removeObserver___crossmobile_ios_foundation_NSSelector_java_lang_String_java_lang_Object:(id<crossmobile_ios_foundation_NSSelector>) observer :(NSString*) aName :(id) anObject 
{
    [self removeObserver:(observer == JAVA_NULL ? nil : observer) name:(aName == JAVA_NULL ? nil : aName) object:(anObject == JAVA_NULL ? nil : anObject)];
}

@end
