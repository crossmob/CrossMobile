// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIScrollViewDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIScrollView;
@class crossmobile_ios_uikit_UIView;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIScrollViewDelegate
- (void) didEndDecelerating___crossmobile_ios_uikit_UIScrollView:(UIScrollView*) scrollView ;
- (void) didEndDragging___crossmobile_ios_uikit_UIScrollView_boolean:(UIScrollView*) scrollView :(BOOL) decelerate ;
- (void) didEndScrollingAnimation___crossmobile_ios_uikit_UIScrollView:(UIScrollView*) scrollView ;
- (void) didEndZooming___crossmobile_ios_uikit_UIScrollView_crossmobile_ios_uikit_UIView_double:(UIScrollView*) scrollView :(UIView*) view :(double) scale ;
- (void) didScroll___crossmobile_ios_uikit_UIScrollView:(UIScrollView*) scrollView ;
- (void) didScrollToTop___crossmobile_ios_uikit_UIScrollView:(UIScrollView*) scrollView ;
- (BOOL) shouldScrollToTop___crossmobile_ios_uikit_UIScrollView:(UIScrollView*) scrollView ;
- (UIView*) viewForZoomingInScrollView___crossmobile_ios_uikit_UIScrollView:(UIScrollView*) scrollView ;
- (void) willBeginDecelerating___crossmobile_ios_uikit_UIScrollView:(UIScrollView*) scrollView ;
- (void) willBeginDragging___crossmobile_ios_uikit_UIScrollView:(UIScrollView*) scrollView ;
@end
