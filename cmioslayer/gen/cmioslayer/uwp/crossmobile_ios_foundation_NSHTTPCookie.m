// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSHTTPCookie implementation

#import "crossmobile_ios_foundation_NSDate.h"
#import "crossmobile_ios_foundation_NSHTTPCookie.h"
#import "crossmobile_ios_foundation_NSURL.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_foundation_NSHTTPCookie$Ext

@end

@implementation NSHTTPCookie (cm_crossmobile_ios_foundation_NSHTTPCookie)

// @property(readonly, getter=isHTTPOnly) BOOL HTTPOnly;
- (BOOL) isHTTPOnly__
{
    return [self isHTTPOnly];
}

// @property(readonly, copy) NSString *comment;
- (NSString*) comment__
{
    NSString* re$ult = [self comment];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSURL *commentURL;
- (NSURL*) commentURL__
{
    NSURL* re$ult = [self commentURL];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *domain;
- (NSString*) domain__
{
    NSString* re$ult = [self domain];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSDate *expiresDate;
- (NSDate*) expiresDate__
{
    NSDate* re$ult = [self expiresDate];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSString *path;
- (NSString*) path__
{
    NSString* re$ult = [self path];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, copy) NSArray<NSNumber *> *portList;
- (NSArray*) portList__
{
    NSArray* re$ult = [self portList];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly, getter=isSecure) BOOL secure;
- (BOOL) isSecure__
{
    return [self isSecure];
}

// @property(readonly, getter=isSessionOnly) BOOL sessionOnly;
- (BOOL) isSessionOnly__
{
    return [self isSessionOnly];
}

// @property(readonly, copy) NSString *value;
- (NSString*) value__
{
    NSString* re$ult = [self value];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(readonly) NSUInteger version;
- (int) version__
{
    return [self version];
}

@end
