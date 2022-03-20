// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStepper implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIStepper.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIStepper$Ext

@end

@implementation UIStepper (cm_crossmobile_ios_uikit_UIStepper)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIStepper appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIStepper appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIStepper__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIStepper___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic) BOOL autorepeat;
- (void) setAutorepeat___boolean:(BOOL) autorepeat 
{
    [self setAutorepeat:autorepeat];
}

// @property(nonatomic) BOOL autorepeat;
- (BOOL) autorepeat__
{
    return [self autorepeat];
}

// @property(nonatomic, getter=isContinuous) BOOL continuous;
- (void) setContinuous___boolean:(BOOL) continuous 
{
    [self setContinuous:continuous];
}

// @property(nonatomic, getter=isContinuous) BOOL continuous;
- (BOOL) isContinuous__
{
    return [self isContinuous];
}

// @property(nonatomic) double maximumValue;
- (void) setMaximumValue___double:(double) maximumValue 
{
    [self setMaximumValue:maximumValue];
}

// @property(nonatomic) double maximumValue;
- (double) maximumValue__
{
    return [self maximumValue];
}

// @property(nonatomic) double minimumValue;
- (void) setMinimumValue___double:(double) minimumValue 
{
    [self setMinimumValue:minimumValue];
}

// @property(nonatomic) double minimumValue;
- (double) minimumValue__
{
    return [self minimumValue];
}

// @property(nonatomic) double stepValue;
- (void) setStepValue___double:(double) stepValue 
{
    [self setStepValue:stepValue];
}

// @property(nonatomic) double stepValue;
- (double) stepValue__
{
    return [self stepValue];
}

// @property(nonatomic) double value;
- (void) setValue___double:(double) value 
{
    [self setValue:value];
}

// @property(nonatomic) double value;
- (double) value__
{
    return [self value];
}

// @property(nonatomic) BOOL wraps;
- (void) setWraps___boolean:(BOOL) wraps 
{
    [self setWraps:wraps];
}

// @property(nonatomic) BOOL wraps;
- (BOOL) wraps__
{
    return [self wraps];
}

// - (UIImage *)backgroundImageForState:(UIControlState)state;
- (UIImage*) backgroundImageForState___int:(int) state 
{
    UIImage* re$ult = [self backgroundImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)decrementImageForState:(UIControlState)state;
- (UIImage*) decrementImageForState___int:(int) state 
{
    UIImage* re$ult = [self decrementImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)dividerImageForLeftSegmentState:(UIControlState)state rightSegmentState:(UIControlState)state;
- (UIImage*) dividerImageForLeftSegmentState___int_int:(int) state :(int) state 
{
    UIImage* re$ult = [self dividerImageForLeftSegmentState:state rightSegmentState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)incrementImageForState:(UIControlState)state;
- (UIImage*) incrementImageForState___int:(int) state 
{
    UIImage* re$ult = [self incrementImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)setBackgroundImage:(UIImage *)image forState:(UIControlState)state;
- (void) setBackgroundImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setBackgroundImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// - (void)setDecrementImage:(UIImage *)image forState:(UIControlState)state;
- (void) setDecrementImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setDecrementImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// - (void)setDividerImage:(UIImage *)image forLeftSegmentState:(UIControlState)leftState rightSegmentState:(UIControlState)rightState;
- (void) setDividerImage___crossmobile_ios_uikit_UIImage_int_int:(UIImage*) image :(int) leftState :(int) rightState 
{
    [self setDividerImage:(image == JAVA_NULL ? nil : image) forLeftSegmentState:leftState rightSegmentState:rightState];
}

// - (void)setIncrementImage:(UIImage *)image forState:(UIControlState)state;
- (void) setIncrementImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setIncrementImage:(image == JAVA_NULL ? nil : image) forState:state];
}

@end
