// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSObject implementation

#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_foundation_NSSelector.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSObject$Ext

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

@implementation NSObject (cm_crossmobile_ios_foundation_NSObject)

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSObject__
{
    return [self init];
}

// direct binding of: - (void)performSelector:(SEL)aSelector withObject:(id)anArgument afterDelay:(NSTimeInterval)delay;
- (void) performSelector___crossmobile_ios_foundation_NSSelector_java_lang_Object_double:(id<crossmobile_ios_foundation_NSSelector>) aSelector :(id) anArgument :(double) delay 
{
    [(aSelector == JAVA_NULL ? nil : aSelector) performSelector:@selector(exec___java_lang_Object:) withObject:(anArgument == JAVA_NULL ? nil : anArgument) afterDelay:delay];
}

// direct binding of: - (void)performSelectorOnMainThread:(SEL)aSelector withObject:(id)arg waitUntilDone:(BOOL)wait;
- (void) performSelectorOnMainThread___crossmobile_ios_foundation_NSSelector_java_lang_Object_boolean:(id<crossmobile_ios_foundation_NSSelector>) aSelector :(id) arg :(BOOL) wait 
{
    [(aSelector == JAVA_NULL ? nil : aSelector) performSelectorOnMainThread:@selector(exec___java_lang_Object:) withObject:(arg == JAVA_NULL ? nil : arg) waitUntilDone:wait];
}

// direct binding of: - (oneway void)release;
- (void) release__
{
    [self release];
}

// direct binding of: - (instancetype)retain;
- (instancetype) retain__
{
    id re$ult = [self retain];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: - (void)setValue:(id)value forKey:(NSString *)key;
- (void) setValue___java_lang_Object_java_lang_String:(id) value :(NSString*) key 
{
    [self setValue:(value == JAVA_NULL ? nil : value) forKey:(key == JAVA_NULL ? nil : key)];
}

// direct binding of: - (id)valueForKey:(NSString *)key;
- (id) valueForKey___java_lang_String:(NSString*) key 
{
    id re$ult = [self valueForKey:(key == JAVA_NULL ? nil : key)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
