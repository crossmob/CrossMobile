// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIButton implementation

#import "crossmobile_ios_uikit_UIButton.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIEdgeInsets.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIImageView.h"
#import "crossmobile_ios_uikit_UILabel.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIButton$Ext

@end

@implementation UIButton (cm_crossmobile_ios_uikit_UIButton)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIButton appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIButton appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// + (instancetype)buttonWithType:(UIButtonType)buttonType;
+ (instancetype) buttonWithType___int:(int) buttonType 
{
    id re$ult = [UIButton buttonWithType:buttonType];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL adjustsImageWhenDisabled;
- (void) setAdjustsImageWhenDisabled___boolean:(BOOL) adjustsImageWhenDisabled 
{
    [self setAdjustsImageWhenDisabled:adjustsImageWhenDisabled];
}

// @property(nonatomic) BOOL adjustsImageWhenDisabled;d;
- (BOOL) adjustsImageWhenDisabled__
{
    return [self adjustsImageWhenDisabled];
}

// @property(nonatomic) BOOL adjustsImageWhenHighlighted;
- (void) setAdjustsImageWhenHighlighted___boolean:(BOOL) adjustsImageWhenHighlighted 
{
    [self setAdjustsImageWhenHighlighted:adjustsImageWhenHighlighted];
}

// @property(nonatomic) BOOL adjustsImageWhenHighlighted;
- (BOOL) adjustsImageWhenHighlighted__
{
    return [self adjustsImageWhenHighlighted];
}

// @property(nonatomic, readonly) UIButtonType buttonType;
- (int) buttonType__
{
    return [self buttonType];
}

// @property(nonatomic) UIEdgeInsets contentEdgeInsets;
- (void) setContentEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) contentEdgeInsets 
{
    [self setContentEdgeInsets:[contentEdgeInsets getUIEdgeInsets]];
}

// @property(nonatomic) UIEdgeInsets contentEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) contentEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self contentEdgeInsets]];
}

// @property(nonatomic, readonly, strong) UIImage *currentBackgroundImage;
- (UIImage*) currentBackgroundImage__
{
    UIImage* re$ult = [self currentBackgroundImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UIImage *currentImage;
- (UIImage*) currentImage__
{
    UIImage* re$ult = [self currentImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) NSString *currentTitle;
- (NSString*) currentTitle__
{
    NSString* re$ult = [self currentTitle];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UIColor *currentTitleColor;
- (UIColor*) currentTitleColor__
{
    UIColor* re$ult = [self currentTitleColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, readonly, strong) UIColor *currentTitleShadowColor;
- (UIColor*) currentTitleShadowColor__
{
    UIColor* re$ult = [self currentTitleShadowColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) UIEdgeInsets imageEdgeInsets;
- (void) setImageEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) imageEdgeInsets 
{
    [self setImageEdgeInsets:[imageEdgeInsets getUIEdgeInsets]];
}

// @property(nonatomic) UIEdgeInsets imageEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) imageEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self imageEdgeInsets]];
}

// @property(nonatomic, readonly, strong) UIImageView *imageView;
- (UIImageView*) imageView__
{
    UIImageView* re$ult = [self imageView];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) BOOL showsTouchWhenHighlighted;
- (void) setShowsTouchWhenHighlighted___boolean:(BOOL) showsTouchWhenHighlighted 
{
    [self setShowsTouchWhenHighlighted:showsTouchWhenHighlighted];
}

// @property(nonatomic) BOOL showsTouchWhenHighlighted;
- (BOOL) showsTouchWhenHighlighted__
{
    return [self showsTouchWhenHighlighted];
}

// @property(nonatomic) UIEdgeInsets titleEdgeInsets;
- (void) setTitleEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) titleEdgeInsets 
{
    [self setTitleEdgeInsets:[titleEdgeInsets getUIEdgeInsets]];
}

// @property(nonatomic) UIEdgeInsets titleEdgeInsets;
- (crossmobile_ios_uikit_UIEdgeInsets*) titleEdgeInsets__
{
    return [[crossmobile_ios_uikit_UIEdgeInsets alloc] initWithUIEdgeInsets:[self titleEdgeInsets]];
}

// @property(nonatomic, readonly, strong) UILabel *titleLabel;
- (UILabel*) titleLabel__
{
    UILabel* re$ult = [self titleLabel];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)backgroundImageForState:(UIControlState)state;
- (UIImage*) backgroundImageForState___int:(int) state 
{
    UIImage* re$ult = [self backgroundImageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIImage *)imageForState:(UIControlState)state;
- (UIImage*) imageForState___int:(int) state 
{
    UIImage* re$ult = [self imageForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)setBackgroundImage:(UIImage *)image forState:(UIControlState)state;
- (void) setBackgroundImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setBackgroundImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// - (void)setImage:(UIImage *)image forState:(UIControlState)state;
- (void) setImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state 
{
    [self setImage:(image == JAVA_NULL ? nil : image) forState:state];
}

// - (void)setTitle:(NSString *)title forState:(UIControlState)state;
- (void) setTitle___java_lang_String_int:(NSString*) title :(int) state 
{
    [self setTitle:(title == JAVA_NULL ? nil : title) forState:state];
}

// - (void)setTitleColor:(UIColor *)color forState:(UIControlState)state;
- (void) setTitleColor___crossmobile_ios_uikit_UIColor_int:(UIColor*) color :(int) state 
{
    [self setTitleColor:(color == JAVA_NULL ? nil : color) forState:state];
}

// - (void)setTitleShadowColor:(UIColor *)color forState:(UIControlState)state;
- (void) setTitleShadowColor___crossmobile_ios_uikit_UIColor_int:(UIColor*) color :(int) state 
{
    [self setTitleShadowColor:(color == JAVA_NULL ? nil : color) forState:state];
}

// - (UIColor *)titleColorForState:(UIControlState)state;
- (UIColor*) titleColorForState___int:(int) state 
{
    UIColor* re$ult = [self titleColorForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (NSString *)titleForState:(UIControlState)state;
- (NSString*) titleForState___int:(int) state 
{
    NSString* re$ult = [self titleForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (UIColor *)titleShadowColorForState:(UIControlState)state;
- (UIColor*) titleShadowColorForState___int:(int) state 
{
    UIColor* re$ult = [self titleShadowColorForState:state];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

@end
