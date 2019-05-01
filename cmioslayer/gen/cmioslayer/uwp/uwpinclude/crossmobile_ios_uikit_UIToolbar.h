// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIToolbar definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_coregraphics_CGRect;
@class crossmobile_ios_uikit_UIColor;
@protocol java_util_List;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIToolbar$Ext : UIToolbar
@end

#define crossmobile_ios_uikit_UIToolbar UIToolbar
@interface UIToolbar (cm_crossmobile_ios_uikit_UIToolbar)
- (instancetype) __init_crossmobile_ios_uikit_UIToolbar__;
- (instancetype) __init_crossmobile_ios_uikit_UIToolbar___crossmobile_ios_coregraphics_CGRect:(crossmobile_ios_coregraphics_CGRect*) frame ;
- (void) setBarStyle___int:(int) barStyle ;
- (int) barStyle__;
- (void) setBarTintColor___crossmobile_ios_uikit_UIColor:(UIColor*) barTintColor ;
- (UIColor*) barTintColor__;
- (void) setItems___java_util_List:(NSArray*) items ;
- (NSArray*) items__;
- (void) setTranslucent___boolean:(BOOL) translucent ;
- (BOOL) isTranslucent__;
- (void) setItems___java_util_List_boolean:(NSArray*) items :(BOOL) animated ;
@end
