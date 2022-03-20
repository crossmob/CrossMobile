// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISegmentedControl implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UISegmentedControl.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UISegmentedControl$Ext

@end

@implementation UISegmentedControl (cm_crossmobile_ios_uikit_UISegmentedControl)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UISegmentedControl appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UISegmentedControl appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UISegmentedControl__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UISegmentedControl___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// - (instancetype)initWithItems:(NSArray *)items;
- (instancetype) __init_crossmobile_ios_uikit_UISegmentedControl___java_util_List:(NSArray*) items 
{
    return [self initWithItems:(items == JAVA_NULL ? nil : items)];
}

// @property(nonatomic, getter=isMomentary) BOOL momentary;
- (void) setMomentary___boolean:(BOOL) momentary 
{
    [self setMomentary:momentary];
}

// @property(nonatomic, getter=isMomentary) BOOL momentary;
- (BOOL) isMomentary__
{
    return [self isMomentary];
}

// @property(nonatomic, readonly) NSUInteger numberOfSegments;
- (int) numberOfSegments__
{
    return [self numberOfSegments];
}

// @property(nonatomic) UISegmentedControlStyle segmentedControlStyle;
- (void) setSegmentedControlStyle___int:(int) segmentedControlStyle 
{
    [self setSegmentedControlStyle:segmentedControlStyle];
}

// @property(nonatomic) UISegmentedControlStyle segmentedControlStyle;
- (int) segmentedControlStyle__
{
    return [self segmentedControlStyle];
}

// @property(nonatomic) NSInteger selectedSegmentIndex;
- (void) setSelectedSegmentIndex___int:(int) selectedSegmentIndex 
{
    [self setSelectedSegmentIndex:selectedSegmentIndex];
}

// @property(nonatomic) NSInteger selectedSegmentIndex;
- (int) selectedSegmentIndex__
{
    return [self selectedSegmentIndex];
}

// - (UIImage *)imageForSegmentAtIndex:(NSUInteger)segment;
- (UIImage*) imageForSegmentAtIndex___int:(int) segment 
{
    UIImage* re$ult = [self imageForSegmentAtIndex:segment];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)insertSegmentWithImage:(UIImage *)image atIndex:(NSUInteger)segment animated:(BOOL)animated;
- (void) insertSegmentWithImage___crossmobile_ios_uikit_UIImage_int_boolean:(UIImage*) image :(int) segment :(BOOL) animated 
{
    [self insertSegmentWithImage:(image == JAVA_NULL ? nil : image) atIndex:segment animated:animated];
}

// - (void)insertSegmentWithTitle:(NSString *)title atIndex:(NSUInteger)segment animated:(BOOL)animated;
- (void) insertSegmentWithTitle___java_lang_String_int_boolean:(NSString*) title :(int) segment :(BOOL) animated 
{
    [self insertSegmentWithTitle:(title == JAVA_NULL ? nil : title) atIndex:segment animated:animated];
}

// - (void)removeAllSegments;
- (void) removeAllSegments__
{
    [self removeAllSegments];
}

// - (void)removeSegmentAtIndex:(NSUInteger)segment animated:(BOOL)animated;
- (void) removeSegmentAtIndex___int_boolean:(int) segment :(BOOL) animated 
{
    [self removeSegmentAtIndex:segment animated:animated];
}

// - (void)setImage:(UIImage *)image forSegmentAtIndex:(NSUInteger)segment;
- (void) setImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) segment 
{
    [self setImage:(image == JAVA_NULL ? nil : image) forSegmentAtIndex:segment];
}

// - (void)setTitle:(NSString *)title forSegmentAtIndex:(NSUInteger)segment;
- (void) setTitle___java_lang_String_int:(NSString*) title :(int) segment 
{
    [self setTitle:(title == JAVA_NULL ? nil : title) forSegmentAtIndex:segment];
}

// - (NSString *)titleForSegmentAtIndex:(NSUInteger)segment;
- (NSString*) titleForSegmentAtIndex___int:(int) segment 
{
    NSString* re$ult = [self titleForSegmentAtIndex:segment];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
