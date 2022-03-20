// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLCache implementation

#import "crossmobile_ios_foundation_NSURLCache.h"
#import "crossmobile_ios_foundation_NSURLRequest.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURLCache$Ext

@end

@implementation NSURLCache (cm_crossmobile_ios_foundation_NSURLCache)

// - (instancetype)initWithMemoryCapacity:(NSUInteger)memoryCapacity diskCapacity:(NSUInteger)diskCapacity diskPath:(NSString *)path;
- (instancetype) __init_crossmobile_ios_foundation_NSURLCache___int_int_java_lang_String:(int) memoryCapacity :(int) diskCapacity :(NSString*) path 
{
    return [self initWithMemoryCapacity:memoryCapacity diskCapacity:diskCapacity diskPath:(path == JAVA_NULL ? nil : path)];
}

// @property(readonly) NSUInteger currentDiskUsage;
- (int) currentDiskUsage__
{
    return [self currentDiskUsage];
}

// @property(readonly) NSUInteger currentMemoryUsage;
- (int) currentMemoryUsage__
{
    return [self currentMemoryUsage];
}

// @property NSUInteger diskCapacity;
- (void) setDiskCapacity___int:(int) diskCapacity 
{
    [self setDiskCapacity:diskCapacity];
}

// @property NSUInteger diskCapacity;
- (int) diskCapacity__
{
    return [self diskCapacity];
}

// @property NSUInteger memoryCapacity;
- (void) setMemoryCapacity___int:(int) memoryCapacity 
{
    [self setMemoryCapacity:memoryCapacity];
}

// @property NSUInteger memoryCapacity;
- (int) memoryCapacity__
{
    return [self memoryCapacity];
}

// - (void)removeAllCachedResponses;
- (void) removeAllCachedResponses__
{
    [self removeAllCachedResponses];
}

// - (void)removeCachedResponseForRequest:(NSURLRequest *)request;
- (void) removeCachedResponseForRequest___crossmobile_ios_foundation_NSURLRequest:(NSURLRequest*) request 
{
    [self removeCachedResponseForRequest:(request == JAVA_NULL ? nil : request)];
}

@end
