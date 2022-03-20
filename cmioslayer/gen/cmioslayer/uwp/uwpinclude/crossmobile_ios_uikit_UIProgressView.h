// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIProgressView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIProgressView$Ext : UIProgressView
@end

#define crossmobile_ios_uikit_UIProgressView UIProgressView
@interface UIProgressView (cm_crossmobile_ios_uikit_UIProgressView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIProgressView___int:(int) style ;
- (void) setProgress___float:(float) progress ;
- (float) progress__;
- (void) setProgressTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) progressTintColor ;
- (UIColor*) progressTintColor__;
- (void) setProgressViewStyle___int:(int) progressViewStyle ;
- (int) progressViewStyle__;
- (void) setTrackTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) trackTintColor ;
- (UIColor*) trackTintColor__;
@end
