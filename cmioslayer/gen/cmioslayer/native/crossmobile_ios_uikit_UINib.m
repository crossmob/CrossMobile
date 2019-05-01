// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UINib implementation

#import "crossmobile_ios_foundation_NSBundle.h"
#import "crossmobile_ios_foundation_NSData.h"
#import "crossmobile_ios_foundation_NSObject.h"
#import "crossmobile_ios_uikit_UINib.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"
#import "java_util_List.h"
#import "java_util_Map.h"

@implementation crossmobile_ios_uikit_UINib$Ext

// (UINib) - (NSArray *)instantiateWithOwner:(id)ownerOrNil options:(NSDictionary *)optionsOrNil;
- (NSArray*) instantiateWithOwner___crossmobile_ios_foundation_NSObject_java_util_Map:(NSObject*) ownerOrNil :(NSDictionary*) optionsOrNil 
{
    NSArray* re$ult = [super instantiateWithOwner:(ownerOrNil == JAVA_NULL ? nil : ownerOrNil) options:(optionsOrNil == JAVA_NULL ? nil : optionsOrNil)];
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

@implementation UINib (cm_crossmobile_ios_uikit_UINib)

// direct binding of: + (UINib *)nibWithData:(NSData *)data bundle:(NSBundle *)bundleOrNil;
+ (UINib*) nibWithData___crossmobile_ios_foundation_NSData_crossmobile_ios_foundation_NSBundle:(NSData*) data :(NSBundle*) bundleOrNil 
{
    UINib* re$ult = [UINib nibWithData:(data == JAVA_NULL ? nil : data) bundle:(bundleOrNil == JAVA_NULL ? nil : bundleOrNil)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: + (UINib *)nibWithNibName:(NSString *)name bundle:(NSBundle *)bundleOrNil;
+ (UINib*) nibWithNibName___java_lang_String_crossmobile_ios_foundation_NSBundle:(NSString*) name :(NSBundle*) bundleOrNil 
{
    UINib* re$ult = [UINib nibWithNibName:(name == JAVA_NULL ? nil : name) bundle:(bundleOrNil == JAVA_NULL ? nil : bundleOrNil)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UINib__
{
    return [self init];
}

// direct binding of: - (NSArray *)instantiateWithOwner:(id)ownerOrNil options:(NSDictionary *)optionsOrNil;
- (NSArray*) instantiateWithOwner___crossmobile_ios_foundation_NSObject_java_util_Map:(NSObject*) ownerOrNil :(NSDictionary*) optionsOrNil 
{
    NSArray* re$ult = [self instantiateWithOwner:(ownerOrNil == JAVA_NULL ? nil : ownerOrNil) options:(optionsOrNil == JAVA_NULL ? nil : optionsOrNil)];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
