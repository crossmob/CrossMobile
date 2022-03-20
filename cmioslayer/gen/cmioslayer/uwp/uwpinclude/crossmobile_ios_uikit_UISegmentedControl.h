// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UISegmentedControl definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIImage;
@class crossmobile_ios_uikit_UIViewAppearance;
@class java_lang_String;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UISegmentedControl$Ext : UISegmentedControl
@end

#define crossmobile_ios_uikit_UISegmentedControl UISegmentedControl
@interface UISegmentedControl (cm_crossmobile_ios_uikit_UISegmentedControl)
+ (instancetype) appearance__;
+ (instancetype) appearanceWhenContainedInInstancesOfClasses___java_util_List:(NSArray*) containerTypes ;
- (instancetype) __init_crossmobile_ios_uikit_UISegmentedControl__;
- (instancetype) __init_crossmobile_ios_uikit_UISegmentedControl___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (instancetype) __init_crossmobile_ios_uikit_UISegmentedControl___java_util_List:(NSArray*) items ;
- (void) setMomentary___boolean:(BOOL) momentary ;
- (BOOL) isMomentary__;
- (int) numberOfSegments__;
- (void) setSegmentedControlStyle___int:(int) segmentedControlStyle ;
- (int) segmentedControlStyle__;
- (void) setSelectedSegmentIndex___int:(int) selectedSegmentIndex ;
- (int) selectedSegmentIndex__;
- (UIImage*) imageForSegmentAtIndex___int:(int) segment ;
- (void) insertSegmentWithImage___crossmobile_ios_uikit_UIImage_int_boolean:(UIImage*) image :(int) segment :(BOOL) animated ;
- (void) insertSegmentWithTitle___java_lang_String_int_boolean:(NSString*) title :(int) segment :(BOOL) animated ;
- (void) removeAllSegments__;
- (void) removeSegmentAtIndex___int_boolean:(int) segment :(BOOL) animated ;
- (void) setImage___crossmobile_ios_uikit_UIImage_int:(UIImage*) image :(int) segment ;
- (void) setTitle___java_lang_String_int:(NSString*) title :(int) segment ;
- (NSString*) titleForSegmentAtIndex___int:(int) segment ;
@end
