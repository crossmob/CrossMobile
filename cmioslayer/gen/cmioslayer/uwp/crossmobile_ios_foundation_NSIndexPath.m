// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.foundation.NSIndexPath implementation

#import "crossmobile_ios_foundation_NSIndexPath.h"
#import "java_lang_Object.h"
#import "java_lang_String.h"

@implementation crossmobile_ios_foundation_NSIndexPath$Ext

// (NSIndexPath) @property(nonatomic, readonly) NSInteger row;
- (int) row__
{
    return [super row];
}

// (NSIndexPath) @property(nonatomic, readonly) NSInteger section;
- (int) section__
{
    return [super section];
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

@implementation NSIndexPath (cm_crossmobile_ios_foundation_NSIndexPath)

// direct binding of: + (instancetype)indexPathForRow:(NSInteger)row inSection:(NSInteger)section;
+ (instancetype) indexPathForRow___int_int:(int) row :(int) section 
{
    id re$ult = [NSIndexPath indexPathForRow:row inSection:section];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// direct binding of: @property(nonatomic, readonly) NSInteger row;
- (int) row__
{
    return [self row];
}

// direct binding of: @property(nonatomic, readonly) NSInteger section;
- (int) section__
{
    return [self section];
}

@end
