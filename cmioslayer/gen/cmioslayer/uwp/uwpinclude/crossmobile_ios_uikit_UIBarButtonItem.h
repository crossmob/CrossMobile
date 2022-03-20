// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIBarButtonItem definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIImage;
@class crossmobile_ios_uikit_UIView;
@protocol java_lang_Runnable;
@class java_lang_String;
@class java_lang_reflect_Method;
@protocol java_util_Set;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIBarButtonItem$Ext : UIBarButtonItem
@end

#define crossmobile_ios_uikit_UIBarButtonItem UIBarButtonItem
@interface UIBarButtonItem (cm_crossmobile_ios_uikit_UIBarButtonItem)
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___crossmobile_ios_uikit_UIImage_int_java_lang_Runnable:(UIImage*) image :(int) style :(id<java_lang_Runnable>) target ;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___crossmobile_ios_uikit_UIView:(UIView*) customView ;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___int_java_lang_Runnable:(int) systemItem :(id<java_lang_Runnable>) target ;
- (instancetype) __init_crossmobile_ios_uikit_UIBarButtonItem___java_lang_String_int_java_lang_Runnable:(NSString*) title :(int) style :(id<java_lang_Runnable>) target ;
- (void) setCustomView___crossmobile_ios_uikit_UIView:(UIView*) customView ;
- (UIView*) customView__;
- (void) setPossibleTitles___java_util_Set:(NSSet*) possibleTitles ;
- (NSSet*) possibleTitles__;
- (void) setStyle___int:(int) style ;
- (int) style__;
- (void) setTarget___java_lang_Runnable:(id<java_lang_Runnable>) target ;
- (id) target__;
- (void) setWidth___double:(double) width ;
- (double) width__;
@end
