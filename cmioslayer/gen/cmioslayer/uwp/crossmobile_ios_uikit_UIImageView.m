// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIImageView implementation

#import "crossmobile_ios_coregraphics_CGRect.h"
#import "crossmobile_ios_uikit_UIImage.h"
#import "crossmobile_ios_uikit_UIImageView.h"
#import "crossmobile_ios_uikit_UIViewAppearance.h"
#import "java_util_List.h"

@implementation crossmobile_ios_uikit_UIImageView$Ext

@end

@implementation UIImageView (cm_crossmobile_ios_uikit_UIImageView)

// + (instancetype)appearance;
+ (instancetype) appearance__
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIImageView appearance]];
}

// + (instancetype)appearanceWhenContainedInInstancesOfClasses:(NSArray<Class<UIAppearanceContainer>> *)containerTypes;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes 
{
    return [[crossmobile_ios_uikit_UIViewAppearance alloc] initWithUIViewAppearance:[UIImageView appearanceWhenContainedInInstancesOfClasses:jclass_to_class_list(containerTypes == JAVA_NULL ? nil : containerTypes)]];
}

// -(instancetype) init;
- (instancetype) __init_crossmobile_ios_uikit_UIImageView__
{
    return [self init];
}

// - (instancetype)initWithFrame:(CGRect)frame;
- (instancetype) __init_crossmobile_ios_uikit_UIImageView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame 
{
    return [self initWithFrame:[frame getCGRect]];
}

// @property(nonatomic, copy) NSArray<UIImage *> *animationImages;
- (void) setAnimationImages___java_util_List:(NSArray*) animationImages 
{
    [self setAnimationImages:(animationImages == JAVA_NULL ? nil : animationImages)];
}

// @property(nonatomic, copy) NSArray<UIImage *> *animationImages;
- (NSArray*) animationImages__
{
    NSArray* re$ult = [self animationImages];
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

// @property(nonatomic, copy) NSArray<UIImage *> *highlightedAnimationImages;
- (void) setHighlightedAnimationImages___java_util_List:(NSArray*) highlightedAnimationImages 
{
    [self setHighlightedAnimationImages:(highlightedAnimationImages == JAVA_NULL ? nil : highlightedAnimationImages)];
}

// @property(nonatomic, copy) NSArray<UIImage *> *highlightedAnimationImages;
- (NSArray*) highlightedAnimationImages__
{
    NSArray* re$ult = [self highlightedAnimationImages];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIImage *highlightedImage;
- (void) setHighlightedImage___crossmobile_ios_uikit_UIImage:(UIImage*) highlightedImage 
{
    [self setHighlightedImage:(highlightedImage == JAVA_NULL ? nil : highlightedImage)];
}

// @property(nonatomic, strong) UIImage *highlightedImage;
- (UIImage*) highlightedImage__
{
    UIImage* re$ult = [self highlightedImage];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// @property(nonatomic, strong) UIImage *image;
- (void) setImage___crossmobile_ios_uikit_UIImage:(UIImage*) image 
{
    [self setImage:(image == JAVA_NULL ? nil : image)];
}

// @property(nonatomic, strong) UIImage *image;
- (UIImage*) image__
{
    UIImage* re$ult = [self image];
    return [(re$ult ? re$ult : JAVA_NULL) retain];
}

// - (BOOL)isAnimating;
- (BOOL) isAnimating__
{
    return [self isAnimating];
}

// - (void)startAnimating;
- (void) startAnimating__
{
    [self startAnimating];
}

// - (void)stopAnimating;
- (void) stopAnimating__
{
    [self stopAnimating];
}

@end
