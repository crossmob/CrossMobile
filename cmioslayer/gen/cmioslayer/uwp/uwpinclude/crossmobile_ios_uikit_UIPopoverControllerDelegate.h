// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIPopoverControllerDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIPopoverController;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIPopoverControllerDelegate
- (void) didDismissPopover___crossmobile_ios_uikit_UIPopoverController:(UIPopoverController*) popoverController ;
- (BOOL) shouldDismissPopover___crossmobile_ios_uikit_UIPopoverController:(UIPopoverController*) popoverController ;
@end
