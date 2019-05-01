// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIActivityIndicatorView definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface crossmobile_ios_uikit_UIActivityIndicatorView$Ext : UIActivityIndicatorView
@end

#define crossmobile_ios_uikit_UIActivityIndicatorView UIActivityIndicatorView
@interface UIActivityIndicatorView (cm_crossmobile_ios_uikit_UIActivityIndicatorView)
- (instancetype) __init_crossmobile_ios_uikit_UIActivityIndicatorView__;
- (instancetype) __init_crossmobile_ios_uikit_UIActivityIndicatorView___int:(int) style ;
- (void) setActivityIndicatorViewStyle___int:(int) activityIndicatorViewStyle ;
- (int) activityIndicatorViewStyle__;
- (void) setHidesWhenStopped___boolean:(BOOL) hidesWhenStopped ;
- (BOOL) hidesWhenStopped__;
- (void) startAnimating__;
- (void) stopAnimating__;
@end
