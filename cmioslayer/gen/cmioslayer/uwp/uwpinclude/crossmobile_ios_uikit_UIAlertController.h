// (c) 2022 by CrossMobile plugin tools
// SPDX-License-Identifier: LGPL-3.0-only

// crossmobile_ios_uikit_UIAlertController definition

#import "xmlvm.h"
#import <CoreGraphics/CoreGraphics.h>
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class crossmobile_ios_uikit_UIAlertAction;
@class crossmobile_ios_uikit_UITextField;
@class java_lang_String;
@protocol java_util_List;
@protocol org_robovm_objc_block_VoidBlock1;

CM_EXPORT_CLASS
@interface crossmobile_ios_uikit_UIAlertController$Ext : UIAlertController
@end

#define crossmobile_ios_uikit_UIAlertController UIAlertController
@interface UIAlertController (cm_crossmobile_ios_uikit_UIAlertController)
+ (instancetype) alertControllerWithTitle___java_lang_String_java_lang_String_int:(NSString*) title :(NSString*) message :(int) preferredStyle ;
- (NSArray*) actions__;
- (void) setMessage___java_lang_String:(NSString*) message ;
- (NSString*) message__;
- (int) preferredStyle__;
- (NSArray*) textFields__;
- (void) addAction___crossmobile_ios_uikit_UIAlertAction:(UIAlertAction*) action ;
- (void) addTextFieldWithConfigurationHandler___org_robovm_objc_block_VoidBlock1:(id<org_robovm_objc_block_VoidBlock1>) configurationHandler ;
@end
