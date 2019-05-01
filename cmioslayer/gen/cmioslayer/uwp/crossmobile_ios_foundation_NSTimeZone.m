// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSTimeZone implementation

#import "crossmobile_ios_foundation_NSTimeZone.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSTimeZone$Ext

// (NSTimeZone) @property(readonly, copy) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [super name];
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

@implementation NSTimeZone (cm_crossmobile_ios_foundation_NSTimeZone)

// direct binding of: - (instancetype)initWithName:(NSString *)tzName;
- (instancetype) __init_crossmobile_ios_foundation_NSTimeZone___java_lang_String:(NSString*) tzName 
{
    return [self initWithName:(tzName == JAVA_NULL ? nil : tzName)];
}

// direct binding of: @property(readonly, copy) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
