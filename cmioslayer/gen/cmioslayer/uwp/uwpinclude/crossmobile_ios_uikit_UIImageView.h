// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIImageView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIImage;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIImageView$Ext : UIImageView
@end

#define crossmobile_ios_uikit_UIImageView UIImageView
@interface UIImageView (cm_crossmobile_ios_uikit_UIImageView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIImageView__;
- (instancetype) __init_crossmobile_ios_uikit_UIImageView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setAnimationImages___java_util_List:(NSArray*) animationImages ;
- (NSArray*) animationImages__;
- (void) setHighlighted___boolean:(BOOL) highlighted ;
- (BOOL) isHighlighted__;
- (void) setHighlightedAnimationImages___java_util_List:(NSArray*) highlightedAnimationImages ;
- (NSArray*) highlightedAnimationImages__;
- (void) setHighlightedImage___crossmobile_ios_uikit_UIImage:(UIImage*) highlightedImage ;
- (UIImage*) highlightedImage__;
- (void) setImage___crossmobile_ios_uikit_UIImage:(UIImage*) image ;
- (UIImage*) image__;
- (BOOL) isAnimating__;
- (void) startAnimating__;
- (void) stopAnimating__;
@end
