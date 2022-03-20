// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UINib implementation

#import "crossmobile_ios_foundation_NSBundle.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UINib.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UINib$Ext

@end

@implementation UINib (cm_crossmobile_ios_uikit_UINib)

// + (UINib *)nibWithData:(NSData *)data bundle:(NSBundle *)bundleOrNil;
+ (UINib*) nibWithData___crossmobile_ios_foundation_NSData_crossmobile_ios_foundation_NSBundle:(NSData*) data :(NSBundle*) bundleOrNil 
{
    UINib* re$ult = [UINib nibWithData:(data == JAVA_NULL ? nil : data) bundle:(bundleOrNil == JAVA_NULL ? nil : bundleOrNil)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// + (UINib *)nibWithNibName:(NSString *)name bundle:(NSBundle *)bundleOrNil;
+ (UINib*) nibWithNibName___java_lang_String_crossmobile_ios_foundation_NSBundle:(NSString*) name :(NSBundle*) bundleOrNil 
{
    UINib* re$ult = [UINib nibWithNibName:(name == JAVA_NULL ? nil : name) bundle:(bundleOrNil == JAVA_NULL ? nil : bundleOrNil)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UINib__
{
    return [self init];
}

// - (NSArray *)instantiateWithOwner:(id)ownerOrNil options:(NSDictionary *)optionsOrNil;
- (NSArray*) instantiateWithOwner___crossmobile_ios_foundation_NSObject_java_util_Map:(NSObject*) ownerOrNil :(NSDictionary*) optionsOrNil 
{
    NSArray* re$ult = [self instantiateWithOwner:(ownerOrNil == JAVA_NULL ? nil : ownerOrNil) options:(optionsOrNil == JAVA_NULL ? nil : optionsOrNil)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
