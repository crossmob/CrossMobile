// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSURLSessionConfiguration implementation

#import "crossmobile_ios_foundation_NSURLSessionConfiguration.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSURLSessionConfiguration$Ext

@end

@implementation NSURLSessionConfiguration (cm_crossmobile_ios_foundation_NSURLSessionConfiguration)

// + (NSURLSessionConfiguration *)backgroundSessionConfigurationWithIdentifier:(NSString *)identifier;
+ (NSURLSessionConfiguration*) backgroundSessionConfigurationWithIdentifier___java_lang_String:(NSString*) identifier 
{
    NSURLSessionConfiguration* re$ult = [NSURLSessionConfiguration backgroundSessionConfigurationWithIdentifier:(identifier == JAVA_NULL ? nil : identifier)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSURLSessionConfiguration__
{
    return [self init];
}

// @property(copy) NSString *sharedContainerIdentifier;
- (void) setSharedContainerIdentifier___java_lang_String:(NSString*) sharedContainerIdentifier 
{
    [self setSharedContainerIdentifier:(sharedContainerIdentifier == JAVA_NULL ? nil : sharedContainerIdentifier)];
}

// @property(copy) NSString *sharedContainerIdentifier;
- (NSString*) sharedContainerIdentifier__
{
    NSString* re$ult = [self sharedContainerIdentifier];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
