// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSTimeZone implementation

#import "crossmobile_ios_foundation_NSTimeZone.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSTimeZone$Ext

@end

@implementation NSTimeZone (cm_crossmobile_ios_foundation_NSTimeZone)

// - (instancetype)initWithName:(NSString *)tzName;
- (instancetype) __init_crossmobile_ios_foundation_NSTimeZone___java_lang_String:(NSString*) tzName 
{
    return [self initWithName:(tzName == JAVA_NULL ? nil : tzName)];
}

// @property(readonly, copy) NSString *name;
- (NSString*) name__
{
    NSString* re$ult = [self name];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
