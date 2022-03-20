// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIRotationGestureRecognizer definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@protocol crossmobile_ios_foundation_NSSelector;
@class java_lang_reflect_Method;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIRotationGestureRecognizer$Ext : UIRotationGestureRecognizer
@end

#define crossmobile_ios_uikit_UIRotationGestureRecognizer UIRotationGestureRecognizer
@interface UIRotationGestureRecognizer (cm_crossmobile_ios_uikit_UIRotationGestureRecognizer)
- (instancetype) __init_crossmobile_ios_uikit_UIRotationGestureRecognizer___crossmobile_ios_foundation_NSSelector:(id<crossmobile_ios_foundation_NSSelector>) target ;
- (void) setRotation___double:(double) rotation ;
- (double) rotation__;
- (double) velocity__;
@end
