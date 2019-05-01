// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSURLCache implementation

#import "crossmobile_ios_foundation_NSURLCache.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURLCache$Ext

// (NSURLCache) @property(readonly) NSUInteger currentDiskUsage;
- (int) currentDiskUsage__
{
    return [super currentDiskUsage];
}

// (NSURLCache) @property(readonly) NSUInteger currentMemoryUsage;
- (int) currentMemoryUsage__
{
    return [super currentMemoryUsage];
}

// (NSURLCache) @property NSUInteger diskCapacity;
- (void) setDiskCapacity___int:(int) diskCapacity 
{
    [super setDiskCapacity:diskCapacity];
}

// (NSURLCache) @property NSUInteger diskCapacity;
- (int) diskCapacity__
{
    return [super diskCapacity];
}

// (NSURLCache) @property NSUInteger memoryCapacity;
- (void) setMemoryCapacity___int:(int) memoryCapacity 
{
    [super setMemoryCapacity:memoryCapacity];
}

// (NSURLCache) @property NSUInteger memoryCapacity;
- (int) memoryCapacity__
{
    return [super memoryCapacity];
}

// (NSURLCache) - (void)removeAllCachedResponses;
- (void) removeAllCachedResponses__
{
    [super removeAllCachedResponses];
}

// (NSURLCache) - (void)removeCachedResponseForRequest:(NSURLRequest *)request;
- (void) removeCachedResponseForRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request 
{
    [super removeCachedResponseForRequest:(request == JAVA_NULL ? nil : request)];
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

@implementation NSURLCache (cm_crossmobile_ios_foundation_NSURLCache)

// direct binding of: - (instancetype)initWithMemoryCapacity:(NSUInteger)memoryCapacity diskCapacity:(NSUInteger)diskCapacity diskPath:(NSString *)path;
- (instancetype) __init_crossmobile_ios_foundation_NSURLCache___int_int_java_lang_String:(int) memoryCapacity :(int) diskCapacity :(NSString*) path 
{
    return [self initWithMemoryCapacity:memoryCapacity diskCapacity:diskCapacity diskPath:(path == JAVA_NULL ? nil : path)];
}

// direct binding of: @property(readonly) NSUInteger currentDiskUsage;
- (int) currentDiskUsage__
{
    return [self currentDiskUsage];
}

// direct binding of: @property(readonly) NSUInteger currentMemoryUsage;
- (int) currentMemoryUsage__
{
    return [self currentMemoryUsage];
}

// direct binding of: @property NSUInteger diskCapacity;
- (void) setDiskCapacity___int:(int) diskCapacity 
{
    [self setDiskCapacity:diskCapacity];
}

// direct binding of: @property NSUInteger diskCapacity;
- (int) diskCapacity__
{
    return [self diskCapacity];
}

// direct binding of: @property NSUInteger memoryCapacity;
- (void) setMemoryCapacity___int:(int) memoryCapacity 
{
    [self setMemoryCapacity:memoryCapacity];
}

// direct binding of: @property NSUInteger memoryCapacity;
- (int) memoryCapacity__
{
    return [self memoryCapacity];
}

// direct binding of: - (void)removeAllCachedResponses;
- (void) removeAllCachedResponses__
{
    [self removeAllCachedResponses];
}

// direct binding of: - (void)removeCachedResponseForRequest:(NSURLRequest *)request;
- (void) removeCachedResponseForRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request 
{
    [self removeCachedResponseForRequest:(request == JAVA_NULL ? nil : request)];
}

@end
