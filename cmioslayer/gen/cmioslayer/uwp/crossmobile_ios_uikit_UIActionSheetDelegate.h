// (c) 2019 under LGPL by CrossMobile plugin tools

// crossmobile.ios.uikit.UIActionSheetDelegate definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIActionSheet;

@protocol crossmobile_ios_uikit_UIActionSheetDelegate
- (void) cancel___crossmobile_ios_uikit_UIActionSheet:(UIActionSheet*) actionSheet ;
- (void) clickedButtonAtIndex___crossmobile_ios_uikit_UIActionSheet_int:(UIActionSheet*) actionSheet :(int) buttonIndex ;
- (void) didDismissWithButtonIndex___crossmobile_ios_uikit_UIActionSheet_int:(UIActionSheet*) actionSheet :(int) buttonIndex ;
- (void) didPresentActionSheet___crossmobile_ios_uikit_UIActionSheet:(UIActionSheet*) actionSheet ;
- (void) willDismissWithButtonIndex___crossmobile_ios_uikit_UIActionSheet_int:(UIActionSheet*) actionSheet :(int) buttonIndex ;
- (void) willPresentActionSheet___crossmobile_ios_uikit_UIActionSheet:(UIActionSheet*) actionSheet ;
@end
