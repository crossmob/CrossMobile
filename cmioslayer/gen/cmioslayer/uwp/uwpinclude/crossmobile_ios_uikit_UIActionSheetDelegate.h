// (c) 2020 under LGPL by CrossMobile plugin tools

// crossmobile_ios_uikit_UIActionSheetDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIActionSheet;

CM_EXPORT_CLASS
@protocol crossmobile_ios_uikit_UIActionSheetDelegate
- (void) cancel___crossmobile_ios_uikit_UIActionSheet:(UIActionSheet*) actionSheet ;
- (void) clickedButtonAtIndex___crossmobile_ios_uikit_UIActionSheet_int:(UIActionSheet*) actionSheet :(int) buttonIndex ;
- (void) didDismissWithButtonIndex___crossmobile_ios_uikit_UIActionSheet_int:(UIActionSheet*) actionSheet :(int) buttonIndex ;
- (void) didPresentActionSheet___crossmobile_ios_uikit_UIActionSheet:(UIActionSheet*) actionSheet ;
- (void) willDismissWithButtonIndex___crossmobile_ios_uikit_UIActionSheet_int:(UIActionSheet*) actionSheet :(int) buttonIndex ;
- (void) willPresentActionSheet___crossmobile_ios_uikit_UIActionSheet:(UIActionSheet*) actionSheet ;
@end
