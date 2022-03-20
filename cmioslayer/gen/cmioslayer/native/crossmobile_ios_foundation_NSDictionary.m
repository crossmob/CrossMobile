// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_foundation_NSDictionary implementation

#import "crossmobile_ios_foundation_NSDictionary.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation NSDictionary (cm_crossmobile_ios_foundation_NSDictionary)

// + (NSDictionary<KeyType,ObjectType> *)dictionaryWithContentsOfFile:(NSString *)path;
+ (NSDictionary*) dictionaryWithContentsOfFile___java_lang_String:(NSString*) path 
{
    NSDictionary* re$ult = [NSDictionary dictionaryWithContentsOfFile:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSDictionary__
{
    return [self init];
}

@end
