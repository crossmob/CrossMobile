// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIColor definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGColor;
@class crossmobile_ios_uikit_UIImage;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIColor$Ext : UIColor
@end

#define crossmobile_ios_uikit_UIColor UIColor
@interface UIColor (cm_crossmobile_ios_uikit_UIColor)
+ (UIColor*) blackColor__;
+ (UIColor*) blueColor__;
+ (UIColor*) brownColor__;
+ (UIColor*) clearColor__;
+ (UIColor*) colorWithCGColor___crossmobile_ios_coregraphics_CGColor:(crossmobile_ios_coregraphics_CGColor*) cgColor ;
+ (UIColor*) colorWithHueSaturationBrightnessAlpha___double_double_double_double:(double) hue :(double) saturation :(double) brightness :(double) alpha ;
+ (UIColor*) colorWithPatternImage___crossmobile_ios_uikit_UIImage:(UIImage*) image ;
+ (UIColor*) colorWithRedGreenBlueAlpha___double_double_double_double:(double) red :(double) green :(double) blue :(double) alpha ;
+ (UIColor*) colorWithWhiteAlpha___double_double:(double) white :(double) alpha ;
+ (UIColor*) cyanColor__;
+ (UIColor*) darkGrayColor__;
+ (UIColor*) darkTextColor__;
+ (UIColor*) grayColor__;
+ (UIColor*) greenColor__;
+ (UIColor*) groupTableViewBackgroundColor__;
+ (UIColor*) lightGrayColor__;
+ (UIColor*) lightTextColor__;
+ (UIColor*) magentaColor__;
+ (UIColor*) orangeColor__;
+ (UIColor*) purpleColor__;
+ (UIColor*) redColor__;
+ (UIColor*) viewFlipsideBackgroundColor__;
+ (UIColor*) whiteColor__;
+ (UIColor*) yellowColor__;
- (crossmobile_ios_coregraphics_CGColor*) CGColor__;
@end
