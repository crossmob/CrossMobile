// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIActivityIndicatorView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIActivityIndicatorView$Ext : UIActivityIndicatorView
@end

#define crossmobile_ios_uikit_UIActivityIndicatorView UIActivityIndicatorView
@interface UIActivityIndicatorView (cm_crossmobile_ios_uikit_UIActivityIndicatorView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIActivityIndicatorView__;
- (instancetype) __init_crossmobile_ios_uikit_UIActivityIndicatorView___int:(int) style ;
- (void) setActivityIndicatorViewStyle___int:(int) activityIndicatorViewStyle ;
- (int) activityIndicatorViewStyle__;
- (BOOL) isAnimating__;
- (void) setColor___crossmobile_ios_uikit_UIColor:(UIColor*) color ;
- (UIColor*) color__;
- (void) setHidesWhenStopped___boolean:(BOOL) hidesWhenStopped ;
- (BOOL) hidesWhenStopped__;
- (void) startAnimating__;
- (void) stopAnimating__;
@end
