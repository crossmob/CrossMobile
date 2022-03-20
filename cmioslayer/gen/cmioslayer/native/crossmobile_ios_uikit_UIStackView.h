// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIStackView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIView;
@class crossmobile_ios_uikit_UIViewAppearance;
@protocol java_util_List;

@interface crossmobile_ios_uikit_UIStackView$Ext : UIStackView
@end

#define crossmobile_ios_uikit_UIStackView UIStackView
@interface UIStackView (cm_crossmobile_ios_uikit_UIStackView)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UIStackView___java_util_List:(NSArray*) views ;
- (void) setAlignment___int:(int) alignment ;
- (int) alignment__;
- (NSArray*) arrangedSubviews__;
- (void) setAxis___int:(int) axis ;
- (int) axis__;
- (void) setBaselineRelativeArrangement___boolean:(BOOL) baselineRelativeArrangement ;
- (BOOL) isBaselineRelativeArrangement__;
- (void) setDistribution___int:(int) distribution ;
- (int) distribution__;
- (void) setLayoutMarginsRelativeArrangement___boolean:(BOOL) layoutMarginsRelativeArrangement ;
- (BOOL) isLayoutMarginsRelativeArrangement__;
- (void) setSpacing___double:(double) spacing ;
- (double) spacing__;
- (void) addArrangedSubview___crossmobile_ios_uikit_UIView:(UIView*) view ;
- (void) insertArrangedSubview___crossmobile_ios_uikit_UIView_int:(UIView*) view :(int) stackIndex ;
- (void) removeArrangedSubview___crossmobile_ios_uikit_UIView:(UIView*) view ;
@end
