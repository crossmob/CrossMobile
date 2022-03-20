// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIScrollView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGPoint;
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_coregraphics_CGSize;
@class crossmobile_ios_uikit_UIEdgeInsets;
@class crossmobile_ios_uikit_UIEvent;
@protocol crossmobile_ios_uikit_UIScrollViewDelegate;
@class crossmobile_ios_uikit_UIView;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;
@protocol java_util_Set;

@interface crossmobile_ios_uikit_UIScrollView$Ext : UIScrollView
@end

#define crossmobile_ios_uikit_UIScrollView UIScrollView
@interface UIScrollView (cm_crossmobile_ios_uikit_UIScrollView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIScrollView__;
- (instancetype) __init_crossmobile_ios_uikit_UIScrollView___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setAlwaysBounceHorizontal___boolean:(BOOL) alwaysBounceHorizontal ;
- (BOOL) alwaysBounceHorizontal__;
- (void) setAlwaysBounceVertical___boolean:(BOOL) alwaysBounceVertical ;
- (BOOL) alwaysBounceVertical__;
- (void) setBounces___boolean:(BOOL) bounces ;
- (BOOL) bounces__;
- (void) setCanCancelContentTouches___boolean:(BOOL) canCancelContentTouches ;
- (BOOL) canCancelContentTouches__;
- (void) setContentInset___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) contentInset ;
- (crossmobile_ios_uikit_UIEdgeInsets*) contentInset__;
- (void) setContentOffset___crossmobile_ios_coregraphics_CGPoint:(crossmobile_ios_coregraphics_CGPoint*) contentOffset ;
- (crossmobile_ios_coregraphics_CGPoint*) contentOffset__;
- (void) setContentSize___crossmobile_ios_coregraphics_CGSize:(crossmobile_ios_coregraphics_CGSize*) contentSize ;
- (crossmobile_ios_coregraphics_CGSize*) contentSize__;
- (BOOL) isDecelerating__;
- (void) setDecelerationRate___double:(double) decelerationRate ;
- (double) decelerationRate__;
- (void) setDelaysContentTouches___boolean:(BOOL) delaysContentTouches ;
- (BOOL) delaysContentTouches__;
- (void) setDelegate___crossmobile_ios_uikit_UIScrollViewDelegate:(id<UIScrollViewDelegate>) delegate ;
- (id<UIScrollViewDelegate>) delegate__;
- (void) setDirectionalLockEnabled___boolean:(BOOL) directionalLockEnabled ;
- (BOOL) isDirectionalLockEnabled__;
- (BOOL) isDragging__;
- (void) setIndicatorStyle___int:(int) indicatorStyle ;
- (int) indicatorStyle__;
- (void) setPagingEnabled___boolean:(BOOL) pagingEnabled ;
- (BOOL) isPagingEnabled__;
- (void) setScrollEnabled___boolean:(BOOL) scrollEnabled ;
- (BOOL) isScrollEnabled__;
- (void) setScrollIndicatorInsets___crossmobile_ios_uikit_UIEdgeInsets:(crossmobile_ios_uikit_UIEdgeInsets*) scrollIndicatorInsets ;
- (crossmobile_ios_uikit_UIEdgeInsets*) scrollIndicatorInsets__;
- (void) setScrollsToTop___boolean:(BOOL) scrollsToTop ;
- (BOOL) scrollsToTop__;
- (void) setShowsHorizontalScrollIndicator___boolean:(BOOL) showsHorizontalScrollIndicator ;
- (BOOL) showsHorizontalScrollIndicator__;
- (void) setShowsVerticalScrollIndicator___boolean:(BOOL) showsVerticalScrollIndicator ;
- (BOOL) showsVerticalScrollIndicator__;
- (BOOL) isTracking__;
- (void) flashScrollIndicators__;
- (void) scrollRectToVisible___crossmobile_ios_coregraphics_CGRect_boolean:(crossmobile_ios_coregraphics_CGRect*) rect :(BOOL) animated ;
- (void) setContentOffset___crossmobile_ios_coregraphics_CGPoint_boolean:(crossmobile_ios_coregraphics_CGPoint*) contentOffset :(BOOL) animated ;
- (BOOL) touchesShouldBegin___java_util_Set_crossmobile_ios_uikit_UIEvent_crossmobile_ios_uikit_UIView:(NSSet*) touches :(UIEvent*) event :(UIView*) view ;
- (BOOL) touchesShouldCancelInContentView___crossmobile_ios_uikit_UIView:(UIView*) view ;
@end
