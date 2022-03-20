// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIImagePickerControllerDelegate definition

#import "xmlvm.h"
#import <CoreImage/CoreImage.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIImagePickerController;
@class crossmobile_ios_uikit_UINavigationController;
@class crossmobile_ios_uikit_UIViewController;
@protocol java_util_Map;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIImagePickerControllerDelegate
- (void) didCancel___crossmobile_ios_uikit_UIImagePickerController:(UIImagePickerController*) picker ;
- (void) didFinishPickingMediaWithInfo___crossmobile_ios_uikit_UIImagePickerController_java_util_Map:(UIImagePickerController*) picker :(NSDictionary*) info ;
- (void) didShowViewController___crossmobile_ios_uikit_UINavigationController_crossmobile_ios_uikit_UIViewController_boolean:(UINavigationController*) navigationController :(UIViewController*) viewController :(BOOL) animated ;
- (void) willShowViewController___crossmobile_ios_uikit_UINavigationController_crossmobile_ios_uikit_UIViewController_boolean:(UINavigationController*) navigationController :(UIViewController*) viewController :(BOOL) animated ;
@end
