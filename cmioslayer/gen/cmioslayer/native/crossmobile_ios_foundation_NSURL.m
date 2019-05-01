// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSURL implementation

#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURL$Ext

// (NSURL) @property(readonly, copy) NSString *absoluteString;
- (NSString*) absoluteString__
{
    NSString* re$ult = [super absoluteString];
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

@implementation NSURL (cm_crossmobile_ios_foundation_NSURL)

// direct binding of: + (instancetype)URLWithString:(NSString *)URLString;
+ (instancetype) URLWithString___java_lang_String:(NSString*) URLString 
{
    id re$ult = [NSURL URLWithString:(URLString == JAVA_NULL ? nil : URLString)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (NSURL *)fileURLWithPath:(NSString *)path;
+ (NSURL*) fileURLWithPath___java_lang_String:(NSString*) path 
{
    NSURL* re$ult = [NSURL fileURLWithPath:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(readonly, copy) NSString *absoluteString;
- (NSString*) absoluteString__
{
    NSString* re$ult = [self absoluteString];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
