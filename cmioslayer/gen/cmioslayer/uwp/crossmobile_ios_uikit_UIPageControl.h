// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIPageControl definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_coregraphics_CGSize;
@class crossmobile_ios_uikit_UIColor;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIPageControl$Ext : UIPageControl
@end

#define crossmobile_ios_uikit_UIPageControl UIPageControl
@interface UIPageControl (cm_crossmobile_ios_uikit_UIPageControl)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIPageControl__;
- (instancetype) __init_crossmobile_ios_uikit_UIPageControl___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setCurrentPage___int:(int) currentPage ;
- (int) currentPage__;
- (void) setCurrentPageIndicatorTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) currentPageIndicatorTintColor ;
- (UIColor*) currentPageIndicatorTintColor__;
- (void) setDefersCurrentPageDisplay___boolean:(BOOL) defersCurrentPageDisplay ;
- (BOOL) defersCurrentPageDisplay__;
- (void) setHidesForSinglePage___boolean:(BOOL) hidesForSinglePage ;
- (BOOL) hidesForSinglePage__;
- (void) setNumberOfPages___int:(int) numberOfPages ;
- (int) numberOfPages__;
- (void) setPageIndicatorTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) pageIndicatorTintColor ;
- (UIColor*) pageIndicatorTintColor__;
- (crossmobile_ios_coregraphics_CGSize*) sizeForNumberOfPages___int:(int) pageCount ;
- (void) updateCurrentPageDisplay__;
@end
