// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSDictionary implementation

#import "crossmobile_ios_foundation_NSDictionary.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_Map.h"

@implementation NSDictionary (cm_crossmobile_ios_foundation_NSDictionary)

// direct binding of: + (NSDictionary<KeyType,ObjectType> *)dictionaryWithContentsOfFile:(NSString *)path;
+ (NSDictionary*) dictionaryWithContentsOfFile___java_lang_String:(NSString*) path 
{
    NSDictionary* re$ult = [NSDictionary dictionaryWithContentsOfFile:(path == JAVA_NULL ? nil : path)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_foundation_NSDictionary__
{
    return [self init];
}

@end
