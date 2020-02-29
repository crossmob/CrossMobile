// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_foundation_NSIndexPath implementation

#import "crossmobile_ios_foundation_NSIndexPath.h"

@implementation crossmobile_ios_foundation_NSIndexPath$Ext

@end

@implementation NSIndexPath (cm_crossmobile_ios_foundation_NSIndexPath)

// + (instancetype)indexPathForRow:(NSInteger)row inSection:(NSInteger)section;
+ (instancetype) indexPathForRow___int_int:(int) row :(int) section 
{
    id re$ult = [NSIndexPath indexPathForRow:row inSection:section];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) NSInteger row;
- (int) row__
{
    return [self row];
}

// @property(nonatomic, readonly) NSInteger section;
- (int) section__
{
    return [self section];
}

@end
