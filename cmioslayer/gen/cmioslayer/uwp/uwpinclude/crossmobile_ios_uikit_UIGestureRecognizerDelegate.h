// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIGestureRecognizerDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIGestureRecognizer;
@class crossmobile_ios_uikit_UITouch;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIGestureRecognizerDelegate
- (BOOL) shouldBegin___crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) gestureRecognizer ;
- (BOOL) shouldReceiveTouch___crossmobile_ios_uikit_UIGestureRecognizer_crossmobile_ios_uikit_UITouch:(UIGestureRecognizer*) gestureRecognizer :(UITouch*) touch ;
- (BOOL) shouldRecognizeSimultaneouslyWithGestureRecognizer___crossmobile_ios_uikit_UIGestureRecognizer_crossmobile_ios_uikit_UIGestureRecognizer:(UIGestureRecognizer*) gestureRecognizer :(UIGestureRecognizer*) otherGestureRecognizer ;
@end
