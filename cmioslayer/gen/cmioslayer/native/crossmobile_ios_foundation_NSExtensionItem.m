// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSExtensionItem implementation

#import "crossmobile_ios_foundation_NSExtensionItem.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_foundation_NSExtensionItem$Ext

@end

@implementation NSExtensionItem (cm_crossmobile_ios_foundation_NSExtensionItem)

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSExtensionItem__
{
    return [self init];
}

// @property(copy, nonatomic) NSArray *attachments;
- (void) setAttachments___java_util_List:(NSArray*) attachments 
{
    [self setAttachments:(attachments == JAVA_NULL ? nil : attachments)];
}

// @property(copy, nonatomic) NSArray *attachments;
- (NSArray*) attachments__
{
    NSArray* re$ult = [self attachments];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(copy, nonatomic) NSDictionary *userInfo;
- (void) setUserInfo___java_util_Map:(NSDictionary*) userInfo 
{
    [self setUserInfo:(userInfo == JAVA_NULL ? nil : userInfo)];
}

// @property(copy, nonatomic) NSDictionary *userInfo;
- (NSDictionary*) userInfo__
{
    NSDictionary* re$ult = [self userInfo];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
