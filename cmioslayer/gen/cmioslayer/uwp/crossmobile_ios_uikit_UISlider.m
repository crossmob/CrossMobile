// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISlider implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UISlider.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UISlider$Ext

@end

@implementation UISlider (cm_crossmobile_ios_uikit_UISlider)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UISlider appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UISlider appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UISlider__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UISlider___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
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

// @property(nonatomic, readonly) UIImage *currentMaximumTrackImage;
- (UIImage*) currentMaximumTrackImage__
{
    UIImage* re$ult = [self currentMaximumTrackImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIImage *currentMinimumTrackImage;
- (UIImage*) currentMinimumTrackImage__
{
    UIImage* re$ult = [self currentMinimumTrackImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly) UIImage *currentThumbImage;
- (UIImage*) currentThumbImage__
{
    UIImage* re$ult = [self currentThumbImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIColor *maximumTrackTintColor;
- (void) setMaximumTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) maximumTrackTintColor 
{
    [self setMaximumTrackTintColor:(maximumTrackTintColor == JAVA_NULL ? nil : maximumTrackTintColor)];
}

// @property(nonatomic, strong) UIColor *maximumTrackTintColor;
- (UIColor*) maximumTrackTintColor__
{
    UIColor* re$ult = [self maximumTrackTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) float maximumValue;
- (void) setMaximumValue___float:(float) maximumValue 
{
    [self setMaximumValue:maximumValue];
}

// @property(nonatomic) float maximumValue;
- (float) maximumValue__
{
    return [self maximumValue];
}

// @property(nonatomic, strong) UIImage *maximumValueImage;
- (void) setMaximumValueImage___crossmobile_ios_uikit_UIImage:(UIImage*) maximumValueImage 
{
    [self setMaximumValueImage:(maximumValueImage == JAVA_NULL ? nil : maximumValueImage)];
}

// @property(nonatomic, strong) UIImage *maximumValueImage;
- (UIImage*) maximumValueImage__
{
    UIImage* re$ult = [self maximumValueImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIColor *minimumTrackTintColor;
- (void) setMinimumTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) minimumTrackTintColor 
{
    [self setMinimumTrackTintColor:(minimumTrackTintColor == JAVA_NULL ? nil : minimumTrackTintColor)];
}

// @property(nonatomic, strong) UIColor *minimumTrackTintColor;
- (UIColor*) minimumTrackTintColor__
{
    UIColor* re$ult = [self minimumTrackTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) float minimumValue;
- (void) setMinimumValue___float:(float) minimumValue 
{
    [self setMinimumValue:minimumValue];
}

// @property(nonatomic) float minimumValue;
- (float) minimumValue__
{
    return [self minimumValue];
}

// @property(nonatomic, strong) UIImage *minimumValueImage;
- (void) setMinimumValueImage___crossmobile_ios_uikit_UIImage:(UIImage*) minimumValueImage 
{
    [self setMinimumValueImage:(minimumValueImage == JAVA_NULL ? nil : minimumValueImage)];
}

// @property(nonatomic, strong) UIImage *minimumValueImage;
- (UIImage*) minimumValueImage__
{
    UIImage* re$ult = [self minimumValueImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIColor *thumbTintColor;
- (void) setThumbTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) thumbTintColor 
{
    [self setThumbTintColor:(thumbTintColor == JAVA_NULL ? nil : thumbTintColor)];
}

// @property(nonatomic, strong) UIColor *thumbTintColor;
- (UIColor*) thumbTintColor__
{
    UIColor* re$ult = [self thumbTintColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) float value;
- (void) setValue___float:(float) value 
{
    [self setValue:value];
}

// @property(nonatomic) float value;
- (float) value__
{
    return [self value];
}

// - (UIImage *)maximumTrackImageForState:(UIControlState)state;
- (UIImage*) maximumTrackImageForState___int:(int) state 
{
    UIImage* re$ult = [self maximumTrackImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)minimumTrackImageForState:(UIControlState)state;
- (UIImage*) minimumTrackImageForState___int:(int) state 
{
    UIImage* re$ult = [self minimumTrackImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)setMaximumTrackImage:(UIImage *)image forState:(UIControlState)state;
- (void) setMaximumTrackImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setMaximumTrackImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// - (void)setMinimumTrackImage:(UIImage *)image forState:(UIControlState)state;
- (void) setMinimumTrackImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setMinimumTrackImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// - (void)setThumbImage:(UIImage *)image forState:(UIControlState)state;
- (void) setThumbImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setThumbImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// - (void)setValue:(float)value animated:(BOOL)animated;
- (void) setValue___float_boolean:(float) value :(BOOL) animated 
{
    [self setValue:value animated:animated];
}

// - (UIImage *)thumbImageForState:(UIControlState)state;
- (UIImage*) thumbImageForState___int:(int) state 
{
    UIImage* re$ult = [self thumbImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
