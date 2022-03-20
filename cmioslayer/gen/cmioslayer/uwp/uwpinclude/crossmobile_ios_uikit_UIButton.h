// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIButton definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIEdgeInsets;
@class crossmobile_ios_uikit_UIImage;
@class crossmobile_ios_uikit_UIImageView;
@class crossmobile_ios_uikit_UILabel;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIButton$Ext : UIButton
@end

#define crossmobile_ios_uikit_UIButton UIButton
@interface UIButton (cm_crossmobile_ios_uikit_UIButton)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
+ (instancetype) buttonWithType___int:(int) buttonType ;
- (void) setAdjustsImageWhenDisabled___boolean:(BOOL) adjustsImageWhenDisabled ;
- (BOOL) adjustsImageWhenDisabled__;
- (void) setAdjustsImageWhenHighlighted___boolean:(BOOL) adjustsImageWhenHighlighted ;
- (BOOL) adjustsImageWhenHighlighted__;
- (int) buttonType__;
- (void) setContentEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) contentEdgeInsets ;
- (crossmobile_ios_uikit_UIEdgeInsets*) contentEdgeInsets__;
- (UIImage*) currentBackgroundImage__;
- (UIImage*) currentImage__;
- (NSString*) currentTitle__;
- (UIColor*) currentTitleColor__;
- (UIColor*) currentTitleShadowColor__;
- (void) setImageEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) imageEdgeInsets ;
- (crossmobile_ios_uikit_UIEdgeInsets*) imageEdgeInsets__;
- (UIImageView*) imageView__;
- (void) setShowsTouchWhenHighlighted___boolean:(BOOL) showsTouchWhenHighlighted ;
- (BOOL) showsTouchWhenHighlighted__;
- (void) setTitleEdgeInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) titleEdgeInsets ;
- (crossmobile_ios_uikit_UIEdgeInsets*) titleEdgeInsets__;
- (UILabel*) titleLabel__;
- (UIImage*) backgroundImageForState___int:(int) state ;
- (UIImage*) imageForState___int:(int) state ;
- (void) setBackgroundImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state ;
- (void) setImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) state ;
- (void) setTitle___java_lang_String_int:(NSString*) title :(int) state ;
- (void) setTitleColor___crossmobile_ios_uikit_UIColor_int:(UIColor*) color :(int) state ;
- (void) setTitleShadowColor___crossmobile_ios_uikit_UIColor_int:(UIColor*) color :(int) state ;
- (UIColor*) titleColorForState___int:(int) state ;
- (NSString*) titleForState___int:(int) state ;
- (UIColor*) titleShadowColorForState___int:(int) state ;
@end
