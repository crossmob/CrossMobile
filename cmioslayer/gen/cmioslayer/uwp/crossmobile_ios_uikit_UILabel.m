// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UILabel implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_coregraphics_CGSize.h"
#import "crossmobile_ios_uikit_UIColor.h"
#import "crossmobile_ios_uikit_UIFont.h"
#import "crossmobile_ios_uikit_UILabel.h"
#import "crossmobile_ios_uikit_UILabelAppearance.h"
#import "java_lang_String.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UILabel$Ext

@end

@implementation UILabel (cm_crossmobile_ios_uikit_UILabel)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UILabelAppearance alloc] initWithUILabelAppearance:[UILabel appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UILabelAppearance alloc] initWithUILabelAppearance:[UILabel appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UILabel__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UILabel___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic) BOOL adjustsFontSizeToFitWidth;
- (void) setAdjustsFontSizeToFitWidth___boolean:(BOOL) adjustsFontSizeToFitWidth 
{
    [self setAdjustsFontSizeToFitWidth:adjustsFontSizeToFitWidth];
}

// @property(nonatomic) BOOL adjustsFontSizeToFitWidth;
- (BOOL) adjustsFontSizeToFitWidth__
{
    return [self adjustsFontSizeToFitWidth];
}

// @property(nonatomic) UIBaselineAdjustment baselineAdjustment;
- (void) setBaselineAdjustment___int:(int) baselineAdjustment 
{
    [self setBaselineAdjustment:baselineAdjustment];
}

// @property(nonatomic) UIBaselineAdjustment baselineAdjustment;
- (int) baselineAdjustment__
{
    return [self baselineAdjustment];
}

// @property(nonatomic, strong) UIFont *font;
- (void) setFont___crossmobile_ios_uikit_UIFont:(UIFont*) font 
{
    [self setFont:(font == JAVA_NULL ? nil : font)];
}

// @property(nonatomic, strong) UIFont *font;
- (UIFont*) font__
{
    UIFont* re$ult = [self font];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (void) setHighlighted___boolean:(BOOL) highlighted 
{
    [self setHighlighted:highlighted];
}

// @property(nonatomic, getter=isHighlighted) BOOL highlighted;
- (BOOL) isHighlighted__
{
    return [self isHighlighted];
}

// @property(nonatomic, strong) UIColor *highlightedTextColor;
- (void) setHighlightedTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) highlightedTextColor 
{
    [self setHighlightedTextColor:(highlightedTextColor == JAVA_NULL ? nil : highlightedTextColor)];
}

// @property(nonatomic, strong) UIColor *highlightedTextColor;
- (UIColor*) highlightedTextColor__
{
    UIColor* re$ult = [self highlightedTextColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSLineBreakMode lineBreakMode;
- (void) setLineBreakMode___int:(int) lineBreakMode 
{
    [self setLineBreakMode:lineBreakMode];
}

// @property(nonatomic) NSLineBreakMode lineBreakMode;
- (int) lineBreakMode__
{
    return [self lineBreakMode];
}

// @property(nonatomic) CGFloat minimumScaleFactor;
- (void) setMinimumScaleFactor___double:(double) minimumScaleFactor 
{
    [self setMinimumScaleFactor:minimumScaleFactor];
}

// @property(nonatomic) CGFloat minimumScaleFactor;
- (double) minimumScaleFactor__
{
    return [self minimumScaleFactor];
}

// @property(nonatomic) NSInteger numberOfLines;
- (void) setNumberOfLines___int:(int) numberOfLines 
{
    [self setNumberOfLines:numberOfLines];
}

// @property(nonatomic) NSInteger numberOfLines;
- (int) numberOfLines__
{
    return [self numberOfLines];
}

// @property(nonatomic) CGFloat preferredMaxLayoutWidth;
- (void) setPreferredMaxLayoutWidth___double:(double) preferredMaxLayoutWidth 
{
    [self setPreferredMaxLayoutWidth:preferredMaxLayoutWidth];
}

// @property(nonatomic) CGFloat preferredMaxLayoutWidth;
- (double) preferredMaxLayoutWidth__
{
    return [self preferredMaxLayoutWidth];
}

// @property(nonatomic, strong) UIColor *shadowColor;
- (void) setShadowColor___crossmobile_ios_uikit_UIColor:(UIColor*) shadowColor 
{
    [self setShadowColor:(shadowColor == JAVA_NULL ? nil : shadowColor)];
}

// @property(nonatomic, strong) UIColor *shadowColor;
- (UIColor*) shadowColor__
{
    UIColor* re$ult = [self shadowColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) CGSize shadowOffset;
- (void) setShadowOffset___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) shadowOffset 
{
    [self setShadowOffset:[shadowOffset getCGSize]];
}

// @property(nonatomic) CGSize shadowOffset;
- (crossmobile_ios_coregraphics_CGSize*) shadowOffset__
{
    return [[crossmobile_ios_coregraphics_CGSize alloc] initWithCGSize:[self shadowOffset]];
}

// @property(nonatomic, copy) NSString *text;
- (void) setText___java_lang_String:(NSString*) text 
{
    [self setText:(text == JAVA_NULL ? nil : text)];
}

// @property(nonatomic, copy) NSString *text;
- (NSString*) text__
{
    NSString* re$ult = [self text];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic) NSTextAlignment textAlignment;
- (void) setTextAlignment___int:(int) textAlignment 
{
    [self setTextAlignment:textAlignment];
}

// @property(nonatomic) NSTextAlignment textAlignment;
- (int) textAlignment__
{
    return [self textAlignment];
}

// @property(nonatomic, strong) UIColor *textColor;
- (void) setTextColor___crossmobile_ios_uikit_UIColor:(UIColor*) textColor 
{
    [self setTextColor:(textColor == JAVA_NULL ? nil : textColor)];
}

// @property(nonatomic, strong) UIColor *textColor;
- (UIColor*) textColor__
{
    UIColor* re$ult = [self textColor];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (void)drawTextInRect:(CGRect)rect;
- (void) drawTextInRect___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) rect 
{
    [self drawTextInRect:[rect getCGRect]];
}

// - (CGRect)textRectForBounds:(CGRect)bounds limitedToNumberOfLines:(NSInteger)numberOfLines;
- (crossmobile_ios_coregraphics_CGRect*) textRectForBounds___crossmobile_ios_coregraphics_CGRect_int:(crossmobile_ios_coregraphics_CGRect*) bounds :(int) numberOfLines 
{
    return [[crossmobile_ios_coregraphics_CGRect alloc] initWithCGRect:[self textRectForBounds:[bounds getCGRect] limitedToNumberOfLines:numberOfLines]];
}

@end
